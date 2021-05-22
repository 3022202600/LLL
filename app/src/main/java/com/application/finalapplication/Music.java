package com.application.finalapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;


public class Music extends Service {

    private MediaPlayer mediaPlayer;

    public static final String TAG = "wangrui";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        this.mediaPlayer.start();
        Log.d(TAG, "oncreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mediaPlayer.stop();
    }
}
