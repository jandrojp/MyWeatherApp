package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date date = new Date((long)root.list.get(position).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("EEEE");
        SimpleDateFormat dateDay = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateHour = new SimpleDateFormat("HH:mm");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, viewHolder.imagenTiempo);
        viewHolder.diaSemana.setText(dateDayOfWeek.format(date).toUpperCase());
        viewHolder.descripcion.setText(root.list.get(position).weather.get(0).description);
        viewHolder.temperatura.setText(root.list.get(position).main.temp + "º");
        viewHolder.fecha.setText(dateDay.format(date));
        viewHolder.hora.setText(dateHour.format(date));
        viewHolder.temperaturaMaxima.setText(root.list.get(position).main.temp_max + "º");
        viewHolder.temperaturaMinima.setText(root.list.get(position).main.temp_min + "º");
    }

    @Override
    public int getItemCount() {
        return root.list.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenTiempo;
        private TextView diaSemana;
        private TextView descripcion;
        private TextView temperatura;
        private TextView fecha;
        private TextView hora;
        private TextView temperaturaMaxima;
        private TextView temperaturaMinima;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagenTiempo = itemView.findViewById(R.id.imageWeather);
            diaSemana = itemView.findViewById(R.id.diaSemana);
            descripcion = itemView.findViewById(R.id.descripcion);
            temperatura = itemView.findViewById(R.id.temperatura);
            fecha = itemView.findViewById(R.id.fecha);
            hora = itemView.findViewById(R.id.hora);
            temperaturaMaxima = itemView.findViewById(R.id.temperaturaMaxima);
            temperaturaMinima = itemView.findViewById(R.id.temperaturaMinima);
        }
    }

}

