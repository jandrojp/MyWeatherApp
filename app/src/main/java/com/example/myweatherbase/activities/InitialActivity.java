package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myweatherbase.R;

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

        imagenCiudades = findViewById(R.id.imageCiudad);
        spinnerCiudades = findViewById(R.id.spinnerCiudades);
        buttonPrevision = findViewById(R.id.buttonPrevision);

        spinnerCiudades.setAdapter(new AdaptadorSpinner<>(this, R.layout.custom_spinner, Ciudad.values()));

        spinnerCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getSelectedItem().equals(Ciudad.VALENCIA)) {
                    imagenCiudades.setImageResource(R.drawable.fondo_valencia);

                } else if (adapterView.getSelectedItem().equals(Ciudad.MADRID)) {
                    imagenCiudades.setImageResource(R.drawable.fondo_madrid);

                } else if (adapterView.getSelectedItem().equals(Ciudad.BARCELONA)) {
                    imagenCiudades.setImageResource(R.drawable.fondo_barcelona);

                } else if (adapterView.getSelectedItem().equals(Ciudad.SEVILLA)) {
                    imagenCiudades.setImageResource(R.drawable.fondo_sevilla);

                } else if (adapterView.getSelectedItem().equals(Ciudad.BILBAO)) {
                    imagenCiudades.setImageResource(R.drawable.fondo_bilbao);
                }

                Ciudad ciudad = (Ciudad) adapterView.getSelectedItem();
                nombreCiudad = ciudad.getNombre();
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
}
