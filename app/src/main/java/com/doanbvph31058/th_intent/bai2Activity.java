package com.doanbvph31058.th_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class bai2Activity extends AppCompatActivity {

    bai2_adapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        Toolbar toolbar = findViewById(R.id.tl_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("DoanBV_PH31058");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button button = findViewById(R.id.btn_add);
        ListView listView = findViewById(R.id.lvbrach);


//

//        Intent intent = this.getIntent();
//
//        String name = intent.getStringExtra(MainActivity.)

        ArrayList<bai2_student>  list = new ArrayList<>();
        list.add(new bai2_student("Foly Hà Nội","Nguyen Van A","Hà Nội"));

        list.add(new bai2_student("Foly Đà Nẵng","Nguyen Van B","Đà Nẵng"));

        list.add(new bai2_student("Foly Huế","Nguyen Van C","Huế"));

        list.add(new bai2_student("Foly Hà Nội","Nguyen Van D","Hà Nội"));
//        list.add(new bai2_student(name, add))

        adapter = new bai2_adapter(this,list);
        listView.setAdapter(adapter);


        // cai dat  co che lang nghe Activity For Result

        ActivityResultLauncher<Intent> getData=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==2){
                            Intent intent = result.getData(); // lấy về dữ liệu
                            Bundle bundle = intent.getExtras();// lấy về gói dữ liệu
                            String name = bundle.getString("name");
                            String branch = bundle.getString("branch");
                            String address = bundle.getString("address");

                            list.add(new bai2_student(branch,name,address));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
        );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(bai2Activity.this,MainActivity.class);
                getData.launch(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        MenuItem mymenuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) mymenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuDangXuat){
            Intent intent = new Intent(this, Danh_Nhap.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_add){
            Intent intent = new Intent(this, Dang_Ky.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}