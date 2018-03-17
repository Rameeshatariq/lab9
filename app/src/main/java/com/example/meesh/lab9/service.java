package com.example.meesh.lab9;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by meesh on 3/8/2018.
 */

public class service extends Service {
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "Service Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
        startTimer();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopTimer();
        Toast.makeText(getApplicationContext(), "Service Destroyed", Toast.LENGTH_SHORT).show();

    }
    public  void startTimer(){
        timer= new Timer();
        handler= new Handler();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(service.this, "Service Running", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        };
        timer.schedule(timerTask,0,5000);
    }
    public void stopTimer(){
        timer.cancel();
    }
}
