package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityBorobudur extends AppCompatActivity {
Button borobudur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_borobudur);
        borobudur = (Button) findViewById(R.id.lokasi);
        borobudur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsBorobudur.class);
                startActivity(i);
            }
        });
    }
}
