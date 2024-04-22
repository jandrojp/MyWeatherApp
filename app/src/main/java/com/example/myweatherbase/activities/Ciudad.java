package com.example.myweatherbase.activities;

import com.example.myweatherbase.R;

public enum Ciudad implements Listable {
    VALENCIA(R.drawable.escudo_valencia),
    MADRID(R.drawable.escudo_madrid),
    BARCELONA(R.drawable.escudo_barcelona);

    private int escudo;

    Ciudad(int escudo) {
        this.escudo = escudo;
    }

    @Override
    public String getDescription() {
        return this.name();
    }

    @Override
    public int getDrawableSymbol() {
        return escudo;
    }
}
