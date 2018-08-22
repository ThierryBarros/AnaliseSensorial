package com.example.thierry.anlisesensorial.dominio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Thierry on 12/25/2017.
 */

public class RepositorioAnalise {
    private SQLiteDatabase conn;

    public RepositorioAnalise(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void testeInserirAnalise(){
        ContentValues values = new ContentValues();
        values.put("CODIGO",15);
        conn.insertOrThrow("ANALISE",null,values);
    }

    public void inserir(int codigo, int sabor, int saborresidual, int aparencia, int aroma, int textura, int docura){
        ContentValues values = new ContentValues();
        values.put("CODIGO",codigo);
        values.put("SABOR", sabor);
        values.put("SABORRESIDUAL",saborresidual);
        values.put("APARENCIA",aparencia);
        values.put("AROMA",aroma);
        values.put("TEXTURA",textura);
        values.put("DOCURA",docura);
        conn.insertOrThrow("ANALISE",null,values);

    }

    public int buscaAnalise(){
        Cursor cursor  = conn.query("ANALISE",null,null,null,null,null,null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            cursor.moveToLast();
            return cursor.getInt(3);

        }

        return 50;
    }
}
