package com.sheygam.masa_2017_g2_17_01_18_part2;

import android.support.annotation.NonNull;

/**
 * Created by gregorysheygam on 17/01/2018.
 */

public class MySecondThread extends Thread {
    private Callback callback;

    public MySecondThread(@NonNull Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(callback != null){
               callback.handleCount(i);
            }
        }
    }

    public interface Callback{
        void handleCount(int count);
    }
}
