package com.example.exe1_pam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class RegisActivity extends AppCompatActivity {
    EditText tvNama, tvEmail, tvPass, tvRepass;
    Button Regisbtn;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        tvNama = (EditText) findViewById(R.id.Tnama);
        tvEmail = (EditText) findViewById(R.id.Temail);
        tvPass = (EditText) findViewById(R.id.Tpass);
        tvRepass = (EditText) findViewById(R.id.Trepass);
        Regisbtn = (Button) findViewById(R.id.Bregis);

        Regisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();
            }
        });
    }
    public void validasi()
    {
        String getnama = tvNama.getText().toString();
        String getemail = tvEmail.getText().toString();
        String getpass = tvPass.getText().toString();
        String getrepass = tvRepass.getText().toString();

        if(getnama.isEmpty() && getemail.isEmpty())
        {
            tvNama.setError("Masukan Nama");
            tvEmail.setError("Masukan Email");
        }
        else if (getpass.equals(getrepass))
        {
            Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_LONG).show();
            //membuat objek bundle
            Bundle b = new Bundle();

            //memasukkan value dari variabel nama dengan kunci "a"
            //dan dimasukkan kedalam bundle
            b.putString("a", getnama.trim());

            //membuat objek intent untuk berpindah dari MainActivity ke ActivityProses
            Intent i = new Intent(getApplicationContext(), ActivityProses.class);

            //memasukkan bundle kedalam intent untuk dikirim ke ActivityProses
            i.putExtras(b);

            //berpindah ke ActivityProses
            startActivity(i);
        }
        else if (getpass != getrepass)
        {
            Toast.makeText(getApplicationContext(),"Password Salah", Toast.LENGTH_LONG).show();
        }
    }
}
