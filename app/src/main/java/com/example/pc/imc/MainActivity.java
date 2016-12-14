package com.example.pc.imc;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by PC on 27/10/2016.
 */
public class MainActivity extends Activity
{
    TextView usuario, password;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (TextView)findViewById(R.id.us);
        password = (TextView)findViewById(R.id.pa);
    }
    public void click(View view)
    {
        BaseDatos log = new BaseDatos(this, "registrados", null,1);
        SQLiteDatabase db= log.getWritableDatabase();
        String Usuario = usuario.getText().toString();
        String Password = password.getText().toString();
        fila=db.rawQuery("select Nombre, Password, Edad, Peso, Altura, Genero  from registro where Nombre='"+Usuario+"' and Password='"+Password+"' ", null);

        if(fila.moveToFirst()) {
            String us = fila.getString(0);
            String edad = fila.getString(2);
            String peso = fila.getString(3);
            String altura = fila.getString(4);
            String genero = fila.getString(5);

            Intent intent=new Intent(this, Bienvenida.class);
            intent.putExtra("Nombre",us);
            intent.putExtra("Edad",edad);
            intent.putExtra("Peso",peso);
            intent.putExtra("Altura",altura);
            intent.putExtra("Genero",genero);

            startActivity(intent);
        }
            else
            {
                Crouton.makeText(MainActivity.this, "Usuario incorrecto", Style.INFO).show();
            }
        }

    public void click1(View view)
    {
        String button_text;
        button_text = ((Button) view).getText().toString();

        if (button_text.equals("Crear cuenta"))
        {
            Intent intent = new Intent(this,Registrar.class);
            startActivity(intent);
        }
    }
    public void click2(View view)
    {
        String button_text;
        button_text = ((Button) view).getText().toString();

        if (button_text.equals("Acerca de"))
        {
            Intent intent = new Intent(this,Acercade.class);
            startActivity(intent);
        }
    }

}
