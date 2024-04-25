package com.example.myweatherbase.activities.preferencias;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import java.util.Locale;


public final class IdiomSetUp {

    private IdiomSetUp() {
    }

    public enum Idiom {
        ESPANYOL, INGLES, ITALIANO
    }

    public static void applyIdiom(Idiom idiom) {
        switch (idiom) {
            case INGLES:


                break;
            case ITALIANO:


                break;
            default:


        }
    }

    public static void applyPreferenceIdiom(Context context) {
        applyIdiom(Idiom.valueOf(GestionPreferencias.getInstance().getIdiom(context)));
    }
}
