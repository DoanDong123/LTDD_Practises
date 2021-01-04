package com.example.giaxelanbanh;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.annotation.RequiresApi;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String arrLoaiXe[]={
            "Xe du lịch",
            "Xe bán tải",
            "Xe tải nhỏ"};
    String arrDiaPhuong[]={
            "TP.HCM",
            "Đồng Nai",
            "Bình Dương"};

    EditText editTextGiaXe;
    Button buttonTinhToan;
    Spinner spinnerLoaiXe;
    Spinner spinnerDiaPhuong;
    TextView textViewTongCong;
    TextView textViewGiaDamPhan;
    TextView textViewPhiTruocBa;
    TextView textViewPhiDuongBo;
    TextView textViewBaoHiem;
    TextView textViewPhiBienSo;
    TextView textViewDangKiem;
    TextView textViewSoTienTra;

    int diaPhuongChon;
    int loaiXeChon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTongCong = findViewById(R.id.txt_Tongcong);
        textViewGiaDamPhan = findViewById(R.id.txt_Giadamphan);
        textViewPhiTruocBa = findViewById(R.id.txt_PhiTruocBa);
        textViewPhiDuongBo = findViewById(R.id.txt_Phiduongbo);
        textViewBaoHiem = findViewById(R.id.txt_BaoHiemTrachNhiem);
        textViewPhiBienSo = findViewById(R.id.txt_PhiBienSo);
        textViewDangKiem = findViewById(R.id.txt_PhiDangKiem);
        textViewSoTienTra = findViewById(R.id.txtSoTienTra);

        editTextGiaXe = findViewById(R.id.editTextGiaXe);
        buttonTinhToan = findViewById(R.id.btn_TinhToan);
        spinnerLoaiXe = findViewById(R.id.spinner_LoaiXe);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrLoaiXe);
//        adapter.createFromResource(this, R.array.loaixe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerLoaiXe.setAdapter(adapter);


        spinnerDiaPhuong = findViewById(R.id.spinner_DiaPhuong);
        ArrayAdapter<String> adapterDP = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrDiaPhuong);
        adapterDP.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerDiaPhuong.setAdapter(adapterDP);




        buttonTinhToan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                diaPhuongChon = spinnerDiaPhuong.getSelectedItemPosition();
                loaiXeChon =  spinnerLoaiXe.getSelectedItemPosition();
                double tongCong = 0;
                double phiTruocBa = 0;
                double phiDuongBo = 0;
                double baohiem = 0;
                double phiBienSo = 0;
                double phiDangKiem = 0;
                double giaXe = Double.parseDouble(editTextGiaXe.getText().toString());

                //phí trước bạ
                if (diaPhuongChon == 0) {
                    phiTruocBa = giaXe*0.1;
                    tongCong+=  phiTruocBa;
                }
                else {
                    phiTruocBa = giaXe*0.03;
                    tongCong+= phiTruocBa;
                }

                //phí đường bộ
                if (loaiXeChon == 0) {
                    phiDuongBo = phiDuongBo + 1560000;
                    tongCong+= phiDuongBo;
                }
                else if (loaiXeChon == 2){
                    phiDuongBo = phiDuongBo + 2160000;
                    tongCong+= phiDuongBo;
                }
                else{
                    phiDuongBo = phiDuongBo;
                    tongCong+= phiDuongBo;
                }

                //bảo hiểm
                if (loaiXeChon == 0) {
                    baohiem = baohiem + 794000;
                    tongCong+= baohiem;
                }
                else if (loaiXeChon == 1){
                    baohiem = baohiem + 933000;
                    tongCong+= baohiem;
                }
                else{
                    baohiem = baohiem + 953000;
                    tongCong+= baohiem;
                }

                //biển số
                if (diaPhuongChon == 0) {
                    phiBienSo = phiBienSo + 11000000;
                    tongCong+= phiBienSo;
                }
                else {
                    phiBienSo = phiBienSo + 3000000;
                    tongCong+= phiBienSo;
                }

                //phí đăng kiểm
                if (loaiXeChon == 0) {
                    phiDangKiem = phiDangKiem + 340000;
                    tongCong+= phiDangKiem;
                }
                else {
                    phiDangKiem = phiDangKiem + 540000;
                    tongCong+= phiDangKiem;
                }
                DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
                String numberAsString = decimalFormat.format(tongCong + giaXe);
                textViewGiaDamPhan.setText("Giá đàm phàn\t\t\t"+ decimalFormat.format(giaXe) + "\tđ");
                textViewPhiTruocBa.setText("Phí trước bạ\t\t\t"+ decimalFormat.format(phiTruocBa) + "\tđ");
                textViewPhiDuongBo.setText("Phí sử dụng đường bộ\t\t\t"+ decimalFormat.format(phiDuongBo) + "\tđ");
                textViewBaoHiem.setText("Bảo hiểm trách nhiệm dân sự\t\t\t"+ decimalFormat.format(baohiem) + "\tđ");
                textViewPhiBienSo.setText("Phí đăng ký biển số\t\t\t"+ decimalFormat.format(phiBienSo) + "\tđ");
                textViewDangKiem.setText("Phí đăng kiếm\t\t\t"+ decimalFormat.format(phiDangKiem) + "\tđ");

                textViewTongCong.setText("Tổng cộng\t\t\t " + numberAsString + "\tđ");
                textViewSoTienTra.setText("Số tiền trả khi lăn bánh là\n" + numberAsString + "\tđ");



            }
        });


    }


}
