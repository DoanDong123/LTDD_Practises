package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double input1 = 0, input2 = 0;
    boolean Addition, Subtract, Multiplication, Division, decimal, status = false;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnXoa,
            btnDel, btnChia, btnNhan, btnCong, btnTru, btnBang, btnPhay, button23;
    TextView txtKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnPhay = (Button) findViewById(R.id.btnPhay);
        btnBang = (Button) findViewById(R.id.btnBang);
        button23 = (Button) findViewById(R.id.button23);
        txtKq = (TextView) findViewById(R.id.txtKq);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().toString().equals("0") || status) {
                    txtKq.setText("");
                    status = false;
                }
                txtKq.setText(txtKq.getText() + "9");
            }
        });

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtKq.getText().length() != 0){
                    input1 = Float.parseFloat(txtKq.getText() + "");
                    Addition = true;
                    decimal = false;
                    status = true;
                }
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtKq.getText().length() != 0) {
                    input1 = Float.parseFloat(txtKq.getText() + "");
                    Subtract = true;
                    decimal = false;
                    status = true;
                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtKq.getText().length() != 0) {
                    input1 = Float.parseFloat(txtKq.getText() + "");
                    Multiplication = true;
                    decimal = false;
                    status = true;
                }
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtKq.getText().length() != 0) {
                    input1 = Float.parseFloat(txtKq.getText() + "");
                    Division = true;
                    decimal = false;
                    status = true;
                }
            }
        });

        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                if (Addition || Subtract || Multiplication || Division) {
                    input2 = (Double.parseDouble(txtKq.getText().toString()));
                }

                if (Addition) {

                    txtKq.setText(decimalFormat.format(input1 + input2));
                    Addition = false;
                }

                if (Subtract) {

                    txtKq.setText(decimalFormat.format(input1 - input2));
                    Subtract = false;
                }

                if (Multiplication) {
                    txtKq.setText(decimalFormat.format(input1 * input2));
                    Multiplication = false;
                }

                if (Division) {
                    if(input2 != 0) {
                        txtKq.setText(decimalFormat.format(input1 / input2));
                        Division = false;
                    }
                    else txtKq.setText("0");
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtKq.setText("0");
                input1 = 0;
                input2 = 0;
            }
        });

        btnPhay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal) {
                    //do nothing or you can show the error
                } else {
                    txtKq.setText(txtKq.getText() + ".");
                    decimal = true;
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txtKq.getText().toString();
                if(s.length() > 0)
                {
                    s = s.substring(0, s.length() - 1);
                    txtKq.setText(s);
                    if(s.length() == 0)
                        txtKq.setText("0");
                }
            }
        });

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtKq.getText().toString().equals("0")) {
                    double kq = -Double.parseDouble(txtKq.getText().toString());
                    txtKq.setText(String.valueOf(kq));
                }
            }
        });
    }
}
