package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {
    private Button Borobudur;
    private Button Prambanan;
    private Button Ratu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Borobudur= (Button) findViewById(R.id.borobudur);//menyatakan bahwa id button merapi disimpan pada object borobudur
        Borobudur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityBorobudur.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivitypaborobudur
                startActivity(i);
            }
        });
        Prambanan = (Button) findViewById(R.id.prambanan);//menyatakan bahwa id button merapi disimpan pada object prambanan
        Prambanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityPrambanan.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivityprambanan
                startActivity(i);
            }
        });
        Ratu = (Button) findViewById(R.id.ratu);//menyatakan bahwa id button merapi disimpan pada object ratu
        Ratu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityRatu.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivityratu
                startActivity(i);
            }
        });
    }
}
