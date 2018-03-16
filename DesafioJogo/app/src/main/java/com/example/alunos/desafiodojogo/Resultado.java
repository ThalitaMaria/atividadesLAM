package com.example.alunos.desafiodojogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        int ultimoPlacar = pacote.getInt("ultimoPlacar");
        TextView txtResultado = (TextView) findViewById (R.id.t1);
        txtResultado.setText(String.format("%i!", ultimoPlacar));
    }
}
