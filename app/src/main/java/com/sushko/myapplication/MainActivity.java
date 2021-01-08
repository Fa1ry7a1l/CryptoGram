package com.sushko.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    private static final String TITLE = "person_name";
    private static final String MESSAGE = "last_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(MainActivity.this, MainWindow1.class);
        startActivity(i);

        final ListView lv = findViewById(R.id.listView);
        fillList(lv);
    }

    private void fillList(ListView listView) {
        ArrayList<HashMap<String, Object>> chatList = new ArrayList<>();
        IntStream.range(1, 20).forEach(i -> {
            addItem(chatList, "Person " + i, "Last message in this chat");
        });

        SimpleAdapter adapter = new SimpleAdapter(this, chatList,
                R.layout.chat_list_item, new String[]{TITLE, MESSAGE},
                new int[]{R.id.name, R.id.message});

        listView.setAdapter(adapter);
    }

    private void addItem(ArrayList<HashMap<String, Object>> chatList, String title, String message) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TITLE, title);
        hashMap.put(MESSAGE, message);
        chatList.add(hashMap);
    }
}