package com.example.admin.keeplive.AccountSynchronization;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 进行账户同步
 * @Author: zhouXiaoyu
 * @Date
 * @Param
 */


public class SyncService extends Service {
    SyncAdapter syncAdapter;

    private static final String TAG = "SyncService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return syncAdapter.getSyncAdapterBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        syncAdapter = new SyncAdapter(getApplicationContext(), true);
    }

    static class SyncAdapter extends AbstractThreadedSyncAdapter {

        public SyncAdapter(Context context, boolean autoInitialize) {
            super(context, autoInitialize);
        }

        @Override
        public void onPerformSync(Account account, Bundle extras, String authority,
                                  ContentProviderClient provider, SyncResult syncResult) {
            Log.e(TAG,"同步账户");
            //与互联网 或者 本地数据库同步账户
        }
    }
}