package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContactManager {
    SQLiteDatabase db = null;
    Context con ;

    public ContactManager(Context con) {

        this.con = con;
    }
    public void  open(){
        ContactHelper helper=new ContactHelper(con,"contact_base.db",null,1);
        db=helper.getWritableDatabase();
    }
    public long add(String name,String lastname,String num ){

        long a=0;
        ContentValues values =new ContentValues();

        values.put(ContactHelper.col_name,name);
        values.put(ContactHelper.col_LastName,lastname);
        values.put(ContactHelper.col_numero,num);
        a=db.insert(ContactHelper.table_contact,null,values);
    return a;
    }
    public ArrayList<Contact> getAllContact(){
        ArrayList<Contact> C=new ArrayList<Contact>();
        Cursor cr=db.query(ContactHelper.table_contact, new String[]{ContactHelper.col_numero,ContactHelper.col_name,ContactHelper.col_LastName},null,null,null,null,null);
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            String i = cr.getString(0);
            String i1 = cr.getString(1);
            String i2 = cr.getString(2);
            C.add(new Contact(i1, i2, i));
            cr.moveToNext();
        }
        return C;
    }
    public void  supprimer(){

    }
    public void fermer(){

    }
}
