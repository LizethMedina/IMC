package com.example.pc.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculos);

        final EditText Nombre= (EditText)findViewById(R.id.N);
        final EditText Genero= (EditText)findViewById(R.id.G);
        final EditText Edad= (EditText)findViewById(R.id.E);
        final EditText Peso= (EditText)findViewById(R.id.P);
        final EditText Altura= (EditText)findViewById(R.id.A);
        final Button Calcular= (Button)findViewById(R.id.calcular);


        Calcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String nombre = Nombre.getText().toString();
                String genero = Genero.getText().toString();
                String edad = Edad.getText().toString();
                String peso = Peso.getText().toString();
                String altura = Altura.getText().toString();

                Intent intent= new Intent(Calculos.this, Resultado.class);

                intent.putExtra("Nombre", nombre);
                intent.putExtra("Genero", genero);
                intent.putExtra("Edad", edad);
                intent.putExtra("Peso", peso);
                intent.putExtra("Altura", altura);

                startActivity(intent);
            }
        });

    }

    public void click(View view)
    {
        String button_text;
        button_text = ((Button) view).getText().toString();

        if (button_text.equals("Salir"))
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            finish();

        }
    }
}
