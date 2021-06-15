package com.example.spacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adaptervp extends PagerAdapter {
    private Context context;
    private ArrayList<aymenmodel> aymenmodelArrayList;

    public adaptervp(Context context, ArrayList<aymenmodel> aymenmodelArrayList) {
        this.context = context;
        this.aymenmodelArrayList = aymenmodelArrayList;
    }



    @Override
    public int getCount() {
        return aymenmodelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_main3,container,false);

        ImageView tryimg=view.findViewById(R.id.image_view3);
        TextView trytxt=view.findViewById(R.id.textView3);

        aymenmodel aymenmodel=aymenmodelArrayList.get(position);
        String title=aymenmodel.getTitel();
        int image=aymenmodel.getImage();

        tryimg.setImageResource(image);
        trytxt.setText(title);

container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull @NotNull Object object) {
 container.removeView((View)object);
    }
}
