package com.example.dangkythanhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText hoten;
    EditText userName;
    EditText matKhau;
    EditText ngaySinh;
    Button Tao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        userName = (EditText) findViewById(R.id.editUser);
        hoten = (EditText) findViewById(R.id.editName);
        matKhau= (EditText)findViewById(R.id.editPass);
        ngaySinh =(EditText)findViewById(R.id.editYear);
        Tao = (Button)findViewById(R.id.button);
        Tao.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(hoten.getText().toString().equals("")
                        ||userName.getText().toString().equals("")
                        ||ngaySinh.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Không được để trống!",Toast.LENGTH_LONG).show();
                }else if(userName.getText().toString().contains(" ")
                        ||userName.getText().toString().length() >128
                        ||ktraKtuDacBiet(userName.getText().toString()) == true){
                    Toast.makeText(MainActivity.this,"User không hợp lệ!",Toast.LENGTH_LONG).show();
                }else if(matKhau.getText().toString().length() < 8||
                        DPT(matKhau.getText().toString()) == false||
                        ktraKtuDacBiet(matKhau.getText().toString())== false){
                    Toast.makeText(MainActivity.this,"Mật khẩu không hợp lệ!",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"Bạn đã tạo thành công.",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), HelloActivity.class);
                    intent.putExtra("ten", hoten.getText().toString());
                    startActivity(intent);
                }
            }
            public boolean ktraKtuDacBiet(String s){
                Pattern p = Pattern.compile("[^A-Za-z0-9]");
                Matcher m = p.matcher(s);
                return m.find();
            }
            public  boolean DPT(String s){
                char ch;
                boolean upperCaseFlag = false;
                boolean lowerCaseFlag = false;
                boolean numberFlag = false;
                // duyệt chuỗi input
                for(int i=0;i < s.length();i++) {
                    ch = s.charAt(i);
                    // kiểm tra có 1 số
                    if( Character.isDigit(ch)) {
                        numberFlag = true;
                    }
                    // kiểm tra có 1 chữ hoa
                    else if (Character.isUpperCase(ch)) {
                        upperCaseFlag = true;
                    }
                    // kiểm tra có 1 chữ thường
                    else if (Character.isLowerCase(ch)) {
                        lowerCaseFlag = true;
                    }

                }
                if(numberFlag && upperCaseFlag && lowerCaseFlag)
                    return true;
                return false;
            }
        });
    }
}