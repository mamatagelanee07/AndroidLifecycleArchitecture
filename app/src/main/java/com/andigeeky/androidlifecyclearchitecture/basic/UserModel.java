package com.andigeeky.androidlifecyclearchitecture.basic;

import android.arch.lifecycle.ViewModel;


public class UserModel extends ViewModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
