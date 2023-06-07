package com.doanbvph31058.th_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String selectedItemSpinner="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmid = findViewById(R.id.btn_submit);
        EditText edtName = findViewById(R.id.edt_usename);
        EditText edtAddress = findViewById(R.id.edt_address);
        Spinner spSchool = findViewById(R.id.spiner_chool);

        ArrayList<bai1_School_model> list = new ArrayList<>();
        list.add(new bai1_School_model("Hà Nội",R.mipmap.ic_hn));
        list.add(new bai1_School_model("Hồ Chí Minh",R.mipmap.ic_hcm));
        list.add(new bai1_School_model("Đà Nẵng",R.mipmap.ic_dn));
        list.add(new bai1_School_model("Tây Nguyên",R.mipmap.ic_tn));
        list.add(new bai1_School_model("Cần Thơ",R.mipmap.ic_ct));

        //Sau khi khởi tạo ta gắn vào adapter
        bai1_spinner_adapter adapter = new bai1_spinner_adapter(this,list);
        //Sau đó ta sét adapter
        spSchool.setAdapter(adapter);

        //Xử Lý Sự kiện khi người dùng chọn Spinner
        spSchool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemSpinner=((bai1_School_model)spSchool.getItemAtPosition(position)).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Su ly su kien submit
        btnSubmid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();

                    bundle.putString("name",edtName.getText().toString());
                    bundle.putString("address",edtAddress.getText().toString());
                    bundle.putString("branch",selectedItemSpinner);

                    intent.putExtras(bundle);
                    setResult(2,intent);
                    finish();



            }
        });

    }
}