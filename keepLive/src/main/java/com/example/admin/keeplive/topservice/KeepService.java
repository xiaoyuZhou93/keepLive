package com.example.admin.keeplive.topservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.admin.keeplive.R;
/**
 *
 * @Author: zhouXiaoyu
 * @Date
 * @Param
 */


public class KeepService extends Service {
    private static final String TAG = "KeepService";
    public static final int NOTICE_ID = 100;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "启动前台service");
        //如果API大于18，需要弹出一个可见通知
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            Notification.Builder builder = new Notification.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentTitle("KeepAlive");
            builder.setContentText("keep正在运行...");
            startForeground(NOTICE_ID, builder.build());
            // 去除同通知栏 原理 开启一个同样id的服务再自行关闭
            Intent intent = new Intent(this, MoveNoticeService.class);
            startService(intent);
        } else {
            startForeground(NOTICE_ID, new Notification());
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //  Service被终止当资源允许情况下，重启service
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 如果Service被杀死，干掉通知
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            NotificationManager mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mManager.cancel(NOTICE_ID);
        }
        Log.e(TAG, "前台service被杀死");
        // 重启自己
        Intent intent = new Intent(getApplicationContext(), KeepService.class);
        startService(intent);
    }
}
