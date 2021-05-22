package com.application.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PlayMediaActivity01 extends AppCompatActivity {

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_media01);
        Button btnPlay = super.findViewById(R.id.play);
        Button btnStop = super.findViewById(R.id.stop);

        btnPlay.setOnClickListener(clickListener);
        btnStop.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction("com.application.finalapplication.Music");
            intent.setPackage(getPackageName());
            Toast.makeText(PlayMediaActivity01.this,"背景音乐播放",Toast.LENGTH_SHORT).show();
            switch (v.getId()){
                case R.id.play:
                   bindService(intent, conn, Service.BIND_AUTO_CREATE);
//                    startService(intent);
                    break;

                case R.id.stop:
                   unbindService(conn);
//                    stopService(intent);
                    break;

                default:
                    break;
            }

        }
    };
}