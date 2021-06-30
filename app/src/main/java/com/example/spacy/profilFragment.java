package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class profilFragment extends Fragment {
    CircleProgress circleProgress;
    RecyclerView recyclerView;
    ImageView profile,plus ;
    TextView name,score ;  final int PICK_IMAGE = 100;
    String GM ,Name ,IM ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profil, container, false) ;
        profile = view.findViewById(R.id.profile_image) ;
        name =view.findViewById(R.id.Name) ;
        plus=view.findViewById(R.id.imageView5) ;
        score=view.findViewById(R.id.score);
        return view ;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String GM = sharedPreferences.getString("GM","/") ;
        String Name = sharedPreferences.getString("Name","/") ;
        String IM = sharedPreferences.getString("Image","/") ;

        if (GM.equals("MAIL")) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO");
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
        name.setText(snapshot.child("username").getValue().toString());
        score.setText(snapshot.child("score").getValue().toString());
    }

    @Override
    public void onCancelled(@NonNull @NotNull DatabaseError error) {

    }
});
        }


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });


        if (GM.equals("GOOGLE")) {
            plus.setAlpha(0f);
name.setText(Name);
            try {
                Picasso.with(getContext()).load(IM).into(profile);
            } catch (Exception e) {

            }
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    score.setText(snapshot.child("score").getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }


    } ) ; }}

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        Uri imageUri;

        if (resultCode == getActivity().RESULT_OK && reqCode == 100){
            imageUri = data.getData();
            profile.setImageURI(imageUri);
            HashMap<String , Object> map = new HashMap<>();
            map.put("image" ,imageUri.toString());
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO");
            reference.updateChildren(map) ;
        }
} }