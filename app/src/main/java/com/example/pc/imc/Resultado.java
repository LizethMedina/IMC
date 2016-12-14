package com.example.pc.imc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by PC on 27/10/2016.
 */
public class Resultado extends Activity {

    TextView nombre, pesoideal, imc, calorias, recomendaciones;
    Float valimc; //valores a calcular
    Double pesooideal; //valores a calcular
    int caloria; //valores a calcular
    String opt[]={"Mujer", "Hombre"}; // opciones para el switch que sera referencia al checkbox
    ImageView img1, img2;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        nombre = (TextView) findViewById(R.id.nombree);
        imc = (TextView) findViewById(R.id.IMC);
        calorias = (TextView) findViewById(R.id.Calorias);
        recomendaciones = (TextView) findViewById(R.id.recomendacion);
        pesoideal = (TextView) findViewById(R.id.peso);
        img1 = (ImageView)findViewById(R.id.img1);
        img2 =(ImageView)findViewById(R.id.img2);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();


        if (extras != null)
        {
            String datonombre = extras.getString("Nombre");
            nombre.append("  " + datonombre);

            String Altura = extras.getString("Altura");
            float altura = Float.parseFloat(Altura);

            String Peso = extras.getString("Peso");
            float peso = Float.parseFloat(Peso);

            String genero = extras.getString("Genero");


            valimc = peso / ((altura / 100) * (altura / 100));
            imc.append(" " + valimc);

            pesooideal = 0.75 * (altura - 150) + 50;
            pesoideal.append(" " + pesooideal);

            if (valimc <= 16.00) {

                Picasso.with(getApplicationContext()).load(R.drawable.delgado).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n"+"\n"+" "+"Infrapeso: Delgadez severa "+" "+" Consume mas carbohidratos");
            }
            else if (valimc <= 16.00 || valimc <= 16.99)
            {
                Picasso.with(getApplicationContext()).load(R.drawable.delgado).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n"+"\n"+" "+"Infrapeso: Delgadez moderada" + " "+"Estas bien, pero puedes consumir mas alimentos");
            }
            else if (valimc <= 17.00 || valimc <= 18.49)
            {
                Picasso.with(getApplicationContext()).load(R.drawable.delgado).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n"+"\n"+" "+"Infrapeso: Delgadez aceptable"+ " "+"Estas fuera de riesgo");
            }
            else if (valimc <= 18.50 || valimc <= 24.99)
            {
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n"+"\n"+" "+"Peso Normal");

            }
            else if(valimc<=25.00 || valimc<=29.99)
            {
                Picasso.with(getApplicationContext()).load(R.drawable.gor1).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n"+"\n"+" "+"Sobrepeso"+ " "+"Estas en riesgo de problemas  cardio-basculares ");
            }
            else if(valimc<=30.00 || valimc<=34.99) {
                Picasso.with(getApplicationContext()).load(R.drawable.gor2).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n"+"\n"+" "+"Obeso: Tipo I"+" "+"Necesitas hacer ejercicio");
            }
            else if(valimc<= 30.00 || valimc<=40.00)
            {
                Picasso.with(getApplicationContext()).load(R.drawable.go5).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n"+"\n"+" "+"Obeso: Tipo III"+" "+"Necesitas acudir con un nutriologo y realizar ejercicio");
            }
            else
            {
                Picasso.with(getApplicationContext()).load(R.drawable.q).into(img1);
                Picasso.with(getApplicationContext()).load(R.drawable.normal).into(img2);
                recomendaciones.append("\n" + "\n" + " " + "Clasificación no existe");
            }

        }
        String Edad = extras.getString("Edad");
        int edad = Integer.parseInt(Edad);

        if(edad >= 1 && edad<= 3 )
        {
            calorias.append("\n"+"\n"+"Niños"+" "+"\n"+"Consumir 1300 cal/dia");
        }
        else if(edad >= 4 && edad<= 6)
        {
            calorias.append("\n"+"\n"+"Niños "+" "+"\n"+"Consumir 1800 cal/dia");
        }
        else if(edad >= 7 && edad<= 10)
        {
            calorias.append("\n"+"\n"+"Niños:"+" "+"\n"+"Consumir 2000 cal/dia");
        }
        else if(edad >= 11 && edad<= 14)
        {
            calorias.append("\n"+"\n"+" "+"Hombre:"+" "+"Consumir 2500 cal/dia"+" "+"\n"+"Mujer:"+" "+"Consumir 2200 cal/dia ");
        }
        else if(edad >= 15 && edad<= 18)
        {
            calorias.append("\n"+"\n"+" "+"Hombre:"+" "+"Consumir 3000 cal/dia"+" "+"\n"+"Mujer:"+" "+"Consumir 2200 cal/dia");
        }else if(edad >= 19 && edad<= 24)
        {
            calorias.append("\n"+"\n"+" "+"Hombre:"+" "+"Consumir 2900 cal/dia"+" "+"\n"+"Mujer:"+" "+"Consumir 2200 cal/dia ");
        }
        else if(edad >= 25 && edad<= 50)
        {
            calorias.append("\n"+"\n"+" "+"Hombre:"+" "+"Consumir 2300 cal/dia"+" "+"\n"+"Mujer:"+" "+"Consumir 2200 cal/dia ");
        }
        else if(edad >=51)
        {
            calorias.append("\n "+"\n"+"Hombre:"+" "+"Consumir 2300 cal/dia "+"\n "+"\n"+"Mujer:"+" "+"Consumir 1900 cal/dia ");
        }
    }

    public void click(View view)
    {
        String button_text;
        button_text =((Button) view).getText().toString();

        if(button_text.equals("Salir"))
        {
            Intent intent= new Intent(Intent.ACTION_MAIN);
            finish();
        }
        else if(button_text.equals("Regresar"));
        {
            Intent intent = new Intent(this, Bienvenida.class);
            startActivity(intent);
        }

    }

}

