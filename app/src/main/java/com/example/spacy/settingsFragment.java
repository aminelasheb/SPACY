package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link settingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class settingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Spinner spinner ;
    Spinner spinner2 ;
    TextView txt1 ,txt2 ,txt;
View logOut,Contact ;
 Button change,change2 ;
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
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


        txt1=view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);
        txt = view.findViewById(R.id.txt);






        return view ;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("LangApp", "/");
        languageLearn = sharedPreferences.getString("LangLearn", "/");
        txt.setText(language);
        if (language.equals("العربية")) {

txt1.setGravity(Gravity.RIGHT);
            txt2.setGravity(Gravity.RIGHT);

            txt1.setText("لغة التطبيق : العربية ");

            if (languageLearn.equals("An") ) { txt2.setText("لغة التعلم : الانجليزية");
            }
            else if (languageLearn.equals("Ar") ) {txt2.setText("لغة التعلم : العربية"); }
            else if (languageLearn.equals("Fr") ) {txt2.setText("لغة التعلم : الفرنسية"); } }




            else if (language.equals("Français")) {
            txt1.setGravity(Gravity.LEFT);
            txt2.setGravity(Gravity.LEFT);

            txt1.setText("La langue d'application est : Français ");

            if (languageLearn.equals("An")) {
                txt2.setText("La langue d'apprentissage est : Anglais ");
            } else if (languageLearn.equals("Ar")) {
                txt2.setText("La langue d'apprentissage est : Arabe");
            } else if (languageLearn.equals("Fr")) {
                txt2.setText("La langue d'apprentissage est : Français");
            }
        } else if (language.equals("English")) {
                    txt1.setGravity(Gravity.LEFT);
                    txt2.setGravity(Gravity.LEFT);

                    txt1.setText("App language : English ");

                    if (languageLearn.equals("An") ) { txt2.setText("Learning language is : English");
                    }
                    else if (languageLearn.equals("Ar") ) {txt2.setText("Learning language is : Arabic"); }
                    else if (languageLearn.equals("Fr") ) {txt2.setText("Learning language is : French"); } }
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
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getContext(), "SignOut success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), login.class);
                startActivity(intent);
            }
        });

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

                    txt1.setText("لغة التطبيق : العربية ");

                    if (languageLearn.equals("An") ) { txt2.setText("لغة التعلم : الانجليزية");
                    }
                    else if (languageLearn.equals("Ar") ) {txt2.setText("لغة التعلم : العربية"); }
                    else if (languageLearn.equals("Fr") ) {txt2.setText("لغة التعلم : الفرنسية"); } }

                else if (spinner.getSelectedItem().toString().equals("Français")) {
                    FancyToast.makeText(getContext(),"La langue de l'application a été modifiée avec succès!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                    txt1.setGravity(Gravity.LEFT);
                    txt2.setGravity(Gravity.LEFT);

                    txt1.setText("La langue d'application est : Français ");

                    if (languageLearn.equals("An")) {
                        txt2.setText("La langue d'apprentissage est : Anglais ");
                    } else if (languageLearn.equals("Ar")) {
                        txt2.setText("La langue d'apprentissage est : Arabe");
                    } else if (languageLearn.equals("Fr")) {
                        txt2.setText("La langue d'apprentissage est : Français");
                    }
                } else if (spinner.getSelectedItem().toString().equals("English")){
                    FancyToast.makeText(getContext(),"The language of the app has been changed successfully!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                    txt1.setGravity(Gravity.LEFT);
                    txt2.setGravity(Gravity.LEFT);

                    txt1.setText("App language : English ");

                    if (languageLearn.equals("An") ) { txt2.setText("Learning language is : English");
                    }
                    else if (languageLearn.equals("Ar") ) {txt2.setText("Learning language is : Arabic"); }
                    else if (languageLearn.equals("Fr") ) {txt2.setText("Learning language is : French"); }
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

                        txt2.setText("Learning language is : English");
                    }
                    else if (txt.getText().toString().equals("العربية") ) {                        txt2.setGravity(Gravity.RIGHT);
                        txt2.setText("لغة التعلم : الانجليزية"); }
                    else if (txt.getText().toString().equals("Français") ) {
                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Langue d'apprentissage est : Anglais "); }

                    editor.putString("LangLearn","An");}
                else if (spinner2.getSelectedItem().toString().equals("العربية")) {
                    if (txt.getText().toString().equals("English") ) {
                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Learning language is : Arabic");
                    }
                    else if (txt.getText().toString().equals("العربية") ) {       txt2.setGravity(Gravity.RIGHT);txt2.setText("لغة التعلم : العربية "); }
                    else if (txt.getText().toString().equals("Français") ) {
                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Langue d'apprentissage est : Arabe"); }

                    editor.putString("LangLearn","Ar");}


                else if (spinner2.getSelectedItem().toString().equals("Français")) {
                    if (txt.getText().toString().equals("English") ) {                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Learning language is : French");
                }
                else if (txt.getText().toString().equals("العربية") ) {       txt2.setGravity(Gravity.RIGHT);txt2.setText("لغة التعلم : الفرنسية"); }
                else if (txt.getText().toString().equals("Français") ) {                        txt2.setGravity(Gravity.LEFT);
                        txt2.setText("Langue d'apprentissage est : Français"); }
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





            } }); }}