package com.example.admin.keeplive.AccountSynchronization;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.keeplive.R;


/***
 *   账号同步拉活
 * @Author: zhouXiaoyu
 * @CreateDate:
 * @CreateTime:
 */
public class AccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        AccountHelper acchelper = new AccountHelper();
        acchelper.addAccount(this);
        acchelper.autoSync();

    }
}
