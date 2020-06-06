package com.example.progranegocioseje1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //declaramos variables, estas tienen el mismo nombre del id de los objetos
    private EditText TituloTxt;
    private EditText DescTxt;

    //creamos shareprefences
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencias siempre van ubicadas aqui
        TituloTxt = findViewById(R.id.TituloTxt);
        DescTxt = findViewById(R.id.DescTxt);

        //iniciamos el editor,antes meterlo en una variable, almacenamiento en disco
        preferences = getSharedPreferences(  "MyTODOList", MODE_PRIVATE);
        editor = preferences.edit();

        TituloTxt.setText(preferences.getString("Titulo", ""));
    }

    public void onClickAgregar(View view){
        //programacion del boton
        editor.putString("Titulo",TituloTxt.getText().toString());
        editor.commit();
    }
}
