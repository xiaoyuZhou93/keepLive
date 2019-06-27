package com.example.admin.keeplive.onepx;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.keeplive.R;

/**
 * 一像素保活
 *
 * @Author: zhouXiaoyu
 * @Date
 * @Param
 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button open = findViewById(R.id.open);
        Button close = findViewById(R.id.close);
        open.setOnClickListener(this);
        close.setOnClickListener(this);
        intentFilter = new IntentFilter();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open:
                intentFilter.addAction(Intent.ACTION_SCREEN_ON);//不填加这个action模拟器亮屏时候无法检测到
                intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
                registerReceiver(new OnePixelReceiver(), intentFilter);
                break;
            case R.id.close:
                intentFilter.addAction(Intent.ACTION_SCREEN_ON);
                registerReceiver(new OnePixelReceiver(), intentFilter);
                break;


        }
    }
}
