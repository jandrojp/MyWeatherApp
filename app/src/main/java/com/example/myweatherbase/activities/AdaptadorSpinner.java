package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.myweatherbase.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorSpinner<T extends Listable> extends ArrayAdapter<T> {
    private int resource;

    public AdaptadorSpinner(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, new ArrayList<>(List.of(objects)));
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = convertView;
        if(customView==null)
            customView = LayoutInflater.from(getContext()).inflate(resource, parent,false);

        T item = getItem(position);
        TextView color = customView.findViewById(R.id.city);
        ImageView logo = customView.findViewById(R.id.imageEscudo);

        color.setText(item.getDescription());
        logo.setImageResource(item.getDrawableSymbol());

        return customView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = convertView;
        if(customView==null)
            customView = LayoutInflater.from(getContext()).inflate(resource, parent,false);

        T item = getItem(position);
        TextView color = customView.findViewById(R.id.city);
        ImageView logo = customView.findViewById(R.id.imageEscudo);

        color.setText(item.getDescription());
        logo.setImageResource(item.getDrawableSymbol());

        return customView;
    }
}
