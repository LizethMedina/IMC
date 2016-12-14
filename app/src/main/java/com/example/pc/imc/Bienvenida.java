package com.example.pc.imc;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by PC on 28/10/2016.
 */
public class Bienvenida extends AppCompatActivity
{
    Button text, text1;
    TextView newPeso,res;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida);

        text = (Button)findViewById(R.id.calc);
        text1 = (Button)findViewById(R.id.registros);

        newPeso = (TextView)findViewById(R.id.newPeso);//cambiar
        res = (TextView)findViewById(R.id.resultado);

        final BaseDatos log = new BaseDatos(this, "registrados", null,1);
        final SQLiteDatabase bd= log.getWritableDatabase();


      text.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view)
          {


              Intent resultado = getIntent();
              Bundle extras = resultado.getExtras();

              String nombre = (String)extras.get("Nombre");
              String edad = (String)extras.get("Edad");
              String altura = (String)extras.get("Altura");
              String peso = newPeso.getText().toString();

              ContentValues nuevo_registro = new ContentValues();
              nuevo_registro.put("Nombre",nombre);
              nuevo_registro.put("Edad",edad);
              nuevo_registro.put("Peso",peso);
              nuevo_registro.put("Altura",altura);

              bd.insert("registro",null,nuevo_registro);

              Intent Resulta = new Intent(Bienvenida.this, Resultado.class);
              Resulta.putExtra("Nombre",nombre);
              Resulta.putExtra("Edad",edad);
              Resulta.putExtra("Peso",peso);
              Resulta.putExtra("Altura",altura);

              startActivity(Resulta);
          }
      });


        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent resultado = getIntent();
                Bundle extras = resultado.getExtras();

                String nombre = (String)extras.get("Nombre");
                Cursor c = bd.rawQuery("Select Nombre,Apellidos,Peso,Altura FROM registro where Nombre ='"+nombre+"'",null);
                res.setText("");

                if (c.moveToFirst()) {
                    do{
                        String nom =c.getString(0);
                        String apellido =c.getString(1);
                        String peso =c.getString(2);
                        String altura =c.getString(3);

                        //res.append(nom+apellido+peso+altura);
                    }
                    while(c.moveToNext());
                }
                Intent move = new Intent(Bienvenida.this, Historial.class);
                startActivity(move);
            }
        });
        /*if(text.equals("Calcular"))
        {
            Intent resultado = getIntent();
            Bundle extras = resultado.getExtras();

            String nombre = (String)extras.get("Nombre");
            String edad = (String)extras.get("Edad");
            String altura = (String)extras.get("Altura");
            String peso = newPeso.getText().toString();

            ContentValues nuevo_registro = new ContentValues();
            nuevo_registro.put("Nombre",nombre);
            nuevo_registro.put("Edad",edad);
            nuevo_registro.put("Peso",peso);
            nuevo_registro.put("Altura",altura);

            bd.insert("registro",null,nuevo_registro);

            Intent Resultado = new Intent(this, Resultado.class);
            Resultado.putExtra("Nombre",nombre);
            Resultado.putExtra("Edad",edad);
            Resultado.putExtra("Peso",peso);
            Resultado.putExtra("Altura",altura);

            startActivity(Resultado);


        }

       if(text.equals("Registros"))
        {

            Intent resultado = getIntent();
            Bundle extras = resultado.getExtras();

            String nombre = (String)extras.get("Nombre");
           Cursor c = bd.rawQuery("Select Nombre,Peso,Altura FROM registro where Nombre ='"+nombre+"'",null);
            res.setText("");

            if (c.moveToFirst()) {
                do{
                    String nom =c.getString(0);
                    String peso =c.getString(1);
                    String altura =c.getString(2);

                    res.append(nom+peso+altura);
                }while(c.moveToNext());
            }
        }*/


    }
}