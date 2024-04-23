package com.example.myweatherbase.activities;

import com.example.myweatherbase.R;

public enum Ciudad implements Listable {
    VALENCIA(R.drawable.escudo_valencia, "Valencia", 39.4078888, -0.4439123),
    MADRID(R.drawable.escudo_madrid, "Madrid", 40.4380986, -3.8443454),
    BARCELONA(R.drawable.escudo_barcelona, "Barcelona", 41.3927673, 2.0577882),
    SEVILLA(R.drawable.escudo_sevilla, "Sevilla", 37.3754786, -6.0374593),
    BILBAO(R.drawable.escudo_bilbao, "Bilbao", 43.2633596, -3.0115041);

    private int escudo;
    private String nombre;
    private double latitud;
    private double longitud;

    Ciudad(int escudo, String nombre, double latitud, double longitud) {
        this.escudo = escudo;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() { return nombre; }
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }

    @Override
    public String getDescription() {
        return this.name();
    }

    @Override
    public int getDrawableSymbol() {
        return escudo;
    }
}
