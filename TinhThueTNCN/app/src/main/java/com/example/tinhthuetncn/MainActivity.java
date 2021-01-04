package com.example.tinhthuetncn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextTNTT;
    EditText editTextNPT;
    Spinner spinnerThang;
    Spinner spinnerNam;
    Button btnTinhToan;
    TextView textViewTNTT;
    TextView textViewThueTNCN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNPT = findViewById(R.id.edit_NPT);
        editTextTNTT = findViewById(R.id.edit_TNTT);
        spinnerThang = findViewById(R.id.spinner_Thang);
        spinnerNam = findViewById(R.id.spinner_Nam);
        textViewThueTNCN = findViewById(R.id.txt_TienThueTNCN);
        textViewTNTT = findViewById(R.id.txt_ThuNhapTinhThue);
        btnTinhToan = findViewById(R.id.btn_TinhToan);

        ArrayAdapter<CharSequence> adapterThang = ArrayAdapter.createFromResource(this,
            R.array.thang, android.R.layout.simple_spinner_item);
        adapterThang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerThang.setAdapter(adapterThang);

        ArrayAdapter<CharSequence> adapterNam = ArrayAdapter.createFromResource(this,
                R.array.nam, android.R.layout.simple_spinner_item);
        adapterNam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNam.setAdapter(adapterNam);



        btnTinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thang = spinnerThang.getSelectedItem().toString();
                String nam = spinnerNam.getSelectedItem().toString();

                double nguoiPT = Double.parseDouble(editTextNPT.getText().toString());
                double thuNhapTinhThue = Double.parseDouble(editTextTNTT.getText().toString()) ;
                double thueTNCN = 0;



                if (Integer.parseInt(nam) < 2020 || (Integer.parseInt(nam) == 2020 && Integer.parseInt(thang) < 7))  {
                    thuNhapTinhThue -= (9000000 + nguoiPT *3600000);
                }
                else {
                    thuNhapTinhThue -= (11000000 + nguoiPT *4400000);
                }

                DecimalFormat decimalFormat = new DecimalFormat("#,###,###");

                if (thuNhapTinhThue <= 0) {
                    thuNhapTinhThue = 0;
                    textViewTNTT.setText(decimalFormat.format(thuNhapTinhThue));
                    textViewThueTNCN.setText(decimalFormat.format(thueTNCN));
                }
                else {
                    textViewTNTT.setText(decimalFormat.format(thuNhapTinhThue));
                    thueTNCN = tienthueTNCN(thuNhapTinhThue);
                    textViewThueTNCN.setText(decimalFormat.format(thueTNCN));
                }
            }
        });

    }

    double tienthueTNCN (double a) {
        double kq = 0;
        if (a < 5000000)
            kq =  a * 0.05;
        else if ( a > 5000000 && a <= 10000000)
            kq = a * 0.1 - 250000;
        else if ( a > 10000000 && a <= 18000000 )
            kq = a * 0.15 - 750000;
        else if ( a > 18000000 && a <= 32000000 )
            kq = a * 0.2 - 1650000;
        else if ( a > 32000000 && a <= 52000000 )
            kq = a * 0.25 - 3250000;
        else if ( a > 52000000 && a <= 80000000 )
            kq = a * 0.3 - 5850000;
        else
            kq = a * 0.35 - 9850000;

        return kq;
    }

}