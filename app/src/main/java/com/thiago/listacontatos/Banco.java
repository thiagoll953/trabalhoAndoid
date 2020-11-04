package com.thiago.listacontatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {  //será herdado da clado openhelper, classe que permite que possamos trabalhar com o banco

    private static final String NOME_BANCO = "listaContatos";
    private static final int VERSAO_BANCO = 1;

    public Banco(Context context){  //metodo construtor da classe banco que herda da super classe, SQLiteOpenHelper, classe na qual herdamos
        super(context, NOME_BANCO, null, VERSAO_BANCO);    //será passado 4 valores: 1-referencia a tela que está Context 2-nome do banco 3-factory forma como os dados retornan do banco 4 versão do banco
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {  //metodo obrigatório da classe SQLiteOpenHelper
        sqLiteDatabase.execSQL( "CREATE TABLE contatos (" +                             //sqLiteDatabase.execSQL referencia no nosso banco
                                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +        //tabela contatos criada.
                                "nome TEXT," +
                                "numero TEXT," +
                                "email TEXT ) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {  //metodo obrigatório da classe SQLiteOpenHelper
//metodo que sera chamado quando tiver alguma mudança no banco, aqui será adicionado um nova tabela ou coluna no banco. Quando mudar a versão, o android vai executar o que estiver dentro desse metodo
    }
}
