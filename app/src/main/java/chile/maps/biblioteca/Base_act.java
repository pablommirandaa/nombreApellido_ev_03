package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {

    private EditText etCodigo, etNombre, etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        etCodigo = (EditText)findViewById(R.id.etCodigo);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etPrecio = (EditText)findViewById(R.id.etPrecio);
    }

    public void insert(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        if(!etCodigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", etCodigo.getText().toString());
            registro.put("nombre", etNombre.getText().toString());
            registro.put("precio", etPrecio.getText().toString());

            baseDeDatos.insert("libros", null, registro);
            baseDeDatos.close();

            Toast.makeText(this, "Se ha ingresado un Libro", Toast.LENGTH_LONG).show();
        }
    }

    public void update(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();


        if(!etCodigo.getText().toString().isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", etCodigo.getText().toString());
            cont.put("nombre", etNombre.getText().toString());
            cont.put("precio", etPrecio.getText().toString());

            baseDeDatos.update("libros",cont,"codigo="+etCodigo.getText().toString(), null);
            baseDeDatos.close();

            Toast.makeText(this, "Se ha actualizado el libro con el codigo " + etCodigo.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void delete(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();


        if (!etCodigo.getText().toString().isEmpty()) {
            baseDeDatos.delete("libros", "codigo=" + etCodigo.getText().toString(), null);
            baseDeDatos.close();

            Toast.makeText(this, "Se ha eliminado el libro con el codigo " + etCodigo.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }
}
