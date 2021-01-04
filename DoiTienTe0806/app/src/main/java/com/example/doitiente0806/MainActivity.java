package com.example.doitiente0806;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText editText_Money;
    Spinner spinner_from;
    Spinner spinner_to;
    Button btn_switch;
    Button btn_submit;

    TextView txt_from;
    TextView txt_to;
    TextView txt_detail;

    double money = 1;
    double temp = 1;
    double result = 1;
//    int from = 0;
//    int to = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_Money = findViewById(R.id.editText_money);
        btn_switch = findViewById(R.id.button_switch);
        btn_submit = findViewById(R.id.button_submit);
        txt_from = findViewById(R.id.txt_from);
        txt_to = findViewById(R.id.txt_to);
        txt_detail = findViewById(R.id.txt_detail);

        spinner_from = findViewById(R.id.spinner_from);
        spinner_to = findViewById(R.id.spinner_to);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cac_loai_tien, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter);
        spinner_to.setAdapter(adapter);

        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = spinner_from.getSelectedItemPosition();
                spinner_from.setSelection(spinner_to.getSelectedItemPosition());
                spinner_to.setSelection(temp);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money = Double.parseDouble(editText_Money.getText().toString());

                switch (spinner_from.getSelectedItemPosition()){
                    case 0: temp = money; break;
                    case 1: temp = money*23000; break;
                    case 2: temp = money*26000; break;
                    case 3: temp = money*214; break;
                    case 4: temp = money*29400; break;
                }
                switch (spinner_to.getSelectedItemPosition()){
                    case 0: result = temp; break;
                    case 1: result = temp/23000; break;
                    case 2: result = temp/26000; break;
                    case 3: result = temp/214; break;
                    case 4: result = temp/29400; break;
                }
                DecimalFormat df = new DecimalFormat("#,###,###.######");

                txt_from.setText(df.format(money) + " " + spinner_from.getSelectedItem().toString() + " =\n");
                txt_to.setText(df.format(result) + " " + spinner_to.getSelectedItem().toString());

                txt_detail.setText(df.format(money) + " " + spinner_from.getSelectedItem().toString() + " = " + df.format(result) + " " + spinner_to.getSelectedItem().toString() + "\n" +
                        df.format(result) + " " + spinner_to.getSelectedItem().toString() + " = " + df.format(money) + " " + spinner_from.getSelectedItem().toString());

            }
        });
    }
}
