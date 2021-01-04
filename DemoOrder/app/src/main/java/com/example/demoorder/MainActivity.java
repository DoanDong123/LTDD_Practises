package com.example.demoorder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox chkPhoBo, chkBunBo, chkBanhMi, chkHuTiu;
    private Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////
        addListnerOnButtonClick();
    }

    public void addListnerOnButtonClick() {
        chkPhoBo  = (CheckBox) findViewById(R.id.chkPhoBo);
        chkBunBo = (CheckBox) findViewById(R.id.chkBunBo);
        chkBanhMi = (CheckBox) findViewById(R.id.chkBanhMi);
        chkHuTiu = (CheckBox) findViewById(R.id.chkHuTieu);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                double totalAmt = 0;
                StringBuilder result = new StringBuilder();
                result.append("Món được chọn: ");

                if(chkPhoBo.isChecked())
                {
                    result.append("\n\t - Phở bò: 50k");
                    totalAmt += 50000;
                }
                if (chkBunBo.isChecked())
                {
                    result.append("\n\t - Bún bò: 40k");
                    totalAmt += 40000;
                }
                if(chkBanhMi.isChecked())
                {
                    result.append("\n\t - Bánh mì ốp la: 20k");
                    totalAmt += 20000;
                }
                if (chkHuTiu.isChecked())
                {
                    result.append("\n\t - Hủ tíu: 50k");
                    totalAmt += 50000;
                }
                // Format Money
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                String numberAsString = decimalFormat.format(totalAmt);
                result.append("\n\n   ==> Tổng tiền là: " + numberAsString + " VND");

                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
