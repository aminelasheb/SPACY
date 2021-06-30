package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class AFA extends AppCompatActivity {

    private View Ang;
    private View Fr;
    private View Ar;
    private  String language;


    SharedPreferences MyPre;
    String New ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.afa);
        MyPre = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString("newwww","yy").equals("no")) {

            if(getResources().getConfiguration().locale.getDefault().getDisplayLanguage().equals("English")) {


            language = "English";
            New = "no";


        }
        else if(getResources().getConfiguration().locale.getDefault().getDisplayLanguage().equals("français")){
            language =  "Français";
            New = "no";

        }
        else {  Toast toast = Toast.makeText(AFA.this ,"you can change language of application from settings",FancyToast.LENGTH_LONG);
            toast.show();

        }

            SharedPreferences.Editor editor = MyPre.edit();
            editor.putString("LangApp", language);
            editor.putString("newwww",New)      ;
            editor.commit(); }

        String act = sharedPreferences.getString("acct", "/");
        String gm = sharedPreferences.getString("GM", "/");
        SharedPreferences.Editor editor = MyPre.edit();

        if (gm.equals("MAIL")) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    editor.putString("image", snapshot.child("image").getValue().toString());
                    editor.commit();


                }

                @Override

                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            }); }

        Ang = findViewById(R.id.ang);
        Ang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn", "An");
                if (gm.equals("LATER")) { editor.putString("Anglais", "true") ; }
                if (gm.equals("MAIL") || gm.equals("GOOGLE")) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("Anglais", "true");
                map.put("new", "false");
                editor.putString("image", "1");


                if (gm.equals("MAIL")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    reference.updateChildren(map);

                } else if (gm.equals("GOOGLE")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(act);
                    reference.updateChildren(map);
                } }


                editor.commit();
                startActivity(intent);
                finish();
            }
        });

        Ar =

                findViewById(R.id.ar);
        Ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn", "Ar");

                if (gm.equals("LATER")) { editor.putString("العربية", "true") ; }

                if (gm.equals("MAIL") || gm.equals("GOOGLE")) {

                    HashMap<String, Object> map = new HashMap<>();
                map.put("Arabe", "true");
                map.put("new", "false");
                map.put("image", "1");
                editor.putString("image", "1");

                if (gm.equals("MAIL")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    reference.updateChildren(map);

                } else if (gm.equals("GOOGLE")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(act);
                    reference.updateChildren(map);
                } }
                editor.commit();
                startActivity(intent);
                finish();
            }
        });

        Fr =

                findViewById(R.id.fr);
        Fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this, levels.class);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangLearn", "Fr");

                if (gm.equals("LATER")) { editor.putString("Français", "true") ; }

                if (gm.equals("MAIL") || gm.equals("GOOGLE")) {



                    HashMap<String, Object> map = new HashMap<>();
                map.put("Français", "true");
                map.put("new", "false");
                map.put("image", "1");
                editor.putString("image", "1");


                if (gm.equals("MAIL")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    reference.updateChildren(map);

                } else if (gm.equals("GOOGLE")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(act);
                    reference.updateChildren(map);
                } }
                editor.commit();
                startActivity(intent);
                finish();
            }
        });

    }

}