package com.example.pc.imc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by PC on 27/10/2016.
 */
public class BaseDatos extends SQLiteOpenHelper
{
    private static final String DB_NAME= "IMC";
    private static  final int SCHEMA_VERSION= 1;

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, SCHEMA_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table registro(Nombre TEXT, Apellidos TEXT, Edad TEXT, Peso TEXT , Altura TEXT ,Genero TEXT,Password TEXT)");
        db.execSQL("insert into registro values('lulu','medina','23','45','151','m','hola')");
        db.execSQL("insert into registro values('lolu','medina','23','45','151','m','hola')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXIST registro");
        db.execSQL("create table registro(Nombre TEXT, Apellidos TEXT, Edad TEXT, Peso TEXT , Altura TEXT ,Genero TEXT,Password TEXT)");
        db.execSQL("insert into registro values('lulu','medina','23','45','151','m','hola')");
        db.execSQL("insert into registro values('lulu','medina','23','45','151','m','hola')");
    }

    public ArrayList llenar_lista()
    {
        ArrayList<String> lista=new ArrayList<>();
        SQLiteDatabase base= this.getWritableDatabase();
        String q = "SELECT*FROM registro";
        Cursor reg= base.rawQuery(q, null);
        if(reg.moveToFirst())
        do{
           lista.add(reg.getString(0)+"\r\r "+ "\r\r "+" "+reg.getString(1)+"\r\r "+ "\r\r "+" "+reg.getString(2)+"\r\r "+"\r\r "+" "+ reg.getString(3)+"\r\r "+ "\r\r "+" "+reg.getString(4));
         }
        while(reg.moveToNext());
        return lista;

    }

   /* public void llenar_listar()
    {
        BaseDatos base=new BaseDatos(this,"IMC",null,1);
        SQLiteDatabase db= base.getReadableDatabase();
        if(db!=null)
        {
            Cursor c= db.rawQuery("select * from registro",null);
            int cantidad = c.getCount();
            int i=0;
            String[] arr= new String[cantidad];
            if(c.moveToFirst())
            {
                do {
                    String linea = c.getString(0)+" "+ c.getString(1)+" "+ c.getString(2)+" "+ c.getString(3)+" "+ c.getString(4);
                    arr[i] = linea;
                }
                while(c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
            ListView lista =(ListView)findViewById(R.id.lista);
            lista.setAdapter(adapter);
        }
    }*/
}
