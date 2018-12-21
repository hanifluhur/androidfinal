package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button Merapi;
    private Button Api;
    private Button Kalibiru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk membuat activity
        setContentView(R.layout.activity_main2);//menyatakan bahwa activity dari kelas ini adalah activity_main2.xml
        Merapi = (Button) findViewById(R.id.merapi);//menyatakan bahwa id button merapi disimpan pada object merapi
        Merapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityMerapi.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivitymerapi
                startActivity(i);
            }
        });
        Api = (Button) findViewById(R.id.api);//menyatakan bahwa id button merapi disimpan pada object api
        Api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityApi.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivityapi
                startActivity(i);
            }
        });
        Kalibiru = (Button) findViewById(R.id.kalibiru);//menyatakan bahwa id button merapi disimpan pada object kalibiru
        Kalibiru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityKalibiru.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivitykalibiru
                startActivity(i);
            }
        });
    }
}
