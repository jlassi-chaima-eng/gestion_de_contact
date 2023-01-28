package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class Edition extends AppCompatActivity {
    ArrayList <Contact> alldata = new ArrayList<Contact>();
    ArrayList <Contact> data = new ArrayList<Contact>();
    EditText ed_rech;
    RecyclerView rev;
    public ImageView search;



    MyContactRecycleAdapter ad=new MyContactRecycleAdapter(Edition.this,data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition);
        rev = findViewById(R.id.rv_edit);
        ed_rech = findViewById(R.id.ed_rech_edit);

        ContactManager  manage= new ContactManager(Edition.this);
        manage.open();
        data = manage.getAllContact();
        alldata = manage.getAllContact();

        search=findViewById(R.id.ed_rech_btn);



        MyContactRecycleAdapter ad = new MyContactRecycleAdapter(Edition.this, data);

        ed_rech.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = String.valueOf(ed_rech.getText());
                System.out.println(s);

                data.clear();

                for (Contact c : alldata) {
                    if (c.numero.contains(s) || c.nom.contains(s)|| c.prenom.contains(s)) {
                        data.add(c);
                    }
                }
                ad.notifyDataSetChanged();
            }
        });

        //LinearLayoutManager manager = new LinearLayoutManager(Edit.this, LinearLayoutManager.HORIZONTAL,true);
        //exemple 2:
        GridLayoutManager manager = new GridLayoutManager(Edition.this,1,GridLayoutManager.VERTICAL,false);
        rev.setLayoutManager(manager);

        rev.setAdapter(ad);

    }
}