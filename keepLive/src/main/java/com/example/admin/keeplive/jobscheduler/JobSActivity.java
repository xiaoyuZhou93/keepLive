package com.example.admin.keeplive.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.admin.keeplive.R;

/***
 * JobScheduler 拉活
 * @Author: zhouXiaoyu
 *
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSActivity extends AppCompatActivity {
    private static final String TAG = "JobSActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        initview();

    }

    private void initview() {
        //获取JobScheduler 他是一种系统服务
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.cancelAll();
        JobInfo.Builder builder = new JobInfo.Builder(1024, new ComponentName(getPackageName(), JobProtectService.class.getName()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //android N之后时间必须在15分钟以上
            builder.setPeriodic(15 * 60 * 1000);
        } else {
            builder.setPeriodic(60 * 1000);
        }
        builder.setPersisted(true);

        /**
         * //不管是否有网络这个任务都会被执行
         * JobInfo.NETWORK_TYPE_NONE
         * //任意一种网络任务可以执行
         * JobInfo.NETWORK_TYPE_ANY
         * //它表示设备在WIFI连接时任务才会被执行
         * JobInfo.NETWORK_TYPE_UNMETERED
         */


        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE);
        int schedule = jobScheduler.schedule(builder.build());
        if (schedule <= 0) {
            Log.e(TAG, "schedule error！");
        }

    }
}
