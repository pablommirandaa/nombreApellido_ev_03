package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sec_act extends AppCompatActivity {

    private TextView tvSalidaIncidencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);

        tvSalidaIncidencia = (TextView) findViewById(R.id.tvSalidaIncidencia);
    }

    public void incidencia(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA", null, 1);

        if(admin.isCorrect("este libro no existe","1006541 OR 1=1"))
            tvSalidaIncidencia.setText("Sql Injection");
    }

    public void segundaIncidencia(View view)
    {
        String hardcodedPassword = "android";

        if(hardcodedPassword.equals("android"))
        {
            tvSalidaIncidencia.setText("Hardcoded Password");
        }
    }
}
