package com.andigeeky.androidlifecyclearchitecture.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;


public class SecondTimerLiveModel extends ViewModel {
    MutableLiveData<Integer> seconds = new MutableLiveData<>();
    Thread thread = null;

    public SecondTimerLiveModel() {
        seconds.setValue(0);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            seconds.setValue(getSeconds().getValue().intValue() + 1);
                            thread.start();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    public MutableLiveData<Integer> getSeconds() {
        return seconds;
    }
}
