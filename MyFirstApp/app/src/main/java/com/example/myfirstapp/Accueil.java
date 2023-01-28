package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity {
    public static ArrayList<Contact> data=new ArrayList<>();
    Button btn_ajout,btn_edit;
    ContactManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        manager = new ContactManager(Accueil.this);
        manager.open();
        btn_ajout = findViewById(R.id.btn_ajout_acc);
        btn_edit = findViewById(R.id.btn_ed_acc);
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Accueil.this, Ajout.class);
                startActivity(i);
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Accueil.this, manager.getAllContact().toString(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(Accueil.this, Edition.class);
                startActivity(i);
            }
        });
    }
}