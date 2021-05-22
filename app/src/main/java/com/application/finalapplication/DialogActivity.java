package com.application.finalapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogActivity<mEditText> extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        /*跳转：日期对话框和时间对话框*/
        Button button6 = (Button)findViewById(R.id.dateBtn);
        button6.setText("进入日期及时间对话框");
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( DialogActivity.this,AlertActivity.class);
                startActivity(intent);
            }
        });

    }


    /*单击此处对话框：启动常规对话框*/
    /*设置只允许点击，是或否 来退出对话框*/
    public void startNormalDialpg(View view){
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle("删除记录确认")
                .setCancelable(false)
                .setMessage("是否确认删除该条记录")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"删除记录成功",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"取消删除记录",Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
   /* *//*启动\带选项列表的对话框*//*
    public void startListDialog(View view){
        String[] colors = {"Green","Black","Red","Purple","Orange"};
        new AlertDialog.Builder(this)
                .setTitle("请选择一种颜色")
                .setCancelable(false)
                .setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,colors[which],Toast.LENGTH_SHORT).show();
                    }
                })  .show();
    }*/

    /*启动进度条对话框*/
    public void startProgressDialog(View view){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("进度条对话框");
        progressDialog.setProgress(20);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<20;i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressDialog.setProgress(progressDialog.getProgress() + 5);
                }
                progressDialog.dismiss();
            }
        }).start();
    }

}