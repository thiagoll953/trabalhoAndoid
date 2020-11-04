package com.thiago.listacontatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;                     //forma                     //
                                        // FORMULARIO ONDE TENHO TODOS OS CONTATOS
public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etNumero, etEmail;
    private Button btnSalvar;
    private String acao;
    private Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        acao = getIntent().getExtras().getString("acao");
        etNome = findViewById(R.id.etNome);             //ligando o et nome da activity_formulario
        etNumero = findViewById(R.id.etNumero);        //ligando o et numero da activity_formulario
        etEmail = findViewById(R.id.etEmail);           //ligando o et email da activity_formulario
        btnSalvar = findViewById(R.id.btnSalvar);       //ligando o btn salvar da activity_formulario

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            } //salvando  contato
        });
    }

    private void salvar() {
        if (contato == null) {
            contato = new Contato();    //se o produto for null, zero, vai recever um novo
        }
            String nome = etNome.getText().toString();  //pegando o texto que o usuário digitou no campo nome, etnome.
            String numero = etNumero.getText().toString(); //pegando o texto que o usuário digitou no campo nome, etnumero.
            String email = etEmail.getText().toString();
            contato.setNome(nome);
            contato.setNumero(numero);
            contato.setEmail(email);
        if(acao.equals("inserir"))
            ContatoDAO.inserir(contato,this); //inserindo o contato na lista
            finish();
        }

}