package com.example.vaytieudung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editText_ThuNhapHangThang;
    EditText editText_ChiPhiTrongThang;
    EditText editText_SoTienMuonVay;

    Spinner spinner_LaiSuatMongMuon;

    Button button_TinhToan;

    TextView textView_KetQua;

    RadioGroup radioGroup_ThoiGianVay1;
    RadioGroup radioGroup_ThoiGianVay2;
    RadioGroup radioGroup_ThoiGianVay3;

    RadioButton radioButton_12;
    RadioButton radioButton_18;
    RadioButton radioButton_24;
    RadioButton radioButton_30;
    RadioButton radioButton_36;
    RadioButton radioButton_42;
    RadioButton radioButton_48;
    RadioButton radioButton_54;
    RadioButton radioButton_60;

    double thuNhap = 0;
    double chiPhi = 0;
    double soTienMuonVay = 0;

    double laiSuatMongMuon = 0;
    int thoiGianVay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_ThuNhapHangThang = findViewById(R.id.editText_ThuNhapHangThang);
        editText_ChiPhiTrongThang = findViewById(R.id.editText_ChiPhiTrongThang);
        editText_SoTienMuonVay = findViewById(R.id.editText_SoTienMuonVay);

        button_TinhToan = findViewById(R.id.button_TinhToan);
        textView_KetQua = findViewById(R.id.txt_KetQua);

        radioButton_12 = findViewById(R.id.radioButton_12);
        radioButton_18 = findViewById(R.id.radioButton_18);
        radioButton_24 = findViewById(R.id.radioButton_24);

        radioButton_30 = findViewById(R.id.radioButton_30);
        radioButton_36 = findViewById(R.id.radioButton_36);
        radioButton_42 = findViewById(R.id.radioButton_42);

        radioButton_48 = findViewById(R.id.radioButton_48);
        radioButton_54 = findViewById(R.id.radioButton_54);
        radioButton_60 = findViewById(R.id.radioButton_60);

        radioGroup_ThoiGianVay1 = findViewById(R.id.radioGroup_ThoiGianVay1);
        radioGroup_ThoiGianVay2 = findViewById(R.id.radioGroup_ThoiGianVay2);
        radioGroup_ThoiGianVay3 = findViewById(R.id.radioGroup_ThoiGianVay3);

        View.OnClickListener mG1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup_ThoiGianVay2.clearCheck();
                radioGroup_ThoiGianVay3.clearCheck();
            }
        };

        View.OnClickListener mG2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup_ThoiGianVay1.clearCheck();
                radioGroup_ThoiGianVay3.clearCheck();
            }
        };

        View.OnClickListener mG3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup_ThoiGianVay2.clearCheck();
                radioGroup_ThoiGianVay1.clearCheck();
            }
        };

        radioButton_12.setOnClickListener(mG1);
        radioButton_18.setOnClickListener(mG1);
        radioButton_24.setOnClickListener(mG1);

        radioButton_30.setOnClickListener(mG2);
        radioButton_36.setOnClickListener(mG2);
        radioButton_42.setOnClickListener(mG2);

        radioButton_48.setOnClickListener(mG3);
        radioButton_54.setOnClickListener(mG3);
        radioButton_60.setOnClickListener(mG3);

        spinner_LaiSuatMongMuon = findViewById(R.id.spinner_LaiSuatMongMuon);

        ArrayAdapter<CharSequence> adapterThang = ArrayAdapter.createFromResource(this,
                R.array.laiSuatMongMuon, android.R.layout.simple_spinner_item);
        adapterThang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_LaiSuatMongMuon.setAdapter(adapterThang);

        button_TinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    thuNhap = Double.parseDouble(editText_ThuNhapHangThang.getText().toString());
                    chiPhi = Double.parseDouble(editText_ChiPhiTrongThang.getText().toString());
                    soTienMuonVay = Double.parseDouble(editText_SoTienMuonVay.getText().toString());

                    if(soTienMuonVay > 10*(thuNhap - chiPhi)){
                        Toast.makeText(getApplication(), "Số tiền muốn vay không hợp lệ", Toast.LENGTH_LONG).show();
                    }else if(soTienMuonVay < 20000000){
                        Toast.makeText(getApplication(), "Số tiền cần vay không được nhỏ hơn 20,000,000", Toast.LENGTH_LONG).show();
                    }else{
                        switch (spinner_LaiSuatMongMuon.getSelectedItemPosition()){
                            case 0: laiSuatMongMuon = 0.16; break;
                            case 1: laiSuatMongMuon = 0.17; break;
                            case 2: laiSuatMongMuon = 0.18; break;
                        }

                        switch (radioGroup_ThoiGianVay1.getCheckedRadioButtonId()){
                            case R.id.radioButton_12: thoiGianVay = 12; break;
                            case R.id.radioButton_18: thoiGianVay = 18; break;
                            case R.id.radioButton_24: thoiGianVay = 24; break;
                        }
                        switch (radioGroup_ThoiGianVay2.getCheckedRadioButtonId()){
                            case R.id.radioButton_30: thoiGianVay = 30; break;
                            case R.id.radioButton_36: thoiGianVay = 36; break;
                            case R.id.radioButton_42: thoiGianVay = 42; break;
                        }
                        switch (radioGroup_ThoiGianVay3.getCheckedRadioButtonId()){
                            case R.id.radioButton_48: thoiGianVay = 48; break;
                            case R.id.radioButton_54: thoiGianVay = 56; break;
                            case R.id.radioButton_60: thoiGianVay = 60; break;
                        }

                        double ketQua = soTienMuonVay * Math.pow((1+laiSuatMongMuon), thoiGianVay/12) / thoiGianVay;
                        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.00");
                        textView_KetQua.setText(decimalFormat.format(ketQua));
                    }
                }catch (Exception ex){
                    Toast.makeText(getApplication(), "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}