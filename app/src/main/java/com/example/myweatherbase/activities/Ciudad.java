package com.example.myweatherbase.activities;

import com.example.myweatherbase.R;

public enum Ciudad implements Listable {
    VALENCIA(R.drawable.escudo_valencia, 39.4078888, -0.4439123),
    MADRID(R.drawable.escudo_madrid, 40.4380986, -3.8443454),
    BARCELONA(R.drawable.escudo_barcelona, 41.3927673, 2.0577882),
    SEVILLA(R.drawable.escudo_sevilla, 37.3754786, -6.0374593),
    BILBAO(R.drawable.escudo_bilbao, 43.2633596, -3.0115041);

    private int escudo;
    private String nombre;
    private double latitud;
    private double longitud;

    Ciudad(int escudo, double latitud, double longitud) {
        this.escudo = escudo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

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
