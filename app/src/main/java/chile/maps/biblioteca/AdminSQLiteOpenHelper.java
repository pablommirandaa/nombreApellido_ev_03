package chile.maps.biblioteca;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String command = "CREATE TABLE libros(codigo int primary key, nombre text, precio int)";
        db.execSQL(command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean isCorrect(String nombre, String precio) {
        String sql = "nombre = '" + nombre + "' AND precio = " + precio;
        SQLiteDatabase baseDeDatos = this.getReadableDatabase();
        Cursor c = baseDeDatos.query("libros", null, sql, null, null, null, null);
        boolean resultado = c.moveToFirst();
        baseDeDatos.close();

        return resultado;
    }
}