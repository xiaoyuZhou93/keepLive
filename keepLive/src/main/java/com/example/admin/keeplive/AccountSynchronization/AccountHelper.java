package com.example.admin.keeplive.AccountSynchronization;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
/**
 * 创建账户
 * @Author: zhouXiaoyu
 * @Date 2019/6/25 上午 11:17
 * @Param
 */


public class AccountHelper {

    private static final String TAG = "AccountHelper";

    public static final String ACCOUNT_TYPE = "com.dongnao.daemon.account";

    public static void addAccount(Context context) {
        AccountManager am = (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
        //获得此类型的账户
        Account[] accounts = am.getAccountsByType(ACCOUNT_TYPE);
        if (accounts.length > 0) {
            Log.e(TAG, "账户已存在");
            return;
        }
        //给这个账户类型添加一个账户
        Account testaccount = new Account("测试账号同步拉活标题", ACCOUNT_TYPE);
        am.addAccountExplicitly(testaccount, "mytest", new Bundle());
    }

    /**
     * 设置 账户自动同步
     */
    public static void autoSync() {
        Account dongnao = new Account("dongnao", ACCOUNT_TYPE);
        //设置同步
        ContentResolver.setIsSyncable(dongnao, "com.dongnao.daemon.provider", 1);
        //自动同步
        ContentResolver.setSyncAutomatically(dongnao, "com.dongnao.daemon.provider", true);
        //设置同步周期
        ContentResolver.addPeriodicSync(dongnao, "com.dongnao.daemon.provider", new Bundle(), 1);

    }

}