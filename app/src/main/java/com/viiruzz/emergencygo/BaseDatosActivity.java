package com.viiruzz.emergencygo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosActivity extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="cuentas.bd";
    private static final int VERSION_BD=1;
    private static final  String TABLA_CUENTAS="CREATE TABLE CUENTAS(USUARIO TEXT PRIMARY KEY, NOMBRE TEXT, " +
            "APELLIDO TEXT, RUT TEXT, TELEFONO TEXT, FECHANAC TEXT, PASSWORD TEXT)";

    public BaseDatosActivity(Context context) {
        super(context, NOMBRE_BD,null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CUENTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_CUENTAS);
        sqLiteDatabase.execSQL(TABLA_CUENTAS);
    }

    public void agregarCuenta(String usuario, String nombre, String apellido, String rut, String telefono, String fechanac,
                              String password){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO CUENTAS VALUES('"+usuario+"','"+nombre+"','"+apellido+"','"+rut+"','"+telefono+"','"+fechanac+"','"+password+"')");
            bd.close();
        }
    }

    public List<UsuarioModel> mostrarUsuarios(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT usuario, nombre, apellido, rut, telefono, fechanac FROM CUENTAS",null);
        List<UsuarioModel> cuentas=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                cuentas.add(new UsuarioModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                        cursor.getString(4),cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return cuentas;
    }

    public void buscarUsuarios(UsuarioModel cuentas,String usuario) {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM CUENTAS WHERE USUARIO='" + usuario + "'", null);
        if (cursor.moveToFirst()) {
            do {
                cuentas.setNombre(cursor.getString(1));
                cuentas.setApellido(cursor.getString(2));
                cuentas.setRut(cursor.getString(3));
                cuentas.setTelefono(cursor.getString(4));
                cuentas.setFecha(cursor.getString(5));
                cuentas.setPassword(cursor.getString(6));
            } while (cursor.moveToNext());
        }
    }

    public void editarUsuarios(String usuario, String nombre, String apellido, String rut, String telefono, String fechanac,
                               String password){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("UPDATE CUENTAS SET NOMBRE='"+nombre+"', APELLIDO='"+apellido+"', RUT='"+rut+"', TELEFONO='"+telefono+"', " +
                    "FECHANAC='"+fechanac+"', PASSWORD='"+password+"' WHERE USUARIO='"+usuario+"'");
            bd.close();
        }
    }

    public void eliminarUsuarios(String usuario){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DELETE FROM CUENTAS WHERE USUARIO='"+usuario+"'");
            bd.close();
        }
    }
}
