package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AFA extends AppCompatActivity {

    private View Ang;
    private View Fr;
    private View Ar;


    SharedPreferences MyPre ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afa);
        MyPre=getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("LangApp", "English");
        SharedPreferences.Editor editor = MyPre.edit();
        editor.putString("LangApp",language);
        editor.commit();

        Ang = findViewById(R.id.ang);
        Ang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn","An");
                editor.commit();
                startActivity(intent);
                finish();
            }
        });

        Ar = findViewById(R.id.ar);
        Ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn","Ar");
                editor.commit();
                startActivity(intent);
                finish();
            }
        });

        Fr = findViewById(R.id.fr);
        Fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn","Fr");
                editor.commit();
                startActivity(intent);
                finish();
            }
        });

    }

}