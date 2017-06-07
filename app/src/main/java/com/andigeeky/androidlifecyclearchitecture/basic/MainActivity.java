package com.andigeeky.androidlifecyclearchitecture.basic;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.andigeeky.androidlifecyclearchitecture.R;
import com.andigeeky.androidlifecyclearchitecture.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        loadName();

        activityMainBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitName();
            }
        });
    }

    private void loadName() {
        UserModel userModel = ViewModelProviders.of(this).get(UserModel.class);
        if (userModel.getName() != null) {
            activityMainBinding.txtName.setText(userModel.getName());
        } else {
            activityMainBinding.txtName.setText(getString(R.string.lbl_txt_name));
        }
    }

    private void submitName() {
        Editable name = activityMainBinding.edtName.getText();
        if (name != null && !TextUtils.isEmpty(name.toString())) {
            String msg = getString(R.string.lbl_txt_name) + " " + name.toString();
            activityMainBinding.txtName.setText(msg);
            UserModel userModel = ViewModelProviders.of(this).get(UserModel.class);
            userModel.setName(msg);
        } else {
            Toast.makeText(this, R.string.msg_valid_name, Toast.LENGTH_SHORT).show();
        }
    }
}
