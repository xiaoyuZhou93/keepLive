package com.example.admin.keeplive.topservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.keeplive.R;

/**
 * 前台service 保活
 * @Author: zhouXiaoyu
 * @Date
 * @Param
 */


public class TopserviceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topservice);
        startService(new Intent(this,KeepService.class));
    }
}
