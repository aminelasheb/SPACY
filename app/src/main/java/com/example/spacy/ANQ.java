package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ANQ extends AppCompatActivity {
    private CardView card5;
    private CardView card6;
    private String language;
    private TextView QZ, NM, ALPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        language = intent.getStringExtra("language");


        setContentView(R.layout.anq);
        QZ = findViewById(R.id.quizz);
        NM = findViewById(R.id.num);
        ALPH = findViewById(R.id.alpha);

        if (language.equals("Fr")) {
            QZ.setText("QUIZ");
            NM.setText("Nombres");
            ALPH.setText("Alphabets");

        } else if (language.equals("Ar")) {
            QZ.setText("اختبار");
            NM.setText("الأرقام");
            ALPH.setText("الحروف");
        }


        CardView numbers = findViewById(R.id.card4);

        card6 = findViewById(R.id.card6);
        card5 = findViewById(R.id.card5);

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(ANQ.this, Quiz.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(ANQ.this, quizFr.class);
                    startActivity(intent);
                } else if (language.equals("Ar")) {
                    Intent intent = new Intent(ANQ.this, quizAr.class);
                    startActivity(intent);
                }
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(ANQ.this, AlphabetAng.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(ANQ.this, AlphabitFr.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(ANQ.this, alphabitArab.class);
                    startActivity(intent);
                }
            }

        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (language.equals("An")) {
                    Intent intent = new Intent(ANQ.this, NumAn.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(ANQ.this, NumbersFr.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(ANQ.this, NumAr.class);
                    startActivity(intent);
                }

            }
        });


    }
}


