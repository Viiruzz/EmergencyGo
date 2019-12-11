package com.viiruzz.emergencygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    public Button btRegistrar;
    EditText editUsuario, editNombre, editApellido, editRut, editTel, editPass, editNFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        final BaseDatosActivity basedatosBD=new BaseDatosActivity(getApplicationContext());


        String re = getIntent().getStringExtra("Registrar");

        editUsuario=(EditText)findViewById(R.id.editUsuario);
        editNombre=(EditText)findViewById(R.id.editNombre);
        editApellido=(EditText)findViewById(R.id.editApellidos);
        editRut=(EditText)findViewById(R.id.editRut);
        editTel=(EditText)findViewById(R.id.editTel);
        editPass=(EditText)findViewById(R.id.editPass);
        editNFecha=(EditText)findViewById(R.id.editFecha);
        btRegistrar = findViewById(R.id.button_crear);


        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basedatosBD.agregarCuenta(editUsuario.getText().toString(),editNombre.getText().toString(),editApellido.getText().toString(),
                        editRut.getText().toString(),editTel.getText().toString(),editNFecha.getText().toString(),editPass.getText().toString());
                Toast.makeText(getApplicationContext(),"Cuenta creada ", Toast.LENGTH_SHORT)
                        .show();
                Intent re = new Intent(RegistrarActivity.this,MainActivity.class);
                re.putExtra("Registrar","");
                startActivity(re);
            }
        });
    }
}
