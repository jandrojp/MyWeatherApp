package com.example.myweatherbase.activities.preferencias;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.Parameters;

import java.util.Locale;


public final class IdiomSetUp {

    private IdiomSetUp() {
    }

    public enum Idiom {
        ESPANYOL, INGLES
    }

    public static void applyIdiom(Idiom idiom, Context context) {
        switch (idiom) {
            case INGLES:
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = context.getResources().getConfiguration();
                config.locale = locale;
                context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
                break;
        }
    }

    public static void applyPreferenceIdiom(Context context) {
        applyIdiom(Idiom.valueOf(GestionPreferencias.getInstance().getIdiom(context)), context);
    }
}
