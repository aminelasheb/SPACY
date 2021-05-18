package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CSQ extends AppCompatActivity {
    private CardView card21;
    private CardView card22;
    private String language;
    private TextView QZ, CL, SH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        language = intent.getStringExtra("language");

        setContentView(R.layout.activity_c_s_q);
        QZ = findViewById(R.id.quizz2);
        CL = findViewById(R.id.color);
        SH = findViewById(R.id.shape);

        if (language.equals("Fr")) {
            QZ.setText("QUIZ");
            CL.setText("Couleurs");
            SH.setText("Formes");

        } else if (language.equals("Ar")) {
            QZ.setText("اختبار");
            CL.setText("الألوان");
            SH.setText("الأشكال");
        }


        CardView SCQUIZ = findViewById(R.id.card23);

        card21 = findViewById(R.id.card21);
        card22 = findViewById(R.id.card22);

        card21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(CSQ.this, ColorsAn.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(CSQ.this, ColorsFr.class);
                    startActivity(intent);
                } else if (language.equals("Ar")) {
                    Intent intent = new Intent(CSQ.this, ColorsAr.class);
                    startActivity(intent);
                }
            }
        });

        card22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("An")) {
                    Intent intent = new Intent(CSQ.this, ShapesAng.class);
                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(CSQ.this, ShapesFr.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(CSQ.this, ShapesAr.class);
                    startActivity(intent);
                }
            }

        });

        SCQUIZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (language.equals("An")) {
                    Intent intent = new Intent(CSQ.this, SCQUIZAn.class);
                    intent.putExtra("language", language);

                    startActivity(intent);
                } else if (language.equals("Fr")) {
                    Intent intent = new Intent(CSQ.this, CSQUIZFr.class);
                    startActivity(intent);
                }
                if (language.equals("Ar")) {
                    Intent intent = new Intent(CSQ.this, CSQUIZAr.class);
                    startActivity(intent);
                }

            }
        });


    }
}