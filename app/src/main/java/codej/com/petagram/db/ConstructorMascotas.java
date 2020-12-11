package codej.com.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import codej.com.petagram.R;
import codej.com.petagram.db.BaseDatos;
import codej.com.petagram.db.ConstantesBaseDatos;
import codej.com.petagram.model.Mascota;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(String opcion) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        switch (opcion)
        {
            case ConstantesBaseDatos.MASCOTAS_FAV: mascotas = db.obtener5MascotasFav();
                break;
            case ConstantesBaseDatos.MASCOTAS_T: mascotas = db.obtenerTodosLosContactos();
                break;
        }
        return mascotas;
    }


    public void insertarMascotas(BaseDatos db) {
        if (!(db.existeTablaMascotas())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Checko");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota7);

            db.insertarContacto(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Barth");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.cheko);

            db.insertarContacto(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Firulais");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota1);

            db.insertarContacto(contentValues);


            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Pink");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota5);

            db.insertarContacto(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Boby");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota2);

            db.insertarContacto(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Cloe");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota4);

            db.insertarContacto(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Firulais");
            contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota1);

            db.insertarContacto(contentValues);
        }
    }

    public void darLikeCotnacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascota);
    }


}
