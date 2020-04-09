package com.example.a02_fragment_dinamicos;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    boolean cargarFragmento2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Botón flotante
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Modificar el Fragmento que sale en la pantalla
                //dentro del container

                Fragment f = null;
                if(cargarFragmento2) {
                    f = new SegundoFragment();
                } else{
                    f = new PrimerFragment();
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
                cargarFragmento2 = !cargarFragmento2;
            }
        });

        //Rescatamos el contenedor y le vamos a cargar un fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new PrimerFragment())
                .commit();
    }


}
