package com.example.joo.listviewselectionlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    SectionAdapter mAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView2);
        mAdapter = new SectionAdapter();
        listView.setAdapter(mAdapter);
        initData();
    }

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int childCount = 2 + r.nextInt(10);
            for (int j = 0; j < childCount; j++) {
                mAdapter.putData("Group " + i, "item " + j);
            }
        }
    }
}
