package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageLearning extends AppCompatActivity {

    private View Ang;
    private View Fr;
    private View Ar;
    private TextView LearningLeang;


    SharedPreferences MyPre ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_learning);
        MyPre=getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("LangApp", "/");

        Ang = findViewById(R.id.ang);
        LearningLeang= findViewById(R.id.learnlan) ;
        if (language.equals("العربية")) {
            LearningLeang.setText("لغة التعلم ");

        } else if (language.equals("Français")) {
            LearningLeang.setText("La langue d'apprentissage");

        } else {
            LearningLeang.setText("Learning language");

        }
        Ang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LanguageLearning.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn","An");
                editor.commit();
                startActivity(intent);
            }
        });

        Ar = findViewById(R.id.ar);
        Ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LanguageLearning.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn","Ar");
                editor.commit();
                startActivity(intent);
            }
        });

        Fr = findViewById(R.id.fr);
        Fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LanguageLearning.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn","Fr");
                editor.commit();
                startActivity(intent);
            }
        });

    }

}