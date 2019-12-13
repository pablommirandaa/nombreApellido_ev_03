package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Github_act extends AppCompatActivity {

    Spinner spnGithub;
    TextView tvGithub;
    String[] libros;
    String[] precios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spnGithub = (Spinner)findViewById(R.id.spnGithub);
        tvGithub = (TextView)findViewById(R.id.tvGithub);

        Bundle dat = getIntent().getExtras();
        libros = dat.getStringArray("libros");
        precios = dat.getStringArray("precios");

        ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, libros);

        spnGithub.setAdapter(adapt);

        spnGithub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spnGithub.getSelectedItem().equals("Farenheith"))
                {
                    tvGithub.setText("el valor de " + libros[0] + " es: "+ precios[0]);
                }
                if(spnGithub.getSelectedItem().equals("Revival"))
                {
                    tvGithub.setText("el valor de " + libros[1] + " es: "+ precios[1]);
                }
                if(spnGithub.getSelectedItem().equals("El Alquimista"))
                {
                    tvGithub.setText("el valor de " + libros[2] + " es: "+ precios[2]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
    }
}
