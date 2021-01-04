package com.example.datmon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox_Pizza_PhoMai;
    CheckBox checkBox_Pizza_Gap2;
    CheckBox checkBox_Pizza_Gap3;
    CheckBox checkBox_Hamburger_PhoMai;
    CheckBox checkBox_Hamburger_ThitBo;
    CheckBox checkBox_Hamburger_OpLa;

    RadioGroup radioGroup_Pizza_De;
    RadioGroup radioGroup_Pizza_Vien;
    RadioGroup radioGroup_BanhMi;

    RadioButton radioButton_Pizza_DeMong;
    RadioButton radioButton_Pizza_DeDay;
    RadioButton radioButton_Pizza_DeTruyenThong;
    RadioButton radioButton_Pizza_VienPhoMai;
    RadioButton radioButton_Pizza_VienXucXich;
    RadioButton radioButton_BanhMi_OpLa;
    RadioButton radioButton_BanhMi_PhoMai;
    RadioButton radioButton_BanhMi_ChaCa;

    Button btn_Pizza_Giam;
    Button btn_Pizza_Tang;
    Button btn_Hamburger_Giam;
    Button btn_Hamburger_Tang;
    Button btn_BanhMi_Giam;
    Button btn_BanhMi_Tang;
    Button btn_DatHang;
    Button btn_LamLai;

    TextView textView_Pizza_SoLuong;
    TextView textView_Hamburger_SoLuong;
    TextView textView_BanhMi_SoLuong;
    TextView textView_GiamGia;
    TextView textView_TongTien;

    EditText editText_MaGiamGia;

    int pizza_SoLuong = 0;
    int hamburger_SoLuong = 0;
    int banhMi_SoLuong = 0;

    int loaiPizza = 0;
    int loaiHamburger = 0;
    int loaiBanhMi = 0;

    double giamGia = 0;
    double tongTien = 0;

    final double pizza = 150000;
    final double pizza_ThemPhoMai = 10000;
    final double pizza_DeMong = 5000;
    final double pizza_DeDay = 8000;
    final double pizza_DeTT = 12000;

    final double hamburger = 45000;
    final double hamburger_PhoMai = 12000;
    final double hamburger_ThitBo = 35000;
    final double hamburger_OpLa = 25000;

    final double banhMiOpLa = 25000;
    final double banhMiPhoMai = 50000;
    final double banhMiChaCa = 30000;

    DecimalFormat decimalFormat = new DecimalFormat("#,###,#00.00");

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox_Pizza_PhoMai = findViewById(R.id.checkBox_Pizza_ThemPhoMai);
        checkBox_Pizza_Gap2 = findViewById(R.id.checkBox_Pizza_Gap2PhoMai);
        checkBox_Pizza_Gap3 = findViewById(R.id.checkBox_Pizza_Gap3PhoMai);
        checkBox_Hamburger_PhoMai = findViewById(R.id.checkBox_Hamburger_PhoMai);
        checkBox_Hamburger_ThitBo = findViewById(R.id.checkBox_Hamburger_ThitBo);
        checkBox_Hamburger_OpLa = findViewById(R.id.checkBox_Hamburger_OpLa);

        radioGroup_Pizza_De = findViewById(R.id.radioGroup_Pizza_De);
        radioGroup_Pizza_Vien = findViewById(R.id.radioGroup_Pizza_Vien);
        radioGroup_BanhMi = findViewById(R.id.radioGroup_BanhMi);

        radioButton_Pizza_DeMong = findViewById(R.id.radioButton_Pizza_DeMong);
        radioButton_Pizza_DeDay = findViewById(R.id.radioButton_Pizza_DeDay);
        radioButton_Pizza_DeTruyenThong = findViewById(R.id.radioButton_Pizza_DeTruyenThong);
        radioButton_Pizza_VienPhoMai = findViewById(R.id.radioButton_Pizza_VienPhoMai);
        radioButton_Pizza_VienXucXich = findViewById(R.id.radioButton_Pizza_VienXucXich);
        radioButton_BanhMi_OpLa = findViewById(R.id.radioButton_BanhMi_OpLa);
        radioButton_BanhMi_PhoMai = findViewById(R.id.radioButton_BanhMi_PhoMai);
        radioButton_BanhMi_ChaCa = findViewById(R.id.radioButton_BanhMi_ChaCa);

        btn_Pizza_Giam = findViewById(R.id.btn_Pizza_Giam);
        btn_Pizza_Tang = findViewById(R.id.btn_Pizza_Tang);
        btn_Hamburger_Giam = findViewById(R.id.btn_Hamburger_Giam);
        btn_Hamburger_Tang = findViewById(R.id.btn_Hamburger_Tang);
        btn_BanhMi_Giam = findViewById(R.id.btn_BanhMi_Giam);
        btn_BanhMi_Tang = findViewById(R.id.btn_BanhMi_Tang);
        btn_DatHang = findViewById(R.id.btn_DatHang);
        btn_LamLai = findViewById(R.id.btn_LamLai);

        textView_Pizza_SoLuong = findViewById(R.id.textView_Pizza_SoLuong);
        textView_Hamburger_SoLuong = findViewById(R.id.textView_Hamburger_SoLuong);
        textView_BanhMi_SoLuong = findViewById(R.id.textView_BanhMi_SoLuong);
        textView_GiamGia = findViewById(R.id.txt_GiamGia);
        textView_TongTien = findViewById(R.id.txt_TongTien);

        editText_MaGiamGia = findViewById(R.id.editText_MaGiamGia);

        textView_TongTien.setText(String.valueOf(decimalFormat.format(tongTien)));
        textView_GiamGia.setText(String.valueOf(decimalFormat.format(giamGia)));

        btn_Pizza_Tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pizza_SoLuong += 1;
                textView_Pizza_SoLuong.setText(String.valueOf(pizza_SoLuong));
                TinhTien();
            }
        });
        btn_Pizza_Giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pizza_SoLuong -= 1;
                if(pizza_SoLuong <= 0){
                    pizza_SoLuong = 0;
                    textView_Pizza_SoLuong.setText(String.valueOf(pizza_SoLuong));
                }else{
                    textView_Pizza_SoLuong.setText(String.valueOf(pizza_SoLuong));
                }
                TinhTien();
            }
        });

        btn_Hamburger_Tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hamburger_SoLuong += 1;
                textView_Hamburger_SoLuong.setText(String.valueOf(hamburger_SoLuong));
                TinhTien();
            }
        });
        btn_Hamburger_Giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hamburger_SoLuong -= 1;
                if(hamburger_SoLuong <= 0){
                    hamburger_SoLuong = 0;
                    textView_Hamburger_SoLuong.setText(String.valueOf(hamburger_SoLuong));
                }else{
                    textView_Hamburger_SoLuong.setText(String.valueOf(hamburger_SoLuong));
                }
                TinhTien();
            }
        });

        btn_BanhMi_Tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banhMi_SoLuong += 1;
                textView_BanhMi_SoLuong.setText(String.valueOf(banhMi_SoLuong));
                TinhTien();
            }
        });
        btn_BanhMi_Giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banhMi_SoLuong -= 1;
                if(banhMi_SoLuong <= 0){
                    banhMi_SoLuong = 0;
                    textView_BanhMi_SoLuong.setText(String.valueOf(banhMi_SoLuong));
                }else{
                    textView_BanhMi_SoLuong.setText(String.valueOf(banhMi_SoLuong));
                }
                TinhTien();
            }
        });

        checkBox_Pizza_PhoMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinhTien();
            }
        });
        checkBox_Pizza_Gap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinhTien();
            }
        });
        checkBox_Pizza_Gap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinhTien();
            }
        });
        radioGroup_Pizza_De.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TinhTien();
            }
        });
        radioGroup_Pizza_Vien.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TinhTien();
            }
        });

        checkBox_Hamburger_PhoMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinhTien();
            }
        });
        checkBox_Hamburger_ThitBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinhTien();
            }
        });
        checkBox_Hamburger_OpLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinhTien();
            }
        });

        radioGroup_BanhMi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TinhTien();
            }
        });

        editText_MaGiamGia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TinhTien();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                TinhTien();
            }
        });

        btn_LamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pizza_SoLuong = 0;
                hamburger_SoLuong = 0;
                banhMi_SoLuong = 0;

                giamGia = 0;
                tongTien = 0;

                textView_Pizza_SoLuong.setText(String.valueOf(pizza_SoLuong));
                textView_Hamburger_SoLuong.setText(String.valueOf(hamburger_SoLuong));
                textView_BanhMi_SoLuong.setText(String.valueOf(banhMi_SoLuong));

                textView_TongTien.setText(String.valueOf(decimalFormat.format(tongTien)));
                textView_GiamGia.setText(String.valueOf(decimalFormat.format(giamGia)));

                editText_MaGiamGia.setText("");

                checkBox_Hamburger_OpLa.setChecked(false);
                checkBox_Hamburger_PhoMai.setChecked(false);
                checkBox_Hamburger_ThitBo.setChecked(false);
                checkBox_Pizza_PhoMai.setChecked(false);
                checkBox_Pizza_Gap2.setChecked(false);
                checkBox_Pizza_Gap3.setChecked(false);

//                MainActivity.super.onCreate(savedInstanceState);
            }
        });

        btn_DatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((pizza_SoLuong != 0 || hamburger_SoLuong != 0 || banhMi_SoLuong != 0) && tongTien != 0){
                    Intent intent = new Intent(MainActivity.this, OrderSuccess.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Bạn chưa gọi món", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void TinhTien(){
        //Tiền Pizza
        double pizza = this.pizza;
        if(checkBox_Pizza_PhoMai.isChecked()){
            pizza += this.pizza_ThemPhoMai;
        }
        if(checkBox_Pizza_Gap2.isChecked()){
            pizza += this.pizza_ThemPhoMai*2;
        }
        if(checkBox_Pizza_Gap3.isChecked()){
            pizza += this.pizza_ThemPhoMai*3;
        }
        switch (radioGroup_Pizza_De.getCheckedRadioButtonId()){
            case R.id.radioButton_Pizza_DeMong: pizza += pizza_DeMong; break;
            case R.id.radioButton_Pizza_DeDay: pizza += pizza_DeDay; break;
            case R.id.radioButton_Pizza_DeTruyenThong: pizza += pizza_DeTT; break;
        }
        tongTien = pizza*pizza_SoLuong;

        //Tiền Hamburger
        double hambuger = this.hamburger;
        if(checkBox_Hamburger_PhoMai.isChecked()){
            hambuger += hamburger_PhoMai;
        }
        if(checkBox_Hamburger_ThitBo.isChecked()){
            hambuger += hamburger_ThitBo;
        }
        if(checkBox_Hamburger_OpLa.isChecked()){
            hambuger += hamburger_OpLa;
        }
        tongTien += hambuger*hamburger_SoLuong;

        //Tiền Bánh mì
        double banhMi = 0;
        switch (radioGroup_BanhMi.getCheckedRadioButtonId()){
            case R.id.radioButton_BanhMi_OpLa: banhMi += banhMiOpLa; break;
            case R.id.radioButton_BanhMi_PhoMai: banhMi += banhMiPhoMai; break;
            case R.id.radioButton_BanhMi_ChaCa: banhMi += banhMiChaCa; break;
        }
        tongTien += banhMi*banhMi_SoLuong;

        //Giảm giá
        giamGia = 0;
        switch (editText_MaGiamGia.getText().toString()){
            case "ABC": giamGia = 0.2*tongTien; break;
            case "XYZ": giamGia = 0.1*tongTien; break;
        }
        textView_GiamGia.setText(decimalFormat.format(giamGia));

        tongTien -= giamGia;

        textView_TongTien.setText(decimalFormat.format(tongTien));

    }
}