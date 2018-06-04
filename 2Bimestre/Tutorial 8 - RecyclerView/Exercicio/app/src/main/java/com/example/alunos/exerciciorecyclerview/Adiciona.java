package com.example.alunos.exerciciorecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Adiciona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona);
    }

    public void insere(View v) {
        EditText titulo = (EditText) findViewById(R.id.txt_novoTitulo);
        String oTitulo = titulo.getText().toString();
        EditText autor = (EditText) findViewById(R.id.txt_novoAutor);
        String oAutor = autor.getText().toString();
        EditText desc = (EditText) findViewById(R.id.txt_novaDesc);
        String aDesc = desc.getText().toString();

        if(oTitulo.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Digite um título...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if(oAutor.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Digite um autor...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if(aDesc.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Digite uma descrição...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        Intent intencao = new Intent(Adiciona.this, MainActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("titulo", oTitulo);

        Bundle bundle2 = new Bundle();
        bundle2.putString("autor", oAutor);

        Bundle bundle3 = new Bundle();
        bundle3.putString("descricao", aDesc);

        intencao.putExtras(bundle);
        intencao.putExtras(bundle2);
        intencao.putExtras(bundle3);

        startActivity(intencao);
    }

}
