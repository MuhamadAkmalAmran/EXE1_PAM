package com.example.exe1_pam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityProses extends AppCompatActivity {
    //Deklarasi variabel dengan tipe data textview, Edittext dan FloatingActionButton
    TextView tvNama;
    EditText edtask1, edtask2, edtask3;
    FloatingActionButton tombol;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //menghubungkan variabel tvNama dengan componen TextView pada layout
        tvNama = findViewById(R.id.idNama);

        //mendekalarasikan variabel bundle yang akan digunakan untuk mengambil
        //pesan yang dikirim melalui method intet
        Bundle bund = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String name = bund.getString("a");

        //menampilkan value dari varibael email kedalam tvNama
        tvNama.setText(name);

        edtask1 = (EditText) findViewById(R.id.etTask);
        edtask2 = (EditText) findViewById(R.id.etJTask);
        edtask3 = (EditText) findViewById(R.id.etTtask);
        tombol = (FloatingActionButton) findViewById(R.id.btnNext);

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String nama_task = edtask1.getText().toString();
        String jenis_task = edtask2.getText().toString();
        String time_task = edtask3.getText().toString();
        if (item.getItemId() == R.id.logout)
        {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

        }
        else if (nama_task.isEmpty() && jenis_task.isEmpty() && time_task.isEmpty())
        {
            Toast.makeText(ActivityProses.this, "Isi Semua Data", Toast.LENGTH_LONG).show();
        }
        else if (jenis_task.isEmpty())
        {
            edtask2.setError("Jenis Task");
        }
        else if (time_task.isEmpty())
        {
            edtask3.setError("Lama Task");
        }
        //Membuat kondisi jika yang dipilih adalah id submit
        else if (item.getItemId() == R.id.submit && nama_task.equals(nama_task) && (jenis_task.equals(jenis_task) && (time_task.equals(time_task))))
        {
            Toast.makeText(ActivityProses.this, "Berhasil", Toast.LENGTH_LONG).show();

            //membuat objek bundle
            Bundle budel = new Bundle();

            //memasukkan value dari variabel nama dengan kunci "b"
            //dan dimasukkan kedalam bundle
            budel.putString("b", nama_task.trim());

            //memasukkan value dari variabel nama dengan kunci "c"
            //dan dimasukkan kedalam bundle
            budel.putString("c", jenis_task.trim());

            //memasukkan value dari variabel nama dengan kunci "d"
            //dan dimasukkan kedalam bundle
            budel.putString("d", time_task.trim());

            //membuat objek intent untuk berpindah dari MainActivity ke ActivityProses
            Intent i = new Intent(getApplicationContext(), HasilActivity.class);

            i.putExtras(budel);

            //berpindah ke ActivityProses
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);


    }

    public void validasi()
    {
        String nama_task = edtask1.getText().toString();
        String jenis_task = edtask2.getText().toString();
        String time_task = edtask3.getText().toString();

        if(nama_task.isEmpty() && jenis_task.isEmpty() && time_task.isEmpty())
        {
            Toast.makeText(ActivityProses.this, "Isi Semua Data", Toast.LENGTH_LONG).show();
        }
        else if (jenis_task.isEmpty())
        {
            edtask2.setError("Jenis Task");
        }
        else if (time_task.isEmpty())
        {
            edtask3.setError("Lama Task");
        }
        else if (nama_task.equals(nama_task) && (jenis_task.equals(jenis_task) && (time_task.equals(time_task))))
        {
            Toast.makeText(ActivityProses.this, "Berhasil", Toast.LENGTH_LONG).show();
            //membuat objek bundle
            Bundle budel = new Bundle();

            //memasukkan value dari variabel nama dengan kunci "b"
            //dan dimasukkan kedalam bundle
            budel.putString("b", nama_task.trim());

            //memasukkan value dari variabel nama dengan kunci "c"
            //dan dimasukkan kedalam bundle
            budel.putString("c", jenis_task.trim());

            //memasukkan value dari variabel nama dengan kunci "d"
            //dan dimasukkan kedalam bundle
            budel.putString("d", time_task.trim());

            //membuat objek intent untuk berpindah dari MainActivity ke ActivityProses
            Intent i = new Intent(getApplicationContext(), HasilActivity.class);

            //memasukkan bundle kedalam intent untuk dikirim ke HasilActivity
            i.putExtras(budel);

            //berpindah ke ActivityProses
            startActivity(i);
        }
    }

}
