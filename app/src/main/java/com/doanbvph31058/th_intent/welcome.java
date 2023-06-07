package com.doanbvph31058.th_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class welcome extends AppCompatActivity {
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Gắn Animation vào Activity
        view = findViewById(R.id.imageView);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.chao_mung);
        view.startAnimation(animation);
        //chuyển sang Activity khác
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent intent = new Intent( welcome.this, Danh_Nhap.class);

                 startActivity(intent);
                 finish();
             }
         },3000);

    }
}