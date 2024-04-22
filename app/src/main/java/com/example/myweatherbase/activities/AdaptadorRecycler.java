package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private Root root;

    public AdaptadorRecycler(@NonNull Context context, Root root) {
        this.context = context;
        this.root = root;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, viewHolder.imagenTiempo);
    }

    @Override
    public int getItemCount() {
        return root.list.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenTiempo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenTiempo = itemView.findViewById(R.id.imageWeather);
        }
    }

}

