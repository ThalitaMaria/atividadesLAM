package com.example.alunos.desafio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Scanner;
import java.util.Random;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random gerador = new Random();
        String tentativa;

        int aleatorio = gerador.nextInt(10)+1;

        int op = 3, tenta;
        while (op != 0){
            System.out.print("Digite um número\n");
            EditText userInput = findViewById(R.id.idDoEditText);
            tentativa = userInput.getText().toString();
            tenta = Integer.parseInt(tentativa);

            if (tentativa == aleatorio) {
                System.out.print("Parabéns, vocẽ acertou!\n");
                op = 0;
            } else {
                --op;
                if (op == 0){
                    System.out.println("Acabaram suas chances, loooser!\n");
                } else {
                    System.out.printf("Você errou, só lalá, restam %d chances \n", op);
                }
            }
        }
    }
}
