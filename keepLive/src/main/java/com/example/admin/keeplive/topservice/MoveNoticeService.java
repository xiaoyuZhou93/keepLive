package com.example.admin.keeplive.topservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.admin.keeplive.R;

/**
 * 移除通知栏
 * 开启一个同样id的服务再关掉
 * @Author: zhouXiaoyu
 * @Date
 * @Param
 */



public class MoveNoticeService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
            Notification.Builder builder = new Notification.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            startForeground(KeepService.NOTICE_ID, builder.build());
            //关闭自己
            stopForeground(true);
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
