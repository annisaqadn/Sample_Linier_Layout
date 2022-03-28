package com.example.samplelinierlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnsignin;

    //Deklarasi variabel untuk EditText
    EditText ednama, edpassword;

    //Deklarasi variabel untuk menyimpan nama dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Menghubungkan variabel btnsignin dengan componen button pada Layout
        btnsignin = findViewById(R.id.btSignin);

        //Menghubungkan variabel ednama dengan componen button pada Layout
        ednama = findViewById(R.id.edNama);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword = findViewById(R.id.edPassword);

        //Membuat fungsi onclick pada button btnlogin
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext email kedalam variabel nama
                nama = ednama.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //Mengeset email yang benar
                String name = "Akyun";

                //Mengeset password yang benar
                String pwd = "123";
                //mengecek apakah isi dari email dan password sudah sama dengan nama dan password yang sudah di set
                if (nama.isEmpty() && password.isEmpty()) {
                    Toast t = Toast.makeText(MainActivity.this, "Nama harus anda isi", Toast.LENGTH_LONG);
                    t.show();
                } else if (nama.equals(name) && (password.isEmpty())) {
                    Toast t = Toast.makeText(MainActivity.this, "Masukkan password anda", Toast.LENGTH_LONG);
                    t.show();
                }else if (nama.equals(name) && password.equals(pwd)) { //Memasukkan nama "Akyun" dan Password "123" untuk sign in
                    //membuat variabel toast dan menampilkan pesan "Login sukses"
                    Toast t = Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                    //membuat objek bundle
                    Bundle b = new Bundle();
                    //memasukkan value dari variabel nama dengan kunci "nama" dan dimasukkan kedalam bundle
                    b.putString("nama", nama.trim());
                    //memasukkan value dari variabel password dengan kunci "ps" dan dimasukkan kedalam bundle
                    b.putString("ps", password.trim());
                    //membuat objek intent berpindah dari mainactivity ke Home_Activity
                    Intent i = new Intent(MainActivity.this,Home_Activity.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke Home_Activity
                    i.putExtras(b);

                    //berpindah ke Home_Activity
                    startActivity(i);
                }
                else if (nama.equals(name) && !password.equals(pwd)) {
                    //membuat variabel toast dan membuat toast dan menampilkan pesan "password salah"
                    Toast t = Toast.makeText(MainActivity.this, "Password salah", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                }
                else{
                    //membuat variabel toast dan membuat toast dan menampilkan pesan "nama salah"
                    Toast t = Toast.makeText(MainActivity.this, "Nama salah", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                }
            }
        });
    }
}