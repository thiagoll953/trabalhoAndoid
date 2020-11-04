package com.thiago.listacontatos;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

//TELA PRINCIPAL
public class MainActivity extends AppCompatActivity {

    private ListView lvContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvContatos = findViewById(R.id.lvContatos);

        FloatingActionButton fab = findViewById(R.id.fab);     //botão +
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {            //ligação entre as telas mainActivity e formularioActivity
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class); //referencia da tela que estou para tela que quero abrir
                intent.putExtra("acao", "inserir");
                startActivity(intent);
            }
        });
    }

    private void listarContatos(){
        List<Contato> lista = ContatoDAO.getContatos(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        lvContatos.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listarContatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}