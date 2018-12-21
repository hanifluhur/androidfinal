package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityKalibiru extends AppCompatActivity {
Button kalibiru2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kalibiru);
        kalibiru2 = (Button) findViewById(R.id.kalibiru);
        kalibiru2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsKalibiru.class);
                startActivity(i);
            }
        });
    }
}
