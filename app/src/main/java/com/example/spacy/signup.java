package com.example.spacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signup extends AppCompatActivity {
    private TextInputLayout user,emaill,pasword;
    private TextInputEditText useredt,emailedt,passwordedt;
    private EditText username;
    private EditText email;
    private EditText password;
    private Button register;
    private TextView loginUser;

    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user=findViewById(R.id.username);
        useredt=findViewById(R.id.ediusername);
        emaill=findViewById(R.id.emaillayout2);
        emailedt=findViewById(R.id.editemaillayout2);
        pasword=findViewById(R.id.password2);
        passwordedt=findViewById(R.id.editpasswor);
        useredt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    user.setHint(" Username");
                }
                else {
                    user.setHint("Enter Username");
                }
            }
        });
        emailedt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    emaill.setHint(" Email");
                }
                else {
                    emaill.setHint("Enter Email");
                }
            }
        });
        passwordedt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    pasword.setHint(" Password");
                }
                else {
                    pasword.setHint("Enter Password");
                }
            }
        });

       username = findViewById(R.id.ediusername);
       email = findViewById(R.id.editemaillayout2);
        password = findViewById(R.id.editpasswor);
        register = findViewById(R.id.sign3);
       mRootRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        pd = new ProgressDialog(this);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUsername = username.getText().toString();
                String txtEmail = email.getText().toString();
                String txtPassword = password.getText().toString();

                if (TextUtils.isEmpty(txtUsername)
                        || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(signup.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 6){
                    Toast.makeText(signup.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txtUsername  , txtEmail , txtPassword);
                }
            }
        });
    }
    private void registerUser(final String username, final String email, String password) {

        pd.setMessage("Please Wait!");
        pd.show();

     mAuth.createUserWithEmailAndPassword(email , password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
        @Override
        public void onSuccess(AuthResult authResult) {
            pd.setMessage("Uploading info!");
            HashMap<String , Object> map = new HashMap<>();
            map.put("email", email);
            map.put("username" , username);
            map.put("Anglais","-1") ;
            map.put("Français","-1") ;
            map.put("العربية","-1") ;
            map.put("image","1") ;
            pd.setMessage("Info uploaded!");
            FirebaseDatabase.getInstance().getReference().child("INFO").child(mAuth.getCurrentUser().getUid()).updateChildren(map) ;
            pd.dismiss();
            SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("GM","MAIL") ;
            editor.putString("Name",username) ;
            editor.commit();
            Toast.makeText(signup.this, "SignIn success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(signup.this , AFA.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }
    });

}



}
