package com.example.eag.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = (EditText) findViewById(R.id.correo);

        //Creamos una nueva SharedPreferences al iniciar nuestra aplicación para recuperar
        //los datos guardados
        SharedPreferences guardado = getSharedPreferences("datos", Context.MODE_PRIVATE);

        //Mostramos el valor recuperado de la SharedPreferences
        correo.setText(guardado.getString("mail",""));


}


    public void guardar(View view){

        //Creamos una SharedPreferences llamada "datos"
        SharedPreferences guardar = getSharedPreferences("datos",Context.MODE_PRIVATE);


        //Creamos un objeto editor y le decimos que SharedPreferences queremos editar
        SharedPreferences.Editor obj_editor = guardar.edit();

        //Guardamos en "datos" un campo llamado "mail" y su contenido
        obj_editor.putString("mail",correo.getText().toString());


        //Guardamos la preferencia
        obj_editor.commit();
    }
}
