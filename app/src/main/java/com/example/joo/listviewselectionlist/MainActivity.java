package com.example.joo.listviewselectionlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String GROUP_1= "Group One";
    private static final String GROUP_2= "Group Two";
    private static final String GROUP_3= "Group Three";

    ListView listView;
    ArrayAdapter<ChildItem> iAdapter;
    Map<String, List<Items>> map = new HashMap<String, List<Items>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        iAdapter = new ArrayAdapter<ChildItem>(this, android.R.layout.simple_list_item_1);
    }

    private void initData() {
        ChildItem ci;
        List<Items> items = new ArrayList<Items>();

        for (int i = 0 ; i < 5; i++) {
            ci = new ChildItem("item : " + i);
            items.add(ci);
        }
        map.put(GROUP_1, items);
        map.put(GROUP_2, items);
        map.put(GROUP_3, items);

        for (int i = 0; i < map.size(); i++) {
            for(int j = 0; j < map.get(GROUP_1).size(); j++) {
            }
        }
    }
}
