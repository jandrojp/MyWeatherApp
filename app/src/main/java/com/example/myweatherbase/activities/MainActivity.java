package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends BaseActivity implements CallInterface {


    private Root root;
    private RecyclerView recyclerView;

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
        root = Connector.getConector().get(Root.class,"&lat=39.4078888&lon=-0.4439123");
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();

        recyclerView = findViewById(R.id.recycler);

        recyclerView.setAdapter(new AdaptadorRecycler(this, root));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}