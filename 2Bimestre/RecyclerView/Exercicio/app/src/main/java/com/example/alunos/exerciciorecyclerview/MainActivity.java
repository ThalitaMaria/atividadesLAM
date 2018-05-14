package com.example.alunos.exerciciorecyclerview;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.content.Intent;
        import android.view.View;

        import com.example.alunos.exerciciorecyclerview.adapter.LivroAdapter;
        import com.example.alunos.exerciciorecyclerview.model.Livro;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Livro> listaLivros;
    RecyclerView rview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rview = findViewById(R.id.recyclerView);
        listaLivros = new ArrayList<>();

        listaLivros.add(new Livro("O Senhor dos Anéis", "J. R. R. Tolkien",
                "Fantasia épica onde elfos, anões, hobbits e homens enfrentam os poderes do mal."));
        listaLivros.add(new Livro("Uma breve história do Tempo", "Stephen W. Hawking",
                "Uma introdução a alguns dos conceitos mais profundos da Física."));
        listaLivros.add(new Livro("A espada da galáxia", "Marcelo Cassaro",
                "A premiada ficção científica onde alienígenas rivais resolvem suas disputas na Terra."));

        rview.setAdapter(new LivroAdapter(listaLivros, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);

        rview.setLayoutManager(layout);
    }

    public void adicionar(View v) {
        Intent i = new Intent(MainActivity.this, Adiciona.class);
        startActivity(i);
    }


}
