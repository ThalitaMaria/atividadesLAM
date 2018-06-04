package com.example.alunos.comtablelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //cria o layout
        TableLayout tabela = new TableLayout(this);
        tabela.setPadding(10,10,10,10);
        tabela.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        //expande a coluna 1
            tabela.setColumnStretchable(1, true);
            //linha 1
            TableRow linha1 = new TableRow(this);
            TextView nome = new TextView(this);
            nome.setText("Nome:");
            linha1.addView(nome);
            EditText tnome = new EditText(this);
            //focus no campo nome
            tnome.requestFocus();
            linha1.addView(tnome);
            //linha 2
            TableRow linha2 = new TableRow(this);
            TextView senha = new TextView(this);
            senha.setText("Senha:");
            linha2.addView(senha);
            EditText tsenha = new EditText(this);
            tsenha.setTransformationMethod(
                    new PasswordTransformationMethod());
            linha2.addView(tsenha);
            //linha 3
            TableRow linha3 = new TableRow(this);
            linha3.setGravity(Gravity.RIGHT);
            //botão alinhado a direita
            Button ok = new Button(this);
            ok.setText("Login:");
            linha3.addView(ok);
            //Adiciona as linhas
            tabela.addView(linha1);
            tabela.addView(linha2);
            tabela.addView(linha3);
            //informa o layout
            setContentView(tabela);
    }
}
