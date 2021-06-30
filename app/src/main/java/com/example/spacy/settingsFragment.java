package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link settingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class settingsFragment extends Fragment {

    TextInputLayout FullName,UserName,Email;
    TextView fullnamelabel,usernamelabel;

     
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Spinner spinner ;
    Spinner spinner2 ;
    TextView txt1 ,txt2 ,txt,txt3,txt4,txt5,txt6;
View Contact ;
        CardView logOut;
     ImageButton change,change2 ;
    GoogleSignInAccount account ;
    GoogleSignInClient mGoogleSignInClient ;
  String languageLearn ;
    SharedPreferences MyPre ;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public settingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment settingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static settingsFragment newInstance(String param1, String param2) {
        settingsFragment fragment = new settingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //ShowAllData




        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }


    @Override
    public void onStart() {
        super.onStart();
         account = GoogleSignIn.getLastSignedInAccount(getContext());

    }

    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,
                                   Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        // Inflate the layout for this fragment
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        change = view.findViewById(R.id.changee);
        change2 = view.findViewById(R.id.changee2);
        logOut = view.findViewById(R.id.logout);
        Contact = view.findViewById(R.id.contact);

     txt3=view.findViewById(R.id.logoutt);
        txt4=view.findViewById(R.id.contactt);
        txt1=view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);
        txt = view.findViewById(R.id.txt);
txt5=view.findViewById(R.id.shareit);
txt6=view.findViewById(R.id.terms);





        return view ;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("LangApp", "/");
        languageLearn = sharedPreferences.getString("LangLearn", "/");
        String GM = sharedPreferences.getString("GM","/") ;
        txt.setText(language);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);
        if (language.equals("العربية")) {

txt1.setGravity(Gravity.RIGHT);
            txt2.setGravity(Gravity.RIGHT);
            txt3.setGravity(Gravity.RIGHT);
            txt4.setGravity(Gravity.RIGHT);
            txt5.setGravity(Gravity.RIGHT);
            txt6.setGravity(Gravity.RIGHT);
            txt5.setText("مشاركة");
            txt6.setText("شروط الخدمة و السياسة");
            txt5.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.share,0);
            txt3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.logout,0);
            txt1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.language,0);
            txt2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.language,0);
            txt4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.contact,0);


            txt3.setText("تسجيل الخروج");
            txt4.setText("تواصل معنا");


            txt1.setText("لغة التطبيق : العربية ");

            if (languageLearn.equals("An") ) { txt2.setText("لغة التعلم : الانجليزية");
            }
            else if (languageLearn.equals("Ar") ) {txt2.setText("لغة التعلم : العربية"); }
            else if (languageLearn.equals("Fr") ) {txt2.setText("لغة التعلم : الفرنسية"); } }




            else if (language.equals("Français")) {
            txt1.setGravity(Gravity.LEFT);
            txt2.setGravity(Gravity.LEFT);
            txt3.setGravity(Gravity.LEFT);
            txt4.setGravity(Gravity.LEFT);

            txt1.setText("langue d'application : Français ");
            txt3.setText("Se déconnecter");
            txt4.setText("nous contacter");
            txt5.setGravity(Gravity.LEFT);
            txt6.setGravity(Gravity.LEFT);
            txt5.setText("Partager");
            txt6.setText("Conditions d'utilisation et confidentialité");
            txt5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.share,0,0,0);
            txt4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.contact,0,0,0);
            txt3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.logout,0,0,0);
            txt2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);
            txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);


            if (languageLearn.equals("An")) {
                txt2.setText("langue d'apprentissage : Anglais ");
            } else if (languageLearn.equals("Ar")) {
                txt2.setText("langue d'apprentissage : Arabe");
            } else if (languageLearn.equals("Fr")) {
                txt2.setText("langue d'apprentissage : Français");
            }
        } else if (language.equals("English")) {
                    txt1.setGravity(Gravity.LEFT);
                    txt2.setGravity(Gravity.LEFT);
            txt3.setGravity(Gravity.LEFT);
            txt4.setGravity(Gravity.LEFT);
            txt3.setText("Log out");
            txt4.setText("contact us");
            txt5.setText("Share");
            txt6.setText("Terms of Service and Privacy Policy");
            txt5.setGravity(Gravity.LEFT);
            txt6.setGravity(Gravity.LEFT);
            txt5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.share,0,0,0);
            txt4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.contact,0,0,0);
            txt3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.logout,0,0,0);
            txt2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);
            txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);
                    txt1.setText("App language : English ");

                    if (languageLearn.equals("An") ) { txt2.setText("Learning language : English");
                    }
                    else if (languageLearn.equals("Ar") ) {txt2.setText("Learning language : Arabic"); }
                    else if (languageLearn.equals("Fr") ) {txt2.setText("Learning language : French"); } }
// Create an ArrayAdapter using the string arr  ay and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("image","1") ;
                editor.putString("Name","USER") ;
                editor.commit();

                if ( GM.equals("MAIL") ) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getContext(), "SignOut from MAIL success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), login.class);
                    sharedPreferences = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putString("GM","/") ;
                    editor.commit();
                startActivity(intent); }
                else if ( GM.equals("GOOGLE") ) {
                    signOut();

            } } });


        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:ma.lasheb@esi-sba.dz")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "About SPACY app");

                startActivity(intent);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPre=view.getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangApp",spinner.getSelectedItem().toString());
                txt.setText(spinner.getSelectedItem().toString());
                editor.commit();
                if (spinner.getSelectedItem().toString().equals("العربية")) {

                    FancyToast.makeText(getContext(),"تم تغيير لغة التطبيق بنجاح!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                    txt1.setGravity(Gravity.RIGHT);
                    txt2.setGravity(Gravity.RIGHT);
                    txt3.setGravity(Gravity.RIGHT);
                    txt4.setGravity(Gravity.RIGHT);
                    txt5.setGravity(Gravity.RIGHT);
                    txt6.setGravity(Gravity.RIGHT);
                    txt5.setText("مشاركة");
                    txt6.setText("شروط الخدمة و السياسة");
                    txt5.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.share,0);
                    txt4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.contact,0);
                    txt3.setText("تسجيل الخروج");
                    txt3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.logout,0);
                    txt2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.language,0);
                    txt4.setText("تواصل معنا");
                    txt1.setText("لغة التطبيق : العربية ");
                    txt1.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.language,0);

                    if (languageLearn.equals("An") ) { txt2.setText("لغة التعلم : الانجليزية");
                    }
                    else if (languageLearn.equals("Ar") ) {txt2.setText("لغة التعلم : العربية"); }
                    else if (languageLearn.equals("Fr") ) {txt2.setText("لغة التعلم : الفرنسية"); } }

                else if (spinner.getSelectedItem().toString().equals("Français")) {
                    FancyToast.makeText(getContext(),"La langue de l'application a été modifiée avec succès!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                    txt5.setGravity(Gravity.LEFT);
                    txt6.setGravity(Gravity.LEFT);
                    txt5.setText("Partager");
                    txt6.setText("Conditions d'utilisation et confidentialité");
                    txt5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.share,0,0,0);
                    txt1.setGravity(Gravity.LEFT);
                    txt2.setGravity(Gravity.LEFT);
                    txt3.setGravity(Gravity.LEFT);
                    txt4.setGravity(Gravity.LEFT);
                    txt4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.contact,0,0,0);
                    txt3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.logout,0,0,0);
                    txt2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);
                    txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);
                    txt3.setText("Se déconnecter");
                    txt4.setText("nous contacter");
                    txt1.setText("langue d'application : Français ");

                    if (languageLearn.equals("An")) {
                        txt2.setText("langue d'apprentissage : Anglais");
                    } else if (languageLearn.equals("Ar")) {
                        txt2.setText("langue d'apprentissage : Arabe");
                    } else if (languageLearn.equals("Fr")) {
                        txt2.setText("langue d'apprentissage : Français");
                    }
                } else if (spinner.getSelectedItem().toString().equals("English")){
                    FancyToast.makeText(getContext(),"The language of the app has been changed successfully!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                    txt5.setText("Share");
                    txt6.setText("Terms of Service and Privacy Policy");
                    txt5.setGravity(Gravity.LEFT);
                    txt6.setGravity(Gravity.LEFT);
                    txt5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.share,0,0,0);
                    txt1.setGravity(Gravity.LEFT);
                    txt2.setGravity(Gravity.LEFT);
                    txt3.setGravity(Gravity.LEFT);
                    txt4.setGravity(Gravity.LEFT);
                    txt3.setText("Log out");
                    txt4.setText("contact us");
                    txt4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.contact,0,0,0);
                    txt3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.logout,0,0,0);
                    txt2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);
                    txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.language,0,0,0);
                    txt1.setText("App language : English ");

                    if (languageLearn.equals("An") ) { txt2.setText("Learning language : English");
                    }
                    else if (languageLearn.equals("Ar") ) {txt2.setText("Learning language : Arabic"); }
                    else if (languageLearn.equals("Fr") ) {txt2.setText("Learning language : French"); }
                }
            }
        });

        change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPre=view.getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = MyPre.edit();
                if (spinner2.getSelectedItem().toString().equals("English")) {
                    if (txt.getText().toString().equals("English") ) {
                        txt2.setGravity(Gravity.LEFT);

                        txt2.setText("Learning language : English");
                    }
                    else if (txt.getText().toString().equals("العربية") ) {                        txt2.setGravity(Gravity.RIGHT);
                        txt2.setText("لغة التعلم : الانجليزية"); }
                    else if (txt.getText().toString().equals("Français") ) {
                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Langue d'apprentissage : Anglais "); }

                    editor.putString("LangLearn","An");}
                else if (spinner2.getSelectedItem().toString().equals("العربية")) {
                    if (txt.getText().toString().equals("English") ) {
                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Learning language : Arabic");
                    }
                    else if (txt.getText().toString().equals("العربية") ) {       txt2.setGravity(Gravity.RIGHT);txt2.setText("لغة التعلم : العربية "); }
                    else if (txt.getText().toString().equals("Français") ) {
                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Langue d'apprentissage : Arabe"); }

                    editor.putString("LangLearn","Ar");}


                else if (spinner2.getSelectedItem().toString().equals("Français")) {
                    if (txt.getText().toString().equals("English") ) {                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Learning language : French");
                }
                else if (txt.getText().toString().equals("العربية") ) {       txt2.setGravity(Gravity.RIGHT);txt2.setText("لغة التعلم : الفرنسية"); }
                else if (txt.getText().toString().equals("Français") ) {                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Langue d'apprentissage : Français"); }
                editor.putString("LangLearn","Fr");}

                editor.commit();
                FancyToast.makeText(getContext(),"Language of learning changed successfully!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                if (txt.getText().toString().equals("العربية") ) {
                    FancyToast.makeText(getContext(),"تم تغيير لغة التعلم بنجاح!",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();

                } else if (txt.getText().toString().equals("Français") ) {
                    FancyToast.makeText(getContext(),"La langue d'apprentissage a été modifiée avec succès!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                } else if (txt.getText().toString().equals("English")){
                    FancyToast.makeText(getContext(),"Language of learning changed successfully!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                }





            } }) ; }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(), "SignOut from GOOGLE success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), login.class);
                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("GM","/") ;
                        editor.commit();
                        startActivity(intent);
                    }
                });
    }}

