package com.example.doitiente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    

    EditText editTextInput;
    Spinner spinnerQG1;
    Spinner spinnerQG2;
    Button btnSwitch;
    Button btnKQ;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editText_NhapTien);
        spinnerQG1 = findViewById(R.id.spinner_quocgia1);
        spinnerQG2 = findViewById(R.id.spinner_quocgia2);
        btnSwitch = findViewById(R.id.btn_switch);
        btnKQ = findViewById(R.id.btn_ketqua);
        txtKetQua = findViewById(R.id.txt_ketqua);


        ArrayAdapter<CharSequence> adapterQG1 = ArrayAdapter.createFromResource(this,
                R.array.quocgia, android.R.layout.simple_spinner_item);
        adapterQG1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQG1.setAdapter(adapterQG1);

        ArrayAdapter<CharSequence> adapterQG2 = ArrayAdapter.createFromResource(this,
                R.array.quocgia, android.R.layout.simple_spinner_item);
        adapterQG2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQG2.setAdapter(adapterQG2);


        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kq = 0;
                double giaTien = Double.parseDouble(editTextInput.getText().toString());
                String qg1 = spinnerQG1.getSelectedItem().toString();
                String qg2 = spinnerQG2.getSelectedItem().toString();
                kq = changeCurrency(giaTien, qg1, qg2);
                String text = String.valueOf(giaTien) + " " + qg1 + " = " + String.valueOf(kq) + " " + qg2;
                txtKetQua.setText(text);
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kq = 0;
                double giaTien = Double.parseDouble(editTextInput.getText().toString());
                String qg1 = spinnerQG1.getSelectedItem().toString();
                String qg2 = spinnerQG2.getSelectedItem().toString();
                kq = changeCurrency(giaTien, qg2, qg1);
                String text = String.valueOf(giaTien) + " " + qg2 + " = " + String.valueOf(kq) + " " + qg1;
                txtKetQua.setText(text);
            }
        });
    }

    double changeCurrency (double a, String m1, String m2) {
        double kq = 0, x = 1, y = 1;
        switch (m1) {
            case "AUD":
                x = 16158.31;
                break;
            case "CAD":
                x = 17338.45;
                break;
            case "CHF":
                x = 24809.34;
                break;
            case "EUR":
                x = 26656.29;
                break;
            case "USD":
                x = 23310.00;
                break;
            default:
                x = x;
                break;
        }

        switch (m2) {
            case "AUD":
                y = 16158.31;
                break;
            case "CAD":
                y = 17338.45;
                break;
            case "CHF":
                y = 24809.34;
                break;
            case "EUR":
                y = 26656.29;
                break;
            case "USD":
                y = 23310.00;
                break;
            default:
                y = y;
                break;
        }

        kq = a * (x / y);
        return kq;
    }


}