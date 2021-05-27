package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ANQ extends AppCompatActivity {
    private RelativeLayout card5;
    private RelativeLayout card6;
    private ImageView quiz;
    private String language;
    private String languageLearn;
   private HorizontalScrollView hsv;
    private TextView QZ, NM, ALPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");


        setContentView(R.layout.anq);
//        QZ = findViewById(R.id.quizz);
//        NM = findViewById(R.id.num);
//        ALPH = findViewById(R.id.alpha);
//        if (language.equals("Français")) {
//            QZ.setText("QUIZ");
//            NM.setText("Nombres");
//            ALPH.setText("Alphabets");
//
//        } else if (language.equals("العربية")) {
//            QZ.setText("اختبار");
//            NM.setText("الأرقام");
//            ALPH.setText("الحروف");
//        } else if (language.equals("English")) {
//            QZ.setText("QUIZ");
//            NM.setText("Numbers");
//            ALPH.setText("Alphabets");
//        }




//        CardView numbers = findViewById(R.id.card4);
        quiz=findViewById(R.id.poo);
        card6 = findViewById(R.id.card6);
        card5 = findViewById(R.id.card5);

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(ANQ.this,Quiz.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(ANQ.this, quizFr.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(ANQ.this, quizAr.class);
                    startActivity(intent);
                }
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(ANQ.this, AlphabetAng.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(ANQ.this, AlphabitFr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(ANQ.this, alphabitArab.class);
                    startActivity(intent);
                }
            }

        });
//
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(ANQ.this, NumAn.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(ANQ.this, NumbersFr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(ANQ.this, NumAr.class);
                    startActivity(intent);
                }

            }
        });



    }
}


