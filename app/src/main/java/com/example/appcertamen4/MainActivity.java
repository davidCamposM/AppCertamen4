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

        visualizarItems();

    }


    public void agregarItem(View view){
        String txtTitulo = titulo.getText().toString();
        String txtContenido = contenido.getText().toString();

        if(!txtTitulo.isEmpty() && !txtContenido.isEmpty()){
            Nota notas1 = new Nota(txtTitulo, txtContenido);
            notas.add(notas1);
            Toast.makeText(this, "Nota ingresada con éxito!", Toast.LENGTH_SHORT).show();
            visualizarItems();
            //Notificar al adaptador del cambio
            adapter.notifyDataSetChanged();
            
        } else {
            Toast.makeText(this, "Favor no dejar espacios en blanco!", Toast.LENGTH_SHORT).show();
        }
    }

    public void visualizarItems(){
        itemLista.clear();

        for(int i = 0; i < notas.size(); i++){
            Nota notas2 = notas.get(i);

            //String de datos para manejar la visualizacion
            String datos = "Título: " + notas2.getTitulo() + "\n" + "Contenido: " + notas2.getContenido();
            itemLista.add(datos);
        }


    }

}