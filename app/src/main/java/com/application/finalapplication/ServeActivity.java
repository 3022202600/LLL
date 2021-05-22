package com.application.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serve);

        Button button9 = (Button)findViewById(R.id.serve1);
        button9.setText("Bind启动方式");
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( ServeActivity.this, PlayMediaActivity01.class);
                startActivity(intent);
            }
        });

        Button button10 = (Button)findViewById(R.id.serve2);
        button10.setText("Start启动方式");
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent( ServeActivity.this, PlayMediaActivity02.class);
                startActivity(intent);
            }
        });

    }
}