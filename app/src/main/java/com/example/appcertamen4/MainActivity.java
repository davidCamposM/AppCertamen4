package com.example.appcertamen4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText titulo, contenido;
    Spinner sp;
    ArrayList<String> itemLista;
    ArrayAdapter<String>adapter;
    
    //Lista con notas
    ArrayList<Nota> notas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = findViewById(R.id.txtTitulo);
        contenido = findViewById(R.id.txtContenido);
        sp = findViewById(R.id.spinnerrr);

        itemLista = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,itemLista);
        //Setteamos el adaptador
        sp.setAdapter(adapter);

    }


    public void agregarItem(View view){
        String txtTitulo = titulo.getText().toString();
        String txtContenido = contenido.getText().toString();

        if(!txtTitulo.isEmpty() && !txtContenido.isEmpty()){
            Nota notas1 = new Nota(txtTitulo, txtContenido);
            notas.add(notas1);
            Toast.makeText(this, "Nota ingresada con éxito!", Toast.LENGTH_SHORT).show();
            //Notificar al adaptador del cambio
            adapter.notifyDataSetChanged();
            
        } else {
            Toast.makeText(this, "Favor no dejar espacios en blanco!", Toast.LENGTH_SHORT).show();
        }
    }

}