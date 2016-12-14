package com.example.pc.imc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by PC on 28/10/2016.
 */
public class Historial extends AppCompatActivity
{
    String texto;
    ListView list;
    ArrayList<String> lis;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial);
        list = (ListView)findViewById(R.id.lista);



        BaseDatos listar= new BaseDatos(getApplicationContext(), null, null,1);
        lis = listar.llenar_lista();
        adaptador = new ArrayAdapter(this, android. R.layout.simple_list_item_1, lis);
        list.setAdapter(adaptador);


    }

    public void llenar_listar()
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
        }

    /*public ArrayList llenar_lista()
    {
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase base = this.getWritableDatabase();

        if (base != null)
        {
            String q = "SELECT*FROM registro";
            Cursor reg = base.rawQuery(q, null);
            int cantidad = reg.getCount();
            int i = 0;
            String[] arr = new String[cantidad];
            if (reg.moveToFirst())
                do
                {
                    String linea = reg.getString(0) + " " + reg.getString(1) + " " + reg.getString(2) + " " + reg.getString(3) + " " + reg.getString(4);
                    arr[i] = linea;
                    //lista.add(reg.getString(0));
                }
                while (reg.moveToNext());

        }
        return lista;
    }
}*/

    public void click(View view)
    {
        texto= ((Button) view).getText().toString();

        if(texto.equals("Regresar"))
        {
            Intent intent = new Intent(this, MainActivity.class); //debe regresar al de bienvenida
            startActivity(intent);
        }
    }


}
