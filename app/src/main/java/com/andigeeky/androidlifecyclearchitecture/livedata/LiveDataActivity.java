package com.andigeeky.androidlifecyclearchitecture.livedata;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.andigeeky.androidlifecyclearchitecture.R;
import com.andigeeky.androidlifecyclearchitecture.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends LifecycleActivity {
    private ActivityLiveDataBinding activityLiveDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        activityLiveDataBinding = DataBindingUtil.setContentView(this, R
                .layout.activity_live_data);

        startTimer();
    }

    private void startTimer() {
        SecondTimerLiveModel secondTimerLiveModel = ViewModelProviders.of(this).get
                (SecondTimerLiveModel.class);
        if (secondTimerLiveModel == null)
            secondTimerLiveModel = new SecondTimerLiveModel();

        startObserving(secondTimerLiveModel);
    }

    private void startObserving(SecondTimerLiveModel secondTimerLiveModel) {
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                activityLiveDataBinding.txtValueSecond.setText(integer + "");
                if (integer % 2 == 0) {
                    activityLiveDataBinding.btnColor.setBackgroundResource(android.R.color
                            .background_dark);
                    activityLiveDataBinding.btnColor.setTextColor(getColor(android.R.color
                            .background_light));
                } else {
                    activityLiveDataBinding.btnColor.setBackgroundResource(android.R.color
                            .background_light);
                    activityLiveDataBinding.btnColor.setTextColor(getColor(android.R.color
                            .background_dark));
                }

            }
        };
        secondTimerLiveModel.getSeconds().observe(this, observer);
    }
}
