package com.example.myapplication;

import android.os.Handler;
import android.os.Message;

public class ThreadConnection extends Thread {

    Handler handler;
    String path;

    public ThreadConnection(Handler handler, String path) {
        this.handler = handler;
        this.path = path;
    }

    public void run() {
        APIConnection apiConnection = new APIConnection();

        byte[] res = apiConnection.get(this.path);

        Message msg = new Message();

        msg.obj = new String(res);

        this.handler.sendMessage(msg);

    }

}
