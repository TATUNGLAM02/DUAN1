package com.example.duannhom10.User;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duannhom10.R;

public class ThongtinActivity extends AppCompatActivity {
    EditText edttenkhachhang,edtsodienthoai,edtdiachi,edtemail;
    Button btnxacnhanthongtin, btntrove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        edttenkhachhang=(EditText) findViewById(R.id.edittextnhaptenkh);
        edtsodienthoai=(EditText) findViewById(R.id.edittextnhapsodienthoai);
        edtdiachi=(EditText) findViewById(R.id.edittextnhapdiachikh);
        edtemail=(EditText) findViewById(R.id.edittextnhapemail);
        btnxacnhanthongtin=(Button) findViewById(R.id.btnxacnhapthongtin);
        btntrove=(Button) findViewById(R.id.btntrove);
    }

}
