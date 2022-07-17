package com.example.naverblog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TableLayout table;
    private TextView page;
    private EditText input;
    private Button btn_search, btn_prev, btn_next;

    // 크롤링
    private String URL ="https://section.blog.naver.com/Search/Post.naver?pageNo=%d&rangeType=ALL&orderBy=sim&keyword=%s";
    private Integer num = 1;
    private String searched = "";

    // 검색 아이템 리스트
    private ArrayList<BlogItem> blogItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = findViewById(R.id.table);
        input = findViewById(R.id.input);
        btn_search = findViewById(R.id.btn_search);
        btn_prev = findViewById(R.id.btn_prev);
        btn_next = findViewById(R.id.btn_next);
        page = findViewById(R.id.page);

        btn_search.setOnClickListener(btnListener);
        btn_prev.setOnClickListener(btnListener);
        btn_next.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_search: {

                }
                case R.id.btn_prev: {
                    if (num-1 > 0) {
                        num-=1;
                        page.setText(num+" page");
                    }
                }
                case R.id.btn_next: {
                    num += 1;
                    page.setText(num+" page");
                }
            }
        }
    };

    private void search(String url){
        blogItems.clear();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements infos = doc.select(".info_post");

            for (Element info:infos ) {
                String bloger = info.select("div.writer_info a em").text();
                String title = info.select("div.desc a.desc_inner strong span").text();
                String date = info.select("div.writer_info span.date").text();

                blogItems.add(new BlogItem(bloger, title, date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadingTable();
    }

    private void loadingTable(){
        for (BlogItem item: blogItems){
            String bloger = item.getBloger();
            String title = item.getTitle();
            String date = item.getDate();

            TextView bloger_text = new TextView(this);
            TextView title_text = new TextView(this);
            TextView date_text = new TextView(this);

            
            //여기부터

        }
    }

}