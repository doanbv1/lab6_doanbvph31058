package com.doanbvph31058.th_intent;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Danh_Nhap extends AppCompatActivity {

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_nhap);

        EditText edt_Username = findViewById(R.id.edt_usernameDN);
        EditText edt_Password = findViewById(R.id.edt_password);
        Button btn_Dangnhap = findViewById(R.id.btn_dangnhap);
        Button btn_DangKy = findViewById(R.id.btn_dangky);


        //Lấy dữ liệu ra
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            username = bundle.getString(Dang_Ky.KEY_NAME);
            password = bundle.getString(Dang_Ky.KEY_PASSWORD);
        }
        edt_Username.setText(username);
        edt_Password.setText(password);

        btn_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Danh_Nhap.this, Dang_Ky.class);
                startActivity(intent);
            }
        });
        btn_Dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_Username.getText().toString();
                String pass = edt_Password.getText().toString();

            if(name.trim().isEmpty()){
                Toast.makeText(Danh_Nhap.this, "Bạn chưa chập tên đăng nhập", Toast.LENGTH_SHORT).show();
            } else if (pass.trim().isEmpty()) {
                Toast.makeText(Danh_Nhap.this, "Bạn chưa nhập passWord", Toast.LENGTH_SHORT).show();
            } else if (!name.equals(username) && !pass.equals(password)) {
                Toast.makeText(Danh_Nhap.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Danh_Nhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Danh_Nhap.this, bai2Activity.class));

                }
            }

        });
    }
}