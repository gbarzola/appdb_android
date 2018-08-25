package com.example.alumnos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GeneroMusicalNuevoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void grabar(View view) {

        EditText titulo = (EditText) findViewById(R.id.titulo);
        EditText descripcion = (EditText) findViewById(R.id.descripcion);

        GeneroMusicalDAO dao = new GeneroMusicalDAO(getBaseContext());
        try {
            //dao.eliminarTodos();
            dao.insertar(titulo.getText().toString(), descripcion.getText().toString());

            Toast toast= Toast.makeText(getApplicationContext(), "Se insertó correctamente", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            titulo.setText("");
            descripcion.setText("");
        } catch (DAOException e) {
            Log.i("GeneroMusicalNuevoActi", "====> " + e.getMessage());
        }
    }

}
