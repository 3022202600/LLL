package com.application.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,"onCreate");

        /** Called when the activity is first created. */




/*设置跳转到三种布局界面*/
        Button button1 = (Button)findViewById(R.id.UI1);
        button1.setText("界面部分1");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( MainActivity.this,UiActivity1.class);
                startActivity(intent);
            }
        });

 /*       *//*设置进入音乐播放部分跳转*//*
        Button button4 = (Button)findViewById(R.id.serve);
        button4.setText("进入与后台服务部分");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( MainActivity.this, PlayMediaActivity01.class);
                startActivity(intent);
            }
        });*/

       /*设置进入对话框页面：dialog*/
        /*跳转日期对话框*/
        Button button5 = (Button)findViewById(R.id.UI2);
        button5.setText("界面部分2");

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
        /*跳转后台服务部分：音乐播放器*/
        Button button7 = (Button)findViewById(R.id.serve);
        button7.setText("后台服务部分");
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( MainActivity.this, ServeActivity.class);
                startActivity(intent);
            }
        });

        /*跳转广播部分：拍照功能*/
        Button button11 = (Button)findViewById(R.id.broadcast);
        button11.setText("广播部分");
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( MainActivity.this,CameraActivity.class);
                startActivity(intent);

            }
        });

        /*跳转数据库部分：sqlite*/
        Button button12 = (Button)findViewById(R.id.sqlite);
        button12.setText("SQLite部分");
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( MainActivity.this,SQLiteExampleActivity.class);
                startActivity(intent);

            }
        });

}
}