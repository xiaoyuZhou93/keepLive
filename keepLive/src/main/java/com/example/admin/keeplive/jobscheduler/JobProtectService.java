package com.example.admin.keeplive.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobProtectService extends JobService {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e("jobservice", "doJob: "+ "doJob做了操作" );
        return false;
    }



    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

}