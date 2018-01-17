package com.sheygam.masa_2017_g2_17_01_18_part2;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by gregorysheygam on 17/01/2018.
 */

public class MyThread extends Thread {
    private Handler handler;

    public MyThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        handler.sendEmptyMessage(1);
        for (int i = 0; i < 100; i++) {
            Log.d("MY_TAG", "run: " + i);
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message msg = handler.obtainMessage(3);
            msg.arg1 = i;
            handler.sendMessage(msg);
        }
        Message msg1 = handler.obtainMessage(4,"All Done");
        handler.sendMessage(msg1);
        handler.sendEmptyMessage(2);
    }
}
