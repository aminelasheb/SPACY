package com.example.spacy;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

public class level5menu extends AppCompatActivity {
    private CardView card50;
    private CardView card51;
    private String language;
    private TextView QZ, FRT,VGT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        language = intent.getStringExtra("language");
        setContentView(R.layout.activity_level5menu);

        QZ = findViewById(R.id.quiz55);
        FRT = findViewById(R.id.FRT1);
        VGT = findViewById(R.id.VGT1);

        if (language.equals("Fr")) {
            QZ.setText("QUIZ");
            FRT.setText("Fruits");
            VGT.setText("Légumes");

        } else if (language.equals("Ar")) {
            QZ.setText("اختبار");
            FRT.setText("الفواكه");
            VGT.setText("الخضر");
        }


        CardView Quiiiz = findViewById(R.id.card52);
        card50 = findViewById(R.id.card50);
        card51 = findViewById(R.id.card51);

        card51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {

                    Intent intentt = new Intent(level5menu.this, Vegetable.class);
                    startActivity(intentt);

                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(level5menu.this,Legumesfr.class);
                    startActivity(intent);
                } else if (language.equals("Ar")) {
                    Intent intent = new Intent(level5menu.this, LegumesAr.class);
                    startActivity(intent);
                }
            }
        });

        card50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(level5menu.this, FruitsAN.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(level5menu.this, FruitsFR.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(level5menu.this, FruitsAR.class);
                    startActivity(intent);
                }
            }
        });
        Quiiiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (language.equals("An")) {
                    Intent intent = new Intent(level5menu.this, Quiz5AN.class);
                    intent.putExtra("language", language);

                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(level5menu.this, Quiz5FR.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(level5menu.this, Quiz5AR.class);
                    startActivity(intent);
                }

            }
        });
    }




}
