package com.example.spacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class adapterRecycler extends RecyclerView.Adapter<adapterRecycler.adapterViewHolder>{
   private ArrayList<itemrecycler> mitemlist;
   private OnitemListener mOnitemlistener;
    public static class adapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView mImageView;
        public TextView mTextView1;
        OnitemListener onitemListener;
        public adapterViewHolder(View itemView,OnitemListener onitemListener) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView);
            mTextView1=itemView.findViewById(R.id.textView);
            this.onitemListener=onitemListener;
        itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onitemListener.onItemClick((getAdapterPosition()));
        }
    }
    public adapterRecycler(ArrayList<itemrecycler> itemlist ,OnitemListener onitemListener){
        mitemlist=itemlist;
        mOnitemlistener=onitemListener;
    }


    @Override
    public adapterViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycle,parent,false);
        adapterViewHolder avh=new adapterViewHolder(v,mOnitemlistener);
        return avh;
    }

    @Override
    public void onBindViewHolder( adapterViewHolder holder, int position) {
        itemrecycler cuurentitem=mitemlist.get(position);

        holder.mImageView.setImageResource(cuurentitem.getmImageRessource());
        holder.mTextView1.setText(cuurentitem.getMtext1());
    }

    @Override
    public int getItemCount() {
        return mitemlist.size();
    }
    public interface OnitemListener{
        void onItemClick(int position);
    }
}
