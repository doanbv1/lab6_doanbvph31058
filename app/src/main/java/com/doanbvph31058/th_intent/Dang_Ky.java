package com.doanbvph31058.th_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dang_Ky extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtcomfirm;
    Button btnDk;

    public static String KEY_NAME = "useName";
    public static String KEY_PASSWORD = "passWord";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        edtUsername = findViewById(R.id.edtusername);
        edtPassword = findViewById(R.id.edtpassword);
        edtcomfirm = findViewById(R.id.edtcomfirm);

        btnDk = findViewById(R.id.btndangky);

        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String useName = edtUsername.getText().toString();
                String passWord = edtPassword.getText().toString();
                String comfirmPW = edtcomfirm.getText().toString();

                if (useName.trim().isEmpty()) {
                    Toast.makeText(Dang_Ky.this, "Bạn chưa nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
                } else if (passWord.trim().isEmpty()) {
                    Toast.makeText(Dang_Ky.this, "Ban chưa nhập passWord", Toast.LENGTH_SHORT).show();
                } else if (comfirmPW.trim().isEmpty()) {
                    Toast.makeText(Dang_Ky.this, "Bạn chưa nhập lại passWord", Toast.LENGTH_SHORT).show();
                } else if (!comfirmPW.equals(passWord)) {
                    Toast.makeText(Dang_Ky.this, "PassWord nhập lại không đúng", Toast.LENGTH_SHORT).show();
                }else {

                    //Khai báo Intent
                    Intent myIntent = new Intent(Dang_Ky.this,Danh_Nhap.class);
                    // Lấy Dữ Liệu


                    //Đưa dữ liệu vào Bundle
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_NAME, useName);
                    bundle.putString(KEY_PASSWORD, passWord);

                    //Đưa dữ liệu vào intent
                    myIntent.putExtras(bundle);
                    //Khởi động
                    startActivity(myIntent);

                }


            }
        });
    }
}