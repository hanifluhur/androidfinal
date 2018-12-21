package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityPrambanan extends AppCompatActivity {
Button prambanan2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_prambanan);
        prambanan2 = (Button) findViewById(R.id.candi);
        prambanan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsPrambanan.class);
                startActivity(i);
            }
        });
    }
}
