package com.example.alunos.listadinamica.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alunos on 19/03/18.
 */

public class Pessoa implements Parcelable {

    private String nome;
    private String telefone;
    private  int imagem;

    public Pessoa(String nome, String telefone, int idImagem){
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = idImagem;
    }


    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public int getImage() {
        return imagem;
    }

    public void setImage(int id){
        this.imagem = id;
    }

    protected Pessoa(Parcel in){
        nome = in.readString();
        telefone = in.readString();
        imagem = in.readInt();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeInt(imagem);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pessoa> CREATOR = new Parcelable.Creator<Pessoa>(){
        @Override
        public Pessoa createFromParcel(Parcel in){
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size){
            return new Pessoa[size];
        }
    };
}