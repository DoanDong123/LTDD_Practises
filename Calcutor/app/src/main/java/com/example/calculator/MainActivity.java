package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private Button btnadd, btnsub, btnmulti, btndivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gán giá trị cho biến
        num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnmulti = (Button) findViewById(R.id.btnmulti);
        btndivide = (Button) findViewById(R.id.btndivide);

        //Hàm phép cộng
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = num1.getText().toString();
                String value2 = num2.getText().toString();
                double a = Double.parseDouble(value1);
                double b = Double.parseDouble(value2);
                double kq = a + b;
                Toast.makeText(getApplicationContext(), String.valueOf(kq), Toast.LENGTH_LONG).show();
            }
        });

        //Hàm phép trừ
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = num1.getText().toString();
                String value2 = num2.getText().toString();
                double a = Double.parseDouble(value1);
                double b = Double.parseDouble(value2);
                double kq = a - b;
                Toast.makeText(getApplicationContext(), String.valueOf(kq), Toast.LENGTH_LONG).show();
            }
        });

        //Hàm phép nhân
        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = num1.getText().toString();
                String value2 = num2.getText().toString();
                double a = Double.parseDouble(value1);
                double b = Double.parseDouble(value2);
                double kq = a * b;
                Toast.makeText(getApplicationContext(), String.valueOf(kq), Toast.LENGTH_LONG).show();
            }
        });

        //Hàm phép chia
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = num1.getText().toString();
                String value2 = num2.getText().toString();
                double a = Double.parseDouble(value1);
                double b = Double.parseDouble(value2);
                double kq = a/b;
                Toast.makeText(getApplicationContext(), String.valueOf(kq), Toast.LENGTH_LONG).show();
            }
        });
    }
}
