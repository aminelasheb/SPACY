package com.example.spacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter3 extends RecyclerView.Adapter<MainAdapter3.ViewHolder> {
    //initialize variable
    int[] images;
    String[] names;

    //create constructor
    public MainAdapter3(int[] images, String[] names) {
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main3, parent, false);
        //return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set image on image view
        holder.imageView.setBackgroundResource(images[position]);
        holder.name.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        //return array length
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initialize variable

        ImageView imageView;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            imageView = itemView.findViewById(R.id.image_view3);
            name = itemView.findViewById(R.id.textView3);
        }
    }
}

