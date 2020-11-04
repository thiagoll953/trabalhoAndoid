package com.thiago.listacontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {      //Classe que contem os comandos SQL. Nessa classe erá trabalho somente com metodos

    public static void inserir(Contato contato, Context context) {  //parametro que será passado quando criar um contato novo

        ContentValues valores = new ContentValues(); //objeto que cria um dicionario de dados com chave e valores, colunas etc...
        valores.put("nome", contato.getNome());
        valores.put("numero", contato.getNumero());     //dados que serão inseridos no banco, chave nome etc...
        valores.put("email", contato.getEmail());

        Banco banco = new Banco(context);  //referencia da classe banco, um objeto onde vamos passar a referencia da tela que vamos chamar no context
        SQLiteDatabase db = banco.getWritableDatabase();   //referencia do banco de dados que faz a leitura ou escrita do banco, nessa caso foi a escrita

        db.insert("contatos", null, valores);  //aqui chamaremos o metodo inserir que foi criado. devemos passar 3 parametros, 1-tabela, 2-null, 3-valores

    }

    public static List<Contato> getContatos(Context context){ //vamos listar os contatos com um array, passando a tela.

        List<Contato> lista = new ArrayList<>();

        Banco banco = new Banco(context); //referencia da classe banco, um objeto onde vamos passar a referencia da tela que vamos chamar no context
        SQLiteDatabase db = banco.getReadableDatabase(); //referencia do banco de dados que faz a leitura ou escrita do banco, nessa caso foi a leitura

        Cursor cursor = db.rawQuery( "SELECT * FROM contatos", null ); //objeto que retorna um cursor, tipo uma tabela, passando linha a linha, passando 2 condições, query de consulta e condição where
            if( cursor.getCount() > 0 ){
                cursor.moveToFirst();  // apontando o cursor para primeira linha
                do {   //laço que vai percorrer toda tabela passando o valor para cada posição
                    Contato c = new Contato();
                    c.setId(cursor.getInt(0));
                    c.setNome(cursor.getString(1));
                    c.setNumero(cursor.getString(2));
                    c.setEmail(cursor.getString(3));
                    lista.add(c);
                } while(cursor.moveToNext());  //move para proxima posição
            }
        return lista;
    }

}