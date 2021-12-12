package com.example.techmarket.adapters;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class FirebasePhotoViewHolder extends RecyclerView.ViewHolder{
    View mView;
    Context mContext;

    public FirebasePhotoViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

}
