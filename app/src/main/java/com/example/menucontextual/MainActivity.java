package com.example.menucontextual;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.botonColores);
        registerForContextMenu(boton);

        texto = findViewById(R.id.tV_Tamaño);
        registerForContextMenu(texto);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        switch (v.getId())
        {
            case R.id.botonColores:
                inflater.inflate(R.menu.cambiar_color, menu);
                break;
            case R.id.tV_Tamaño:
                inflater.inflate(R.menu.cambiar_tamano, menu);
                break;
        }
        menu.setHeaderTitle("Menu Contextual");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.rojo:
                boton.setBackgroundColor(getResources().getColor(R.color.rojo, null));
                break;
            case R.id.azul:
                boton.setBackgroundColor(getResources().getColor(R.color.azul,null));
                break;
            case R.id.verde:
                boton.setBackgroundColor(getResources().getColor(R.color.verde,null));
                break;
            case R.id.pequeño:
                texto.setTextSize(12);
                break;
            case R.id.mediano:
                texto.setTextSize(25);
                break;
            case R.id.grande:
                texto.setTextSize(48);
                break;
        }
        return  true;
    }
}
