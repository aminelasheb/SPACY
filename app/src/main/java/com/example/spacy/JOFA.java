package com.example.spacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class JOFA extends AppCompatActivity {
    private CardView cardf;
    private CardView cardj;
    private String language;
    private TextView QZ, FAM, JB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        language = intent.getStringExtra("language");

        setContentView(R.layout.activity_level4);
        QZ = findViewById(R.id.quiz3);
        FAM = findViewById(R.id.family);
        JB = findViewById(R.id.jobs);

        if (language.equals("Fr")) {
            QZ.setText("QUIZ");
            FAM.setText("Famille");
            JB.setText("Professions");

        } else if (language.equals("Ar")) {
            QZ.setText("اختبار");
            FAM.setText("عائلتي");
            JB.setText("المهن");
        }


        CardView JOFA = findViewById(R.id.cardq3);

        cardf = findViewById(R.id.cardf);
        cardj = findViewById(R.id.cardj);

        cardf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(JOFA.this, Famag.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(JOFA.this, Famfr.class);
                    startActivity(intent);
                } else if (language.equals("Ar")) {
                    Intent intent = new Intent(JOFA.this, Famar.class);
                    startActivity(intent);
                }
            }
        });

        cardj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(JOFA.this, Jobsag.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(JOFA.this, Jobsfr.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(JOFA.this, Jobsar.class);
                    startActivity(intent);
                }
            }

        });

        JOFA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (language.equals("An")) {
                    Intent intent = new Intent(JOFA.this, qjobsag.class);
                    intent.putExtra("language", language);

                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(JOFA.this, qjobsfr.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(JOFA.this, qjobsfr.class);
                    startActivity(intent);
                }

            }
        });


    }
}
