package com.example.alunos.passagemdedados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mandaMensagem(View v){
        EditText nome = (EditText) findViewById(R.id.txtNome);
        String oNome = nome.getText().toString();
        if (oNome.matches("")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "É preciso digitar um nome...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Intent i = new Intent(MainActivity.this, Resultado.class);

        Bundle bundle = new Bundle();
        bundle.putString("nome", oNome);
        i.putExtras(bundle);
        startActivity(i);
    }

}
