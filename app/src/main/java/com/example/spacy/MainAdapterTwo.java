package com.example.spacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapterTwo extends RecyclerView.Adapter<MainAdapterTwo.ViewHolderTwo> {
    ArrayList<MainModelTwo> mainModelTwos;
    Context contexttwo;


    public MainAdapterTwo(Context contexttwo, ArrayList<MainModelTwo> mainModelTwos) {
        this.contexttwo = contexttwo;
        this.mainModelTwos = mainModelTwos;
    }

    @NonNull
    @Override
    public ViewHolderTwo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roww_item, parent, false);
        return new ViewHolderTwo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTwo holder, int position) {
        //Set to image view
        holder.iimageView.setImageResource(mainModelTwos.get(position).getNumengTwo());
        //Set Name to textview
        holder.ttextView.setText(mainModelTwos.get(position).getNumbNameTwo());
    }

    @Override
    public int getItemCount() {
        return mainModelTwos.size();
    }

    public class ViewHolderTwo extends RecyclerView.ViewHolder {
        //Initialize Variable
        ImageView iimageView;
        TextView ttextView;

        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            //Assign Variable
            iimageView = itemView.findViewById(R.id.iimage_view);
            ttextView = itemView.findViewById(R.id.ttext_view);
        }


    }
}