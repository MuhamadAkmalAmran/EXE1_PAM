package com.example.exe1_pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etPassword;
    Button btn;
    String nama, password;
    TextView regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.edNama);
        etPassword = (EditText) findViewById(R.id.edPassword);
        btn = (Button) findViewById(R.id.btSign);
        regis = (TextView) findViewById(R.id.tvregis);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), RegisActivity.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = etNama.getText().toString();
                password = etPassword.getText().toString();

                if(nama.isEmpty() && password.isEmpty()){
                    etNama.setError("Nama Diperlukan");
                }
                else if(nama.equals("Pascal") && password.equals("iniPascal"))
                {
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                    //membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a"
                    //dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //membuat objek intent untuk berpindah dari MainActivity ke ActivityProses
                    Intent i = new Intent(getApplicationContext(), ActivityProses.class);

                    i.putExtras(b);

                    //berpindah ke ActivityProses
                    startActivity(i);

                }
                else if(nama != ("Pascal") && password.equals("iniPascal"))
                {
                    Toast.makeText(MainActivity.this,"Nama Salah", Toast.LENGTH_LONG).show();
                }
                else if(nama.equals("Pascal") && password != ("iniPascal"))
                {
                    Toast.makeText(MainActivity.this,"Password Salah", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}