package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.activities.preferencias.IdiomSetUp;
import com.example.myweatherbase.activities.preferencias.ThemeSetup;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailsActivity extends AppCompatActivity {

    private ImageView clima;
    private FloatingActionButton buttonReturn;
    private TextView grados;
    private TextView sensacionTermica;
    private TextView descripcion;
    private TextView temperaturaMinima;
    private TextView temperaturaMaxima;
    private TextView humedad;
    private TextView presion;
    private TextView velViento;
    private TextView rafagas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ThemeSetup.applyPreferenceTheme(getApplicationContext());
        IdiomSetUp.applyPreferenceIdiom(getApplicationContext());

        clima = findViewById(R.id.clima);
        buttonReturn = findViewById(R.id.buttonReturn);
        grados = findViewById(R.id.grados);
        sensacionTermica = findViewById(R.id.sensacionTermica);
        descripcion = findViewById(R.id.descripcionTiempo);
        temperaturaMinima = findViewById(R.id.tempMinima);
        temperaturaMaxima = findViewById(R.id.tempMaxima);
        humedad = findViewById(R.id.humedad);
        presion = findViewById(R.id.presion);
        velViento = findViewById(R.id.velViento);
        rafagas = findViewById(R.id.rafagas);


        Root root = (Root) getIntent().getExtras().get("root");
        int position = getIntent().getExtras().getInt("position");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, clima);
        grados.setText((int)root.list.get(position).main.temp + "º");
        sensacionTermica.setText((int)root.list.get(position).main.feels_like + "º C");
        descripcion.setText(root.list.get(position).weather.get(0).description.substring(0, 1).toUpperCase() + root.list.get(position).weather.get(0).description.substring(1));
        temperaturaMinima.setText((int)root.list.get(position).main.temp_min + "º");
        temperaturaMaxima.setText((int)root.list.get(position).main.temp_max + "º");
        humedad.setText(root.list.get(position).main.humidity + "%");
        presion.setText(root.list.get(position).main.pressure + " hPa");
        velViento.setText((int)root.list.get(position).wind.speed + " km/h");
        rafagas.setText((int)root.list.get(position).wind.gust + " km/h");

        buttonReturn.setOnClickListener(view -> finish());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
