package com.example.spacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter2 extends RecyclerView.Adapter<MainAdapter2.ViewHolder> {
    //initialize variable
    int[] images;

    //create constructor
    public MainAdapter2(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        //return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set image on image view
        holder.imageView.setBackgroundResource(images[position]);

    }

    @Override
    public int getItemCount() {
        //return array length
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initialize variable

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            imageView = itemView.findViewById(R.id.image_view);

        }
    }
}

