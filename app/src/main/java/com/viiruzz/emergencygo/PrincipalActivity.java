package com.viiruzz.emergencygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    public Button button_mapa;
    public Button button_usuarios;
    public Button button_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        button_usuarios=findViewById(R.id.button_user);
        button_mapa=findViewById(R.id.button_mapa);
        button_admin=findViewById(R.id.button_admin);

        button_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re = new Intent(PrincipalActivity.this,MapsActivity.class);
                re.putExtra("Mapas","");
                startActivity(re);
                Toast.makeText(getApplicationContext(),"Accediendo a Mapas",Toast.LENGTH_SHORT).show();
            }
        });

        button_usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usu = new Intent(PrincipalActivity.this,UsuariosActivity.class);
                usu.putExtra("Usuarios","");
                startActivity(usu);
                Toast.makeText(getApplicationContext(),"Accediendo a listas",Toast.LENGTH_SHORT).show();
            }
        });

        button_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adm = new Intent(PrincipalActivity.this,AdminActivity.class);
                adm.putExtra("Admin","");
                startActivity(adm);
                Toast.makeText(getApplicationContext(),"Accediendo como Administrador",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
