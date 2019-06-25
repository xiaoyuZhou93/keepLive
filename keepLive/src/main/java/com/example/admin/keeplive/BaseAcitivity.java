package com.example.admin.keeplive;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.keeplive.AccountSynchronization.AccountActivity;
import com.example.admin.keeplive.jobscheduler.JobSActivity;
import com.example.admin.keeplive.onepx.MainActivity;
import com.example.admin.keeplive.topservice.TopserviceActivity;

/***
 *
 * @Author: zhouXiaoyu
 * @CreateDate: 2019/6/25
 * @CreateTime: 上午 11:19
 */
public class BaseAcitivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.click1).setOnClickListener(this);
        findViewById(R.id.click2).setOnClickListener(this);
        findViewById(R.id.click3).setOnClickListener(this);
        findViewById(R.id.click4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.click2:
                startActivity(new Intent(this,TopserviceActivity.class));
                break;

            case R.id.click3:
                startActivity(new Intent(this,AccountActivity.class));
                break;

            case R.id.click4:
                startActivity(new Intent(this,JobSActivity.class));
                break;


        }


    }
}
