package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.intellij.lang.annotations.Language;

public class login extends AppCompatActivity {


private CardView sign;
    private CardView sign2;
    ImageView later ;
    SharedPreferences MyPre;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        if (this.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getString("GM","/").equals("GOOGLE")) {
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
            updateUI(account);
        }
        else if ((this.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getString("GM","/").equals("MAIL")))
        {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateeUI(currentUser);

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        TextView laterr = findViewById(R.id.textview88) ;
        TextView welc = findViewById(R.id.welcome);
        TextView mm = findViewById(R.id.mm) ;
        TextView signn = findViewById(R.id.signin) ;
        TextView signupp = findViewById(R.id.signupp) ;


        String Language =this.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getString("LangApp","/");
        if (Language.equals("العربية")) {
            if (welc.getGravity()!= Gravity.RIGHT) { welc.setGravity(Gravity.RIGHT); }
            if (mm.getGravity()!=Gravity.RIGHT) { mm.setGravity(Gravity.RIGHT); }


            laterr.setText("لاحقا");
            welc.setText("مرحبا");
            mm.setText("إذا كان لديك حساب بالفعل ، فقم بتسجيل الدخول إذا لم تقم بإنشاء حساب عن طريق التسجيل.");
            signn.setText("تسجيل الدخول");
            signupp.setText("تسجيل حساب");


        }
        else  if (Language.equals("Français")) {

            if (welc.getGravity()!= Gravity.LEFT) { welc.setGravity(Gravity.LEFT); }
            if (mm.getGravity()!=Gravity.LEFT) { mm.setGravity(Gravity.LEFT); }


            laterr.setText("Après");
            welc.setText("Bienvenue");
            mm.setText("Si vous avez déjà un compte, connectez-vous si vous n'en avez pas créé en vous inscrivant.");
            signn.setText("Se connecter");
            signupp.setText("S'inscrire");
        }
        else {

            if (welc.getGravity()!= Gravity.LEFT) { welc.setGravity(Gravity.LEFT); }
            if (mm.getGravity()!=Gravity.LEFT) { mm.setGravity(Gravity.LEFT); }


            laterr.setText("LATER");
            welc.setText("Welcome");
            mm.setText("If you already have an account, sign in if you haven't created one by registering.");
            signn.setText("Sign in");
            signupp.setText("Sign up");
        }

        sign=findViewById(R.id.sign);
        sign2=findViewById(R.id.signup);
        later=findViewById(R.id.later);
        sign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signin.class);
                startActivity(intent);
        }
        });
        sign2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });
        later.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences MyPre = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("GM", "LATER");
                editor.putString("NEW","false");

                editor.commit();
                Intent intent = new Intent(login.this, AFA.class);
                startActivity(intent);
            }
        });

    }

    public void updateUI(GoogleSignInAccount account){

        if(account != null ) {
            Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,levels.class));

        }else {
        }

    }

    public void updateeUI(FirebaseUser account){

        if(account != null ) {
            Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,levels.class));

        }else {
        }

    }
}