package com.example.spacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class JOFA extends AppCompatActivity {
    private CardView cardf;
    private CardView cardj;
    private String language,languageLearn;
    private TextView QZ, FAM, JB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");


        setContentView(R.layout.activity_level4);
        QZ = findViewById(R.id.quiz3);
        FAM = findViewById(R.id.family);
        JB = findViewById(R.id.jobs);

        if (language.equals("Français")) {
            QZ.setText("QUIZ");
            FAM.setText("Famille");
            JB.setText("Professions");

        } else if (language.equals("العربية")) {
            QZ.setText("اختبار");
            FAM.setText("عائلتي");
            JB.setText("المهن");
       } else if (language.equals("English")) {
        QZ.setText("Quiz");
        FAM.setText("My Family");
        JB.setText("Jobs ");
    }



        CardView JOFA = findViewById(R.id.cardq3);

        cardf = findViewById(R.id.cardf);
        cardj = findViewById(R.id.cardj);

        cardf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(JOFA.this, Famag.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(JOFA.this, Famfr.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(JOFA.this, Famar.class);
                    startActivity(intent);
                }
            }
        });

        cardj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(JOFA.this, Jobsag.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(JOFA.this, Jobsfr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(JOFA.this, Jobsar.class);
                    startActivity(intent);
                }
            }

        });

        JOFA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(JOFA.this, qjobsag.class);
                    intent.putExtra("language", language);

                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(JOFA.this, qjobsfr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(JOFA.this, qjobsfr.class);
                    startActivity(intent);
                }

            }
        });


    }
}
