package com.example.progranegocioseje1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //declaramos variables, estas tienen el mismo nombre del id de los objetos
    private EditText TituloTxt;
    private EditText DescTxt;

    //creamos shareprefences
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    //crear coleccion de tareas
    private JSONArray TodoListStore;

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

        try {
            TodoListStore = new JSONArray(preferences.getString("data","[]"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void onClickAgregar(View view) throws JSONException{
        String Title = TituloTxt.getText().toString();
        String Desc = DescTxt.getText().toString();

        JSONObject TodoListItem = new JSONObject();


        TodoListItem.put(Title,Desc);
        TodoListStore.put(TodoListItem);

        //programacion del boton
        editor.putString("data",TituloTxt.getText().toString());
        editor.commit();

        TituloTxt.setText("");
        DescTxt.setText("");

        Toast.makeText(this,"Tarea Agregada Exitosamente",Toast.LENGTH_SHORT).show();

        System.out.println(TodoListStore.toString());
    }
}
