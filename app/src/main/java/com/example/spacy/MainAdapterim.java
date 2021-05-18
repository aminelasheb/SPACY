package com.example.spacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapterim extends RecyclerView.Adapter<MainAdapterim.ViewHolder> {
    //Initialize variable
    int[] images;
    String[] Names;

    //Create constructure
    public MainAdapterim(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main2, parent, false);
        //Return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set image on image view
        holder.iiimageView.setBackgroundResource(images[position]);
    }

    @Override
    public int getItemCount() {
        //return array list
        return images.length;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize variable
        ImageView iiimageView;
        TextView Namee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variable
            iiimageView = itemView.findViewById(R.id.iiimage_view);
            Namee = itemView.findViewById(R.id.Namee);
        }
    }
}
