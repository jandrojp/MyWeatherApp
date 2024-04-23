package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;

public class DetailsActivity extends AppCompatActivity {

    private ImageView clima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        clima = findViewById(R.id.clima);
    }
}
