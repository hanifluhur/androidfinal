package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hanifluhur.myapplication.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button Gunung;
    private Button Pantai;
    private Button Candi;
    private Button Logout;
    CarouselView carouselView;
    SessionManagement sessionManagement;
    HashMap<String, String> loginUser;

    int[] imgCarousel = {R.drawable.carousel1, R.drawable.carousel2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk membuat activity
        setContentView(R.layout.activity_main);//menyatakan bahwa activity dari kelas ini adalah activity_main.xml

        carouselView = findViewById(R.id.carousel);
        sessionManagement = new SessionManagement(this);
        loginUser = sessionManagement.getUserInformation();

        String nama = loginUser.get(sessionManagement.KEY_USER);
        Toast.makeText(this, /*sm.isLoggedIn()+*/"Selamat datang " + nama + " !", Toast.LENGTH_LONG).show();

        //set slide carousel
        carouselView.setPageCount(imgCarousel.length);
        carouselView.setImageListener(imageListener);


        Logout = (Button) findViewById(R.id.buttonlogout);//menyatakan bahwa id button logout disimpan pada object logout
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManagement.logoutUser();
            }
        });

        Gunung = (Button) findViewById(R.id.ButtonGunung);//menyatakan bahwa id button gunung disimpan pada object gunung
        Gunung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class); // berpindah halaman dan kelas, bahwa halaman yang dituju adalah main2activity
                startActivity(i);
            }
        });
        Pantai = (Button) findViewById(R.id.ButtonPantai);//menyatakan bahwa id button pantai disimpan pada object pantai
        Pantai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main3Activity.class); // berpindah halaman dan kelas, bahwa halaman yang dituju adalah main3activity
                startActivity(i);
            }
        });
        Candi = (Button) findViewById(R.id.ButtonCandi);//menyatakan bahwa id button candi disimpan pada object candi
        Candi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main4Activity.class); // berpindah halaman dan kelas, bahwa halaman yang dituju adalah main4activity
                startActivity(i);
            }
        });
    }
        //set slide carousel
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(imgCarousel[position]);
            }
        };

}
