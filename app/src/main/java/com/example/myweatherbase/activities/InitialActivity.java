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
                    imagenCiudades.setImageResource(R.drawable.fondo_valencia);

                } else if (adapterView.getSelectedItem().equals(Ciudad.BARCELONA)) {
                    imagenCiudades.setImageResource(R.drawable.fondo_valencia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonPrevision.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
