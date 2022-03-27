package com.example.exe1_pam;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HasilActivity extends AppCompatActivity {
    TextView t1, t2, t3;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_ketiga);

        //menghubungkan variabel t1 dengan componen TextView pada layout
        t1 = findViewById(R.id.hasil1);

        //menghubungkan variabel t2 dengan componen TextView pada layout
        t2 = findViewById(R.id.hasil2);

        //menghubungkan variabel t3 dengan componen TextView pada layout
        t3 = findViewById(R.id.hasil3);

        //mendekalarasikan variabel bundle yang akan digunakan untuk mengambil
        //pesan yang dikirim melalui method intet
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "b"
        String task = bundle.getString("b");

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "c"
        String Jtask = bundle.getString("c");

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "d"
        String Ttask = bundle.getString("d");

        //menampilkan value dari varibael email kedalam t1
        t1.setText(task);

        //menampilkan value dari varibael email kedalam t2
        t2.setText(Jtask);

        //menampilkan value dari varibael email kedalam t3
        t3.setText(Ttask);
    }
}
