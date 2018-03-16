package com.example.alunos.desafiodojogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.content.Intent;
import java.util.Scanner;
import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void confirma() {
        EditText valor = (EditText) findViewById(R.id.txtValor);
        String oValor = valor.getText().toString();
        int oValorInt = Integer.parseInt(oValor);

        Scanner input = new Scanner(System.in);
        Random gerador = new Random();
        int x = gerador.nextInt(1000) + 1;

        int t;
        t = 0;

        if (oValorInt < x) {
            t++;
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Não foi dessa vez! O número da sorte é maior que esse...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (oValorInt > x) {
            t++;
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Não foi dessa vez! O número da sorte é menor que esse...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (oValorInt == x) {
            t++;
            SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
            Intent i = new Intent(MainActivity.this, Resultado.class);

            Bundle bundle = new Bundle();
            bundle.putInt("ultimoPlacar", t);
            i.putExtras(bundle);
            startActivity(i);
        }


    }
}
