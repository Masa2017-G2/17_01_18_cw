package com.sheygam.masa_2017_g2_17_01_18_part2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Handler.Callback, MySecondThread.Callback {

    private Button startBtn;
    private Handler handler;
    private TextView msgTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(this);
        startBtn = findViewById(R.id.start_btn);
        startBtn.setOnClickListener(this);
        msgTxt = findViewById(R.id.msg_txt);
//        ProgressBar myProgress = null;
//        myProgress.setMax(5);
//        myProgress.setProgress(1);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.start_btn){
//            new MyThread(handler).start();
            new MySecondThread(this).start();
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case 1:
                startBtn.setEnabled(false);
                break;
            case 2:
                startBtn.setEnabled(true);
                break;
            case 3:
                msgTxt.setText(String.valueOf(msg.arg1));
                break;
            case 4:
                msgTxt.setText(msg.obj.toString());
                break;

        }
        return true;
    }

    @Override
    public void handleCount(final int count) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                msgTxt.setText(String.valueOf(count));
            }
        });
    }
}
