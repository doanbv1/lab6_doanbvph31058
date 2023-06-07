package lamquat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.doanbvph31058.th_intent.R;

public class lab7_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab72);


        ImageView imgview = findViewById(R.id.img_fan);
        Button btnFlast = findViewById(R.id.flast);
        Button btnMedium = findViewById(R.id.medium);
        Button btnSlow = findViewById(R.id.slow);
        Button  btnOff = findViewById(R.id.off);
        Button btnStart = findViewById(R.id.khoi_dong);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dinh nghia hanh dong quay
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        imgview.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(2000)
                                .setInterpolator(new LinearInterpolator())
                                .start();



                    }
                };
                // cho cai anh quat quay
                imgview.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(1000)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });
        btnFlast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dinh nghia hanh dong quay
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        imgview.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(100)
                                .setInterpolator(new LinearInterpolator())
                                .start();



                    }
                };
                // cho cai anh quat quay
                imgview.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(1000)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });
        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dinh nghia hanh dong quay
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        imgview.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(1000)
                                .setInterpolator(new LinearInterpolator())
                                .start();



                    }
                };
                // cho cai anh quat quay
                imgview.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(1000)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });
        btnSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dinh nghia hanh dong quay
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        imgview.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(2000)
                                .setInterpolator(new LinearInterpolator())
                                .start();



                    }
                };
                // cho cai anh quat quay
                imgview.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(2000)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview.animate().cancel();
            }
        });





    }
}