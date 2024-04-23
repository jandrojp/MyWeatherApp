package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity implements CallInterface {


    private Root root;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private TextView nombreCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mostramos la barra de progreso y ejecutamos la llamada a la API
        showProgress();
        executeCall(this);
    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        Bundle extras = getIntent().getExtras();
        root = Connector.getConector().get(Root.class,"&lat=" + extras.getDouble("latitud") + "&lon=" + extras.getDouble("longitud"));
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();

        recyclerView = findViewById(R.id.recycler);
        floatingActionButton = findViewById(R.id.buttonReturn);
        nombreCiudad = findViewById(R.id.nombreCiudad);

        recyclerView.setAdapter(new AdaptadorRecycler(this, root));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);



        floatingActionButton.setOnClickListener(view -> finish());

        Bundle extras = getIntent().getExtras();
        nombreCiudad.setText(extras.getString("nombreCiudad").toString());
    }


}