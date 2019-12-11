package com.viiruzz.emergencygo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UsuariosActivity extends AppCompatActivity {

    private RecyclerView RecyclerViewUsuarios;
    private UsuarioAdaptador adaptadorUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        RecyclerViewUsuarios=(RecyclerView)findViewById(R.id.recyclerUsu);
        RecyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));

        BaseDatosActivity baseDatosActivity=new BaseDatosActivity(getApplicationContext());

        adaptadorUsuario=new UsuarioAdaptador(baseDatosActivity.mostrarUsuarios());
        RecyclerViewUsuarios.setAdapter(adaptadorUsuario);
    }

}
