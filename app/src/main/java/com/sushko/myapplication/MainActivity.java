package com.sushko.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    private static final String TITLE = "person_name";
    private static final String MESSAGE = "last_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = findViewById(R.id.listView);
        fillList(lv);

        ServerStarter.execute();
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

    static class ServerStarter {

        static ExecutorService executorServer = Executors.newFixedThreadPool(1);

        static void execute() {
            Log.d("Server", "Starting server");
            Server server = new Server();
            executorServer.execute(server);


        }
    }
}