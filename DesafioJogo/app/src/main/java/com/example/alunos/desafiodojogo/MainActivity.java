package com.example.alunos.desafiodojogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.content.Intent;
import java.util.Scanner;
import android.content.SharedPreferences;
import android.content.Context;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    int numDaSorte;
    int tentativas;
    int highestScore;
    CircularFifoQueue<String> hist;
    final int Idle = 0;
    final int Reset = 1;
    int estado;
    Random gerador = new Random();
    private EditText userInput;
    private TextView resMsg;
    private Button btnAdiv;
    private SharedPreferences arquivo;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numDaSorte = gerador.nextInt(1000) + 1;
        Log.d("numDaSorte", Integer.toString(numDaSorte));
        userInput = (EditText) findViewById(R.id.txtInput);
        resMsg = (TextView) findViewById(R.id.lblResposta);
        btnAdiv = (Button) findViewById(R.id.btnAdiv);
        estado = Idle;
        tentativas = 0;
        hist = new CircularFifoQueue<>(5);
        arquivo = getPreferences(Context.MODE_PRIVATE);
        highestScore = arquivo.getInt(getResources().getString(R.string.historicoKey));
        for(int i=0;i<5;i++){
            String chave, valor;
            chave = getResources().getString(R.string.historicoKey);
            valor = arquivo.getString(chave, "0");
            Log.d(chave, valor);
            hist.add(valor);
        }
    }

    public void jogar(View v) {
        int meuNum;
        String teste = userInput.getText().toString();
        if(teste.matches("") && estado != Reset){
            Toast.makeText(this, getResources().getString(R.string.msgInvInput), Toast.LENGTH_SHORT).show();
        } else{
            switch (estado){
                case Idle:
                    meuNum = Integer.parseInt(userInput.getText().toString());
                    tentativas++;
                    if(meuNum == numDaSorte){
                        verificaHigh(tentativas);
                        hist.add(Integer.toString(tentativas));
                        editor = arquivo.edit();
                        editor.putInt(getResources().getString(R.string.highestScoreKey), highestScore);
                        for (int i=0; i<hist.size(); i++){
                            String chave, valor;
                            chave = getResources().getString(R.string.historicoKey) + Integer.toString(i);
                            valor = hist.get(i);
                            editor.putString(chave, valor);
                            Log.d(chave, valor);
                        }
                        editor.commit();
                        resMsg.setText(getResources().getString(R.string.msgWin, Integer.toString(tentativas)));
                        btnAdiv.setText(getResources().getString(R.string.lblButtonJogado));
                        estado = Reset;
                    } else if(meuNum > numDaSorte) {
                        resMsg.setText(getResources().getString(R.string.msgMissGreater));
                        estado = Idle;
                    } else {
                        resMsg.setText(getResources().getString(R.string.msgMissLesser));
                        estado = Idle;
                    }
                    break;
                case Reset:
                    numDaSorte = gerador.nextInt(10) + 1;
                    tentativas = 0;
                    Log.d("numDaSorte", Integer.toString(numDaSorte));
                    resMsg.setText("");
                    btnAdiv.setText(getResources().getString(R.string.lblButton));
                    estado = Idle;
                    break;
                default:
            }
        }
        userInput.setText("");
    }

    public void abrePlacar(View v){
        Intent intent = new Intent(getApplicationContext(), Placar.class);
        Bundle bundle = new Bundle();
        bundle.putInt(getResources().getString(R.string.highestScoreKey), highestScore);
        for (int i=0;i<5;i++){
            String chave, valor;
            chave = getResources().getString(R.string.historicoKey) + Integer.toString(i);
            valor = hist.get(i);
            bundle.putString(chave, valor);
            Log.d(chave, valor);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void verificaHigh(int valor){
        if (highestScore == 0){
            highestScore = valor;
        } else highestScore = valor < highestScore ? valor : highestScore;
    }

    @Override
    protected void onSaveInstanceState(Bundle estadoASalvar){
        super.onSaveInstanceState(estadoASalvar);
        estadoASalvar.putInt("numDaSorte", numDaSorte);
        estadoASalvar.putInt("tentativas", tentativas);
        estadoASalvar.putInt("estado", estado);
    }

    @Override
    protected void onRestoreInstanceState(Bundle estadoSalvo){
        super.onSaveInstanceState(estadoSalvo);
        estado = estadoSalvo.getInt("estado", Idle);
        tentativas = estadoSalvo.getInt("tentativas", 0);
        numDaSorte = estadoSalvo.getInt("numDaSorte", gerador.nextInt(10)+1);
    }
}
