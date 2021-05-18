package com.example.spacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AFA extends AppCompatActivity {

    private View Ang;
    private View Fr;
    private View Ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afa);

        Ang = findViewById(R.id.ang);
        Ang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                intent.putExtra("language", "An");
                startActivity(intent);
            }
        });

        Ar = findViewById(R.id.ar);
        Ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                intent.putExtra("language", "Ar");

                startActivity(intent);
            }
        });

        Fr = findViewById(R.id.fr);
        Fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                intent.putExtra("language", "Fr");

                startActivity(intent);
            }
        });

    }

}