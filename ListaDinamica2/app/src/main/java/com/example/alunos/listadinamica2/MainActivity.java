package com.example.alunos.listadinamica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import com.example.alunos.listadinamica2.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lista.add(new Pessoa("Maria de Oliveira", "99323-1234",
                R.mipmap.ic_launcher_round));

        lista.add(new Pessoa("Pedro da Silva", "98753-1097",
                R.mipmap.ic_launcher_round));

        lista.add(new Pessoa("João de Souza", "96433-1654",
                R.mipmap.ic_launcher_round));
    }

    public void mostrarLista(View v){
        EditText nome = findViewById(R.id.editText1);
        EditText telefone = findViewById(R.id.editText2);
        String oNome = nome.getText().toString();
        String oTelefone = telefone.getText().toString();

        if (oNome.matches("")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "É preciso digitar um nome...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (oTelefone.matches("")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "É preciso digitar um telefone...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        lista.add(new Pessoa(oNome,oTelefone,
                R.mipmap.ic_launcher_round));

        Intent i = new Intent(this, mostraListaDinamica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", lista);
        i.putExtras(bundle);
        startActivity(i);
    }
}