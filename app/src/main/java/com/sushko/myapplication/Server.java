package com.sushko.myapplication;

import android.util.Log;
import android.widget.Toast;

public class Server implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("Server","requenst send");
        ServerReq.updateMessages(0l);
    }
}
