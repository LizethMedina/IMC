package com.example.pc.imc;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by PC on 27/10/2016.
 */
public class Registrar extends Activity
{

    TextView nombre, apellidos, edad, peso, altura, password, genero;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        nombre = (TextView)findViewById(R.id.Nombre);
        apellidos = (TextView)findViewById(R.id.Apellidos);
        edad = (TextView)findViewById(R.id.Edad);
        peso =(TextView)findViewById(R.id.Peso);
        altura = (TextView)findViewById(R.id.Altura);
        genero = (TextView)findViewById(R.id.gene);
        password = (TextView)findViewById(R.id.Password);
    }
    public void click(View view)
    {
        BaseDatos regis = new BaseDatos(this, "IMC", null, 1);
        SQLiteDatabase db = regis.getWritableDatabase();
        String Nombre = nombre.getText().toString();
        String Apellidos = apellidos.getText().toString();
        String Edad = edad.getText().toString();
        String Peso = peso.getText().toString();
        String Altura = altura.getText().toString();
        String Genero = genero.getText().toString();
        String Password= password.getText().toString();
        ContentValues values = new ContentValues();

        values.put("Nombre",Nombre);
        values.put("Apellidos", Apellidos);
        values.put("Edad", Edad);
        values.put("Peso", Peso);
        values.put("Altura", Altura);
        values.put("Genero", Genero);
        values.put("Password", Password);

        db.insert("registro",null,values);
        db.close();

        String button_text;
        button_text = ((Button) view).getText().toString();

        if (button_text.equals("Registrar"))
        {
            //Crouton.makeText(Registrar.this, "Registro exitoso", Style.INFO).show();
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }


}