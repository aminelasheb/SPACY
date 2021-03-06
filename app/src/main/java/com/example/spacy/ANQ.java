package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ANQ extends AppCompatActivity {
    private RelativeLayout card5;
    private ImageView card6;
    private String language;
    private String languageLearn;

    private TextView QZ, NM, ALPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");
        Intent intent = getIntent();
        String lang=intent.getStringExtra("Lang");
        String level=intent.getStringExtra("Level");

        setContentView(R.layout.anq);
        TextView Lang=findViewById(R.id.alphaa) ;
        Lang.setText(lang);
        QZ = findViewById(R.id.quizz);
        NM = findViewById(R.id.num);
        ALPH = findViewById(R.id.alpha);

        if (language.equals("Français")) {
            QZ.setText("QUIZ");
            NM.setText("Nombres");
            ALPH.setText("Alphabets");

        } else if (language.equals("العربية")) {
            QZ.setText("اختبار");
            NM.setText("الأرقام");
            ALPH.setText("الحروف");
        } else if (language.equals("English")) {
            QZ.setText("QUIZ");
            NM.setText("Numbers");
            ALPH.setText("Alphabets");
        }




        RelativeLayout numbers = findViewById(R.id.card4);

        card6 = findViewById(R.id.card6);
        card5 = findViewById(R.id.card5);

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(ANQ.this, Quiz.class);

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
                if (language.equals("English")||language.equals("Français") ) {
                    Intent intent = new Intent(ANQ.this, Learn.class);
                    intent.putExtra("Level",level);

                    startActivity(intent);
                }
                if (language.equals("العربية")) {
                    Intent intent = new Intent(ANQ.this, LearnAr.class);
                    intent.putExtra("Level",level);

                    startActivity(intent);
                }
            }

        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (language.equals("English")||language.equals("Français") ) {
                    Intent intent = new Intent(ANQ.this, Learn.class);
                    intent.putExtra("Level","1/2");

                    startActivity(intent);
                }
                if (language.equals("العربية")) {
                    Intent intent = new Intent(ANQ.this, LearnAr.class);
                    intent.putExtra("Level","1/2");

                    startActivity(intent);
                }

            }
        });


    }
}


