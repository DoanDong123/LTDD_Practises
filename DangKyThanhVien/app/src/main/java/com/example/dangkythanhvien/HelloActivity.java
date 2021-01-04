package com.example.dangkythanhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        textView = (TextView) findViewById(R.id.textHello);
        Intent intent = getIntent();
        String name = intent.getStringExtra("ten");
        textView.setText("Hello: " + name);
    }
}