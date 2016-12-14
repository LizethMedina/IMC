package com.example.pc.imc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by PC on 28/10/2016.
 */
public class Acercade extends AppCompatActivity
{
    Button texto;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade);

        texto = (Button)findViewById(R.id.reg);

        if(texto.equals("Regresar"))
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
