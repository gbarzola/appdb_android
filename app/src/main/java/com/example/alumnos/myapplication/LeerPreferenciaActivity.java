package com.example.alumnos.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LeerPreferenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_preferencia);
    }

    public void leerPreferencia(View v){
        SharedPreferences prefs = getSharedPreferences("PREFERENCIAS", Context.MODE_PRIVATE);
        String cadena = prefs.getString("CADENA", "");
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(cadena);
    }


}
