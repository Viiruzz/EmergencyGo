package com.viiruzz.emergencygo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {

    public Button btEditar, btEliminar, btBuscar;
    EditText editUsuario, editNombre, editApellido, editRut, editTel, editPass, editNFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        editUsuario=(EditText)findViewById(R.id.editUsuario);
        editNombre=(EditText)findViewById(R.id.editNombre);
        editApellido=(EditText)findViewById(R.id.editApellido);
        editRut=(EditText)findViewById(R.id.editRut);
        editTel=(EditText)findViewById(R.id.editTel);
        editPass=(EditText)findViewById(R.id.editPass);
        editNFecha=(EditText)findViewById(R.id.editFecha);
        btEditar = findViewById(R.id.button_editar);
        btEliminar = findViewById(R.id.button_eliminar);
        btBuscar = findViewById(R.id.button_buscar);

        final BaseDatosActivity bdActivity=new BaseDatosActivity(getApplicationContext());

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioModel usuarios= new UsuarioModel();
                bdActivity.buscarUsuarios(usuarios,editUsuario.getText().toString());
                editNombre.setText(usuarios.getNombre());
                editApellido.setText(usuarios.getApellido());
                editRut.setText(usuarios.getRut());
                editTel.setText(usuarios.getTelefono());
                editNFecha.setText(usuarios.getFecha());
                editPass.setText(usuarios.getPassword());
            }
        });

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdActivity.editarUsuarios(editUsuario.getText().toString(),editNombre.getText().toString(),editApellido.getText().toString(),
                        editRut.getText().toString(), editTel.getText().toString(), editNFecha.getText().toString(), editPass.getText().toString());
                Toast.makeText(getApplicationContext(),"Usuario modificado",Toast.LENGTH_SHORT).show();
            }
        });

        btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdActivity.eliminarUsuarios(editUsuario.getText().toString());
                Toast.makeText(getApplicationContext(),"Usuario eliminado",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
