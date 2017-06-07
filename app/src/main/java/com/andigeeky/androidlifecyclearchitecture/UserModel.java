package com.andigeeky.androidlifecyclearchitecture;

import android.arch.lifecycle.ViewModel;

/**
 * Created by E066733 on 6/7/2017.
 */

public class UserModel extends ViewModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
