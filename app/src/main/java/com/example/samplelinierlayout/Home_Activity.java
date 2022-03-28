package com.example.samplelinierlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    //memanggil class Listviewadapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //membuat objek bundle
    Bundle bundle = new Bundle();

    //membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //menyimpan nama didalam array ListNama
        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita",
                "Vian", "Lutfi"};

        //Deklarasi variabel dengan jenis data listview
        ListView list = findViewById(R.id.listKontak);

        //membuat objek dari class ClassNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada array LiatNama
        for (int i = 0; i < listNama.length; i++) {
            //membuat objek class nama
            ClassNama classNama = new ClassNama(listNama[i]);
            //Binds strings ke array
            classNamaArrayList.add(classNama);
        }

        //membuat objek dari ListviewAdapter
        adapter = new ListViewAdapter(this);

        //Binds Adapter ke listView
        list.setAdapter(adapter);

        //membuat event dari List onClick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                //memasukkan value dari variabel nama dengan kunci "a"
                //dan dimasukkan kedalam bundle
                bundle.putString("a", nama.trim());

                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);

                //menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //Menampilkan popup menu
                pm.show();
            }
        });
    }

    //event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit kontak", Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}