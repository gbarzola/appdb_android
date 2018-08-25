package com.example.alumnos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class GeneroMusicalBuscarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero_musical_buscar);
    }

    public void buscar(View view) {
        EditText criterio = (EditText) findViewById(R.id.criterio);
        GeneroMusicalDAO dao = new GeneroMusicalDAO(getBaseContext());
        try {
            ArrayList<GeneroMusical> resultados = dao.buscar(criterio.getText().toString());

            String[] encontrados = new String[resultados.size()];
            int i = 0;
            for (GeneroMusical gm : resultados){
                encontrados[i++] = gm.getTitulo();
            }


            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this.getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    encontrados);

            ListView listaResultados = (ListView)findViewById(R.id.listaResultados);
            listaResultados.setAdapter(adaptador);


        } catch (DAOException e) {
            Log.i("GeneroMusicalBuscarAc", "====> " + e.getMessage());
        }
    }

}
