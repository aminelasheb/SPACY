package com.example.spacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.HashMap;

public class signin extends AppCompatActivity  {

    private TextInputEditText email;
    private TextInputEditText email2,password2;
    private TextInputLayout email3,password3;
    private EditText password;
    private static final int RC_SIGN_IN = 9001;
    private Button login;
    GoogleSignInClient mGoogleSignInClient ;
    private FirebaseAuth mAuth;
    String neww ;
    SharedPreferences MyPre;

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
        setContentView(R.layout.activity_signin);
        login = findViewById(R.id.sign3);
        password=findViewById(R.id.myedit2);
        email=findViewById(R.id.myedit);
        TextView sign2 = findViewById(R.id.sig2) ;
        TextView sign = findViewById(R.id.sig) ;
        TextView orr = findViewById(R.id.or) ;



        String Language =this.getSharedPreferences("MyPref", Context.MODE_PRIVATE).getString("LangApp","/");
        if (Language.equals("العربية")) {
            if (sign.getGravity()!=Gravity.RIGHT) { sign.setGravity(Gravity.RIGHT); }
            if (password.getGravity()!=Gravity.RIGHT) { password.setGravity(Gravity.RIGHT); }
            if (email.getGravity()!=Gravity.RIGHT) { email.setGravity(Gravity.RIGHT); }
            if (sign2.getGravity()!=Gravity.RIGHT) { sign2.setGravity(Gravity.RIGHT); }

            sign.setText("تسجيل الدخول");
            sign2.setText("املأ المعلومات أدناه أو استمر في استخدام أحد حساباتك.");
            login.setText("تسجيل الدخول");
            orr.setText("  أو  ");


            email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        email3.setHint("البريد الإلكتروني");
                    }
                    else {
                        email3.setHint("أدخل البريد الإلكتروني");
                    }
                }
            });

            password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        password3.setHint("كلمة المرور");
                    }
                    else {
                        password3.setHint("أدخل كلمة المرور");
                    }
                }
            });

        }

        else  if (Language.equals("Français")) {
            if (sign.getGravity()!=Gravity.LEFT) { sign.setGravity(Gravity.LEFT); }
            if (password.getGravity()!=Gravity.LEFT) { password.setGravity(Gravity.LEFT); }
            if (email.getGravity()!=Gravity.LEFT) { email.setGravity(Gravity.LEFT); }
            if (sign2.getGravity()!=Gravity.LEFT) { sign2.setGravity(Gravity.LEFT); }

            sign.setText("Se connecter");
            sign2.setText("Remplissez les informations ci-dessous ou continuez à utiliser l'un de vos comptes.");
            login.setText("Se connecter");
            orr.setText(" Où ");


            email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        email3.setHint("E-mail");
                    }
                    else {
                        email3.setHint("Entrez l'e-mail");
                    }
                }
            });

            password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        password3.setHint("Mot de passe");
                    }
                    else {
                        password3.setHint("Entrer le mot de passe");
                    }
                }
            });


        }
        else {

            if (sign.getGravity()!=Gravity.LEFT) { sign.setGravity(Gravity.LEFT); }
            if (password.getGravity()!=Gravity.LEFT) { password.setGravity(Gravity.LEFT); }
            if (email.getGravity()!=Gravity.LEFT) { email.setGravity(Gravity.LEFT); }
            if (sign2.getGravity()!=Gravity.LEFT) { sign2.setGravity(Gravity.LEFT); }

            sign.setText("Log in");
            sign2.setText("Complete the information below or continue to use one of your accounts.");
            login.setText("Log in");
            orr.setText(" Or ");


            email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        email3.setHint("E-mail");
                    }
                    else {
                        email3.setHint("Enter e-mail");
                    }
                }
            });

            password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        password3.setHint("Password");
                    }
                    else {
                        password3.setHint("Enter password");
                    }
                }
            });

        }



            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        ImageView Google = findViewById(R.id.google);
        Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn() ;
            }
        });

        email3=findViewById(R.id.emaillayout);

        password3=findViewById(R.id.passwordlayout);


        mAuth = FirebaseAuth.getInstance();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(signin.this, "Empty Credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(txt_email , txt_password);

                }
            }
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task,result);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask,GoogleSignInResult result) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("GM","GOOGLE") ;

            GoogleSignInAccount acct = result.getSignInAccount();
            editor.putString("acct",acct.getId()) ;
            HashMap<String , Object> map = new HashMap<>();

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(acct.getId());
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                    if (!(snapshot.hasChild("new"))) {
                        map.put("Anglais","-1") ;
                        map.put("Français","-1") ;
                        map.put("العربية","-1") ;


                        FirebaseDatabase.getInstance().getReference().child("INFO").child(acct.getId()).setValue(map) ;

                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            editor.putString("Name",acct.getDisplayName()) ;
            editor.putString("email",acct.getEmail()) ;

            try {
                String PhotoUrl = acct.getPhotoUrl().toString();
                editor.putString("Image",PhotoUrl) ;

            } catch (Exception e) {

            }
            editor.commit();

//             Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("SignInActivity", "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
    }

    private void loginUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                  Toast.makeText(signin.this, "LogIn Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString("GM","MAIL") ;
                    editor.commit();

                    Intent intent = new Intent(signin.this , AFA.class);
                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 startActivity(intent);
                 finish();
             }
          }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               Toast.makeText(signin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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


    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }


}
