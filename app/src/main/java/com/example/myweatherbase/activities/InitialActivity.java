package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.preferencias.IdiomSetUp;
import com.example.myweatherbase.activities.preferencias.PreferenciasActivity;
import com.example.myweatherbase.activities.preferencias.ThemeSetup;

public class InitialActivity extends AppCompatActivity {
    private ImageView imagenCiudades;
    private Spinner spinnerCiudades;
    private Button buttonPrevision;
    private String nombreCiudad;
    private double latitud;
    private double longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        ThemeSetup.applyPreferenceTheme(getApplicationContext());
        IdiomSetUp.applyPreferenceIdiom(getApplicationContext());

        imagenCiudades = findViewById(R.id.imageCiudad);
        spinnerCiudades = findViewById(R.id.spinnerCiudades);
        buttonPrevision = findViewById(R.id.buttonPrevision);

        spinnerCiudades.setAdapter(new AdaptadorSpinner<>(this, R.layout.custom_spinner, Ciudad.values()));

        spinnerCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getSelectedItem().equals(Ciudad.VALENCIA)) {
                    imagenCiudades.setImageResource(R.drawable.ciudad_artes);

                } else if (adapterView.getSelectedItem().equals(Ciudad.MADRID)) {
                    imagenCiudades.setImageResource(R.drawable.palacio_real);

                } else if (adapterView.getSelectedItem().equals(Ciudad.BARCELONA)) {
                    imagenCiudades.setImageResource(R.drawable.sagrada_familia);

                } else if (adapterView.getSelectedItem().equals(Ciudad.SEVILLA)) {
                    imagenCiudades.setImageResource(R.drawable.giralda);

                } else if (adapterView.getSelectedItem().equals(Ciudad.BILBAO)) {
                    imagenCiudades.setImageResource(R.drawable.museo_guggenheim);
                }

                Ciudad ciudad = (Ciudad) adapterView.getSelectedItem();
                nombreCiudad = ciudad.name();
                latitud = ciudad.getLatitud();
                longitud = ciudad.getLongitud();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonPrevision.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("nombreCiudad", nombreCiudad);
            intent.putExtra("latitud", latitud);
            intent.putExtra("longitud", longitud);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.configuracion):
                Intent intentPreferenciasActivity = new Intent(this, PreferenciasActivity.class);
                startActivity(intentPreferenciasActivity);
                return true;
            case (R.id.exit):
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
