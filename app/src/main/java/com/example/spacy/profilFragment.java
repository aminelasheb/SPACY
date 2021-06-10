package com.example.spacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class profilFragment extends Fragment {
    RecyclerView recyclerView;
    ImageView profile ;
    TextView name ;
    String GM ,Name ,IM ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profil, container, false) ;
        profile = view.findViewById(R.id.profile_image) ;
        name =view.findViewById(R.id.Name) ;
        return view ;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String GM = sharedPreferences.getString("GM","/") ;
        String Name = sharedPreferences.getString("Name","/") ;
        String IM = sharedPreferences.getString("Image","/") ;

        if (GM.equals("GOOGLE")) {
name.setText(Name);
            try {
                Picasso.with(getContext()).load(IM).into(profile);
            } catch (Exception e) {

            }
        }

    }
}