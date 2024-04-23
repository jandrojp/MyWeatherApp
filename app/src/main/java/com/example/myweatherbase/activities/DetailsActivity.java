package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailsActivity extends AppCompatActivity {

    private ImageView clima;
    private FloatingActionButton buttonReturn;
    private TextView grados;
    private TextView sensacionTermica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        clima = findViewById(R.id.clima);
        buttonReturn = findViewById(R.id.buttonReturn);
        grados = findViewById(R.id.grados);
        sensacionTermica = findViewById(R.id.sensacionTermica);


        Root root = (Root) getIntent().getExtras().get("root");
        int position = getIntent().getExtras().getInt("position");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, clima);
        grados.setText((int)root.list.get(position).main.temp + "º");
        sensacionTermica.setText((int)root.list.get(position).main.feels_like + "º C");

        buttonReturn.setOnClickListener(view -> finish());
    }
}
