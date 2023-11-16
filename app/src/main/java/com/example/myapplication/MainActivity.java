package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        ThreadConnection tc = new ThreadConnection(handler, "https://gutendex.com/books/");
        tc.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        TextView tv = this.findViewById(R.id.tvApi);
        tv.setText(message.obj.toString());

        return false;
    }
}