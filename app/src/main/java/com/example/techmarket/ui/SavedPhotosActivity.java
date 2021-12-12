package com.example.techmarket.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.techmarket.R;
import com.example.techmarket.adapters.FirebasePhotoViewHolder;
import com.example.techmarket.models.InterestingPhoto;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;

public class SavedPhotosActivity extends AppCompatActivity {
    private DatabaseReference mPhotoReference;
    private FirebaseRecyclerAdapter<InterestingPhoto, FirebasePhotoViewHolder> mFirebaseAdapter;

    @BindView(R.id.)
    RecyclerView m;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_photos);
    }
}