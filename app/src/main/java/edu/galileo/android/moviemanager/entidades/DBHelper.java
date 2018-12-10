package edu.galileo.android.moviemanager.entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        String query="create table usuario(id integer primary key autoincrement, " +
                "Nombre text, Correo text, Password text);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
    //permite abrir la db
    public void abrir(){
        this.getWritableDatabase();
    }
    //permite cerrar db
    public void cerrar(){
        this.close();
    }

    //metodo para insertar en la tabla usuario
    public void insertarRegistro(String nombre,String correo, String password) {
        ContentValues valores = new ContentValues();
        //put para poder agregar valores
        valores.put("Nombre", nombre);
        valores.put("Correo", correo);
        valores.put("Password", password);
        //Grabar los datos en la tabla comando
        this.getWritableDatabase().insert("usuario", null, valores);

    }

    //Metodo valida usuario
    public Cursor ConsultarUsuPas(String usu, String pas) throws SQLException {
        Cursor mcursor = null;
        //leer base de datos
        mcursor= this.getReadableDatabase().query("usuario", new String[]{"id","Nombre","Correo","Password"},
                "Correo like '"+usu+"' and Password like '"+pas+"'",null,null,null,null);
        return mcursor;
    }
}
