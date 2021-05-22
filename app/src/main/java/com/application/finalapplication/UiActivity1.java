package com.application.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UiActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui1);

        /*设置进入界面部分（1）跳转 :LinearLayout*/
        Button button1 = (Button)findViewById(R.id.LinearLayout);
        button1.setText("进入界面部分1:LinearLayout");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( UiActivity1.this,LinearActivity.class);
                startActivity(intent);
            }
        });

        /*设置进入界面部分（1）跳转 :RelativeLayout*/
        /*          选择要点击的Button：jiemian2*/
        Button button2 = (Button)findViewById(R.id.RelativeLayout);
        button2.setText("进入界面部分1:RelativeLayout");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( UiActivity1.this, RelativeActivity.class);
                startActivity(intent);
            }
        });

        /*设置进入界面部分（1）跳转 :TableLayout*/
        /*          选择要点击的Button：jiemian3*/
        Button button3 = (Button)findViewById(R.id.TableLayout);
        button3.setText("进入界面部分1:TableLayout");

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( UiActivity1.this,TableActivity.class);
                startActivity(intent);
            }
        });





    }
}