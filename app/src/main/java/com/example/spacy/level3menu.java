package com.example.spacy;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

public class level3menu extends AppCompatActivity {
    private CardView card11;
    private CardView card13;
    private String language;
    private TextView QZ, clot,bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        language = intent.getStringExtra("language");
        setContentView(R.layout.activity_level3);

        QZ = findViewById(R.id.quiz13);
        clot = findViewById(R.id.clothes1);
        bd = findViewById(R.id.body1);

        if (language.equals("Fr")) {
            QZ.setText("QUIZ");
            clot.setText("Vêtement");
            bd.setText("corps");

        } else if (language.equals("Ar")) {
            QZ.setText("اختبار");
            clot.setText("ملابس");
            bd.setText("جسم");
        }


        CardView clooth = findViewById(R.id.card12);
        card11 = findViewById(R.id.card11);
        card13 = findViewById(R.id.card13);

        card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {

                    Intent intentt = new Intent(level3menu.this, Quiz3AN.class);
                    startActivity(intentt);

                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(level3menu.this,Quiz3Fr.class);
                    startActivity(intent);
                } else if (language.equals("Ar")) {
                    Intent intent = new Intent(level3menu.this, Quiz3Ar.class);
                    startActivity(intent);
                }
            }
        });

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(level3menu.this, body_ang.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(level3menu.this, body_fr.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(level3menu.this, body_ar.class);
                    startActivity(intent);
                }
            }
        });
        clooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {

                    Intent intentt = new Intent(level3menu.this, clothes_ang.class);
                    startActivity(intentt);

                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(level3menu.this, clothes_fr.class);
                    startActivity(intent);
                } else if (language.equals("Ar")) {
                    Intent intent = new Intent(level3menu.this, clothes_ar.class);
                    startActivity(intent);
                }
            }
        });
    }




}
