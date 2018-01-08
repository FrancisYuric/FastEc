package com.example.xushiyun.fastec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latte.app.Latte;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

//        Toast.makeText(Latte.getApplicationContext(), "已经传入Context啦!", Toast.LENGTH_SHORT).show();
    }
}
