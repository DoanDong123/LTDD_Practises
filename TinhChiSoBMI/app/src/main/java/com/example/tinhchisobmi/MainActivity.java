package com.example.tinhchisobmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText txt_chieucao, txt_cannang;
    RadioButton radioButton_Nam, radioButton_nu;
    Button btn;
    TextView txt_chisosuckhoe, txt_nhanxet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat format = new DecimalFormat("###.#");
                txt_chisosuckhoe.setText(String.valueOf(format.format(chiSoSucKhoe(txt_cannang,txt_chieucao))));
                nhanXet(chiSoSucKhoe(txt_cannang,txt_chieucao),radioButton_Nam,radioButton_nu,txt_nhanxet);
            }
        });
    }

    private void mapping() {
        txt_chieucao = findViewById(R.id.txt_chieucao);
        txt_cannang = findViewById(R.id.txt_cannang);
        radioButton_Nam = findViewById(R.id.radioButton_Nam);
        radioButton_nu = findViewById(R.id.radioButton_nu);
        btn = findViewById(R.id.btn);
        txt_chisosuckhoe = findViewById(R.id.txt_chisosuckhoe);
        txt_nhanxet = findViewById(R.id.txt_nhanxet);
    }

    private double chiSoSucKhoe(EditText cannang, EditText chieucao){
        if(cannang.getText().toString().equals(""))
            cannang.setError("phải nhập cân nặng!");
        else if(chieucao.getText().toString().equals(""))
            chieucao.setError("Phải nhập chiều cao!");
        else
            return Double.parseDouble(cannang.getText().toString()) /
                    ((Double.parseDouble(chieucao.getText().toString()) *
                            Double.parseDouble(chieucao.getText().toString())) / 10000 );
        return 0;
    }

    private void nhanXet(double chiSoBMI, RadioButton nam, RadioButton nu, TextView kq){
        if (nu.isChecked()){
            if (chiSoBMI < 18.5)
                kq.setText("Cân nặng thấp gầy!");
            else if (chiSoBMI >= 18.5 && chiSoBMI < 23)
                kq.setText("Thể trạng bình thường!");
            else if (chiSoBMI == 23)
                kq.setText("Thừa cân, nên vận động phù hợp để giảm cân!");
            else if (chiSoBMI > 23 && chiSoBMI < 25)
                kq.setText("béo phì/Béo phì mức độ thấp!");
            else if (chiSoBMI >= 25 && chiSoBMI < 30)
                kq.setText("Béo phì độ I, cần giảm cân");
            else if (chiSoBMI >= 30 && chiSoBMI < 40)
                kq.setText("Béo phì độ II, cần giảm cân ngay");
            else if (chiSoBMI >= 40)
                kq.setText("Béo phì độ III, cần giảm cân khẩn cấp");
        }
        if (nam.isChecked()){
            if (chiSoBMI < 18.5)
                kq.setText("Cân nặng thấp gầy!");
            else if (chiSoBMI >= 18.5 && chiSoBMI < 25)
                kq.setText("Thể trạng bình thường!");
            else if (chiSoBMI == 25)
                kq.setText("Thừa cân, nên vận động phù hợp để giảm cân!");
            else if (chiSoBMI > 25 && chiSoBMI < 30)
                kq.setText("béo phì/Béo phì mức độ thấp!");
            else if (chiSoBMI >= 30 && chiSoBMI < 35)
                kq.setText("Béo phì độ I, cần giảm cân");
            else if (chiSoBMI >= 35 && chiSoBMI < 40)
                kq.setText("Béo phì độ II, cần giảm cân ngay");
            else if (chiSoBMI >= 40)
                kq.setText("Béo phì độ III, cần giảm cân khẩn cấp");
        }
    }
}
