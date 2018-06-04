package com.example.alunos.androidtoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class AddItemsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup contrainer, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_items_layout,
                contrainer, false);
        return v;
    }
    public void salvar(View v){
        EditText editnome = (EditText) findViewById(R.id.editNome);
        EditText edittelefone = (EditText) findViewById(R.id.editTelefone);
        String nome = editnome.getText().toString();
        String telefone = edittelefone.getText().toString();
        lista.add(new Pessoa(nome,telefone,R.mipmap.ic_launcher_round));
        editnome.setText("");
        edittelefone.setText("");
    }
}