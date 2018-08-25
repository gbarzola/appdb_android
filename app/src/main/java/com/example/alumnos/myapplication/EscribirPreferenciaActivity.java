package com.example.alumnos.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EscribirPreferenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir_preferencia);
    }

    public void guardarPreferencia(View view) {

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        SharedPreferences prefs = getSharedPreferences("PREFERENCIAS",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("CADENA", editText1.getText().toString());
        editor.commit();
        Toast toast= Toast.makeText(getApplicationContext(), "Dato grabado en el SharedPreferences", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

    }

}
