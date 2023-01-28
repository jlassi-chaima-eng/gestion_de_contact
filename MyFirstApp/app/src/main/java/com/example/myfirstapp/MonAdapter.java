package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    ArrayList<Contact> data;
     Context con;

    public MonAdapter(Context con,ArrayList<Contact> data) {
        this.data = data;
        this.con = con;
    }

    @Override
    public int getCount() {
        //nombre des view dans listview
        // 0 aucun element a aff
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//position =conteur parcouris list view
      //pour chaque position en creer une view (linearLayout ,button ..)

        //creation d'un view
        LayoutInflater inf=LayoutInflater.from(con);
        View v=(LinearLayout)inf.inflate(R.layout.element,null);
//rrecuperation des champs
        TextView tvnom=v.findViewById(R.id.view_contact_name_txt);
        TextView tvprenom=v.findViewById(R.id.view_contact_lastname_txt);
        TextView tvnum=v.findViewById(R.id.view_contact_num);
        ImageView btn_call=v.findViewById(R.id.view_contact_btn_call);
        ImageView btn_del=v.findViewById(R.id.view_contact_btn_delete);
//effecter les valeurs des champs
        Contact c=data.get(i);
        tvnom.setText(c.nom);
        tvprenom.setText(c.prenom);
        tvnum.setText(c.numero);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(i);
                notifyDataSetChanged();
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+c.numero));
                con.startActivity(i);
            }
        });



        return v;
    }
}
