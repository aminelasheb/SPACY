package com.example.spacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    TextView txt,txt1,txt3 ,txt2,txt4,txt5;
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
        txt = view.findViewById(R.id.textView);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        change = view.findViewById(R.id.changee);
        change2 = view.findViewById(R.id.changee2);

        txt1=view.findViewById(R.id.txt1);
        txt3=view.findViewById(R.id.txt3);
        txt2 = view.findViewById(R.id.textView2);
        txt4 = view.findViewById(R.id.txt4);
        txt5 = view.findViewById(R.id.txt5);






        return view ;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("LangApp", "/");
        languageLearn = sharedPreferences.getString("LangLearn", "/");
        txt2.setText(languageLearn);
        if (language.equals("العربية")) {

            txt.setText("العربية ");
            txt1.setText("لغة التطبيق");
            txt3.setText("تغيير اللغة");

        } else if (language.equals("Français")) {
            txt.setText("Français");
            txt1.setText("Langue d'application");
            txt3.setText("Changer la langue :");

        } else {
            txt.setText("English");
            txt1.setText("App language is : ");
            txt3.setText("Change language :");

        }
// Create an ArrayAdapter using the string arr  ay and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        String name = sharedPreferences.getString("LangApp","/");
        txt.setText(name);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPre=view.getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = MyPre.edit();
                editor.putString("LangApp",spinner.getSelectedItem().toString());
                editor.commit();
                txt.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START) ;
                txt.setText(sharedPreferences.getString("LangApp","/"));
                if (txt.getText().toString().equals("العربية")) {
                    FancyToast.makeText(getContext(),"تم تغيير لغة التطبيق بنجاح!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                    txt1.setText("لغة التطبيق");
                    txt3.setText("تغيير اللغة");
                    txt2.setText(sharedPreferences.getString("LangLearn","/"));
                    txt4.setText("لغة التعلم");
                    txt5.setText("تغيير اللغة");

                } else if (txt.getText().toString().equals("Français")) {
                    FancyToast.makeText(getContext(),"La langue de l'application a été modifiée avec succès!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                    txt1.setText("Langue d'application est : ");
                    txt3.setText("Changer la langue :");
                    txt2.setText(sharedPreferences.getString("LangLearn","/"));
                    txt4.setText("Langue d'apprentissage :");
                    txt5.setText("Changer la langue");
                } else if (txt.getText().toString().equals("English")){
                    FancyToast.makeText(getContext(),"The language of the app has been changed successfully!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                    txt1.setText("App language is : ");
                    txt3.setText("Change language :");
                    txt2.setText(sharedPreferences.getString("LangLearn","/"));
                    txt4.setText("Learn language :");
                    txt5.setText("Changer the language");
                }
            }
        });

        change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt2.setText(spinner2.getSelectedItem().toString());
                MyPre=view.getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = MyPre.edit();
                if (spinner2.getSelectedItem().toString().equals("English")) { editor.putString("LangLearn","An");}
                else if (spinner2.getSelectedItem().toString().equals("العربية")) { editor.putString("LangLearn","Ar");}
                else if (spinner2.getSelectedItem().toString().equals("Français")) { editor.putString("LangLearn","Fr");}

                editor.commit();
                FancyToast.makeText(getContext(),"Language of learning changed successfully!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                if (txt.getText().toString().equals("العربية")) {
                    FancyToast.makeText(getContext(),"تم تغيير لغة التعلم بنجاح!",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();

                } else if (txt.getText().toString().equals("Français")) {
                    FancyToast.makeText(getContext(),"La langue d'apprentissage a été modifiée avec succès!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                } else if (txt.getText().toString().equals("English")){
                    FancyToast.makeText(getContext(),"Language of learning changed successfully!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();

                }





            } }); }}