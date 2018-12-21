package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    private Button Parangtritis;
    private Button Indrayanti;
    private Button Glagah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk membuat activity
        setContentView(R.layout.activity_main3);//menyatakan bahwa activity dari kelas ini adalah activity_main2.xml
        Parangtritis= (Button) findViewById(R.id.parangtritis);//menyatakan bahwa id button merapi disimpan pada object parangtritis
        Parangtritis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityParangtritis.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivityparangtritis
                startActivity(i);
            }
        });
        Indrayanti = (Button) findViewById(R.id.indrayanti);//menyatakan bahwa id button merapi disimpan pada object indrayanti
        Indrayanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityIndrayanti.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivityindrayanti
                startActivity(i);
            }
        });
        Glagah = (Button) findViewById(R.id.glagah);//menyatakan bahwa id button merapi disimpan pada object glagah
        Glagah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityGlagah.class);// berpindah halaman dan kelas, bahwa halaman yang dituju adalah mainactivityglagah
                startActivity(i);
            }
        });
    }
}
