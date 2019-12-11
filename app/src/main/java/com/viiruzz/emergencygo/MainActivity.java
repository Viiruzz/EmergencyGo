package com.viiruzz.emergencygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btIniciar;
    public Button btEmergency;
    public EditText etUsuario;
    public EditText etPass;
    public TextView txtregister;
    public Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String main = getIntent().getStringExtra("Register");

        btIniciar= findViewById(R.id.button_iniciar);
        btEmergency= findViewById(R.id.button_emg);
        etUsuario= findViewById(R.id.editUsuario);
        etPass= findViewById(R.id.editPass);
        btRegister= findViewById(R.id.button_reg);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent re = new Intent(MainActivity.this,RegistrarActivity.class);
                re.putExtra("Registrar","");
                startActivity(re);
            }
        });

        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usu = etUsuario.getText().toString();

                    Toast.makeText(getApplicationContext(),"Bienvenido " + usu, Toast.LENGTH_SHORT)
                            .show();

                    Intent i = new Intent(MainActivity.this,PrincipalActivity.class);
                    i.putExtra("Principal","");
                    startActivity(i);
                }
        });

        btEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Accediendo a Mapa", Toast.LENGTH_SHORT)
                        .show();

                Intent m = new Intent(MainActivity.this,MapsActivity.class);
                m.putExtra("Mapas","");
                startActivity(m);
            }
        }
        );
    }
}
