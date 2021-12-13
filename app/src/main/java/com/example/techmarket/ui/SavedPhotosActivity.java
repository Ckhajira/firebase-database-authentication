//package com.example.techmarket.ui;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//
//import com.example.techmarket.Constants;
//import com.example.techmarket.R;
//import com.example.techmarket.adapters.FirebasePhotoViewHolder;
//import com.example.techmarket.models.InterestingPhoto;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import butterknife.BindView;
//
//public class SavedPhotosActivity extends AppCompatActivity {
//    private DatabaseReference mPhotoReference;
//    private RecyclerView recyclerView;
//    private FirebasePhotoViewHolder adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycler2);
//
//        // Create a instance of the database and get
//        // its reference
//        mPhotoReference = FirebaseDatabase.getInstance().getReference();
//
//        recyclerView = findViewById(R.id.recycler2);
//
//        // To display the Recycler view linearly
//        recyclerView.setLayoutManager(
//                new LinearLayoutManager(this));
//        // It is a class provide by the FirebaseUI to make a
//        // query in the database to fetch appropriate data
//        FirebaseRecyclerOptions<InterestingPhoto> options
//                = new FirebaseRecyclerOptions.Builder<InterestingPhoto>()
//                .setQuery(mPhotoReference, InterestingPhoto.class)
//                .build();
//        // Connecting object of required Adapter class to
//        // the Adapter class itself
//        adapter = new FirebasePhotoViewHolder(options);
//        // Connecting Adapter class with the Recycler view*/
//        recyclerView.setAdapter(adapter);
//    }
//
//    // Function to tell the app to start getting
//    // data from database on starting of the activity
//
//    @Override protected void onStart()
//    {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    // Function to tell the app to stop getting
//    // data from database on stopping of the activity
//    @Override protected void onStop()
//    {
//        super.onStop();
//        adapter.stopListening();
//    }
////    private FirebaseRecyclerAdapter<InterestingPhoto, FirebasePhotoViewHolder> mFirebaseAdapter;
////
////    @BindView(R.id.)
////    RecyclerView m;
////    @BindView(R.id.errorTextView) TextView mErrorTextView;
////    @BindView(R.id.progressBar) ProgressBar mProgressBar;
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_saved_photos);
////    }
//}
package com.example.techmarket.ui;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techmarket.Constants;
import com.example.techmarket.R;
import com.example.techmarket.adapters.FirebasePhotoViewHolder;
import com.example.techmarket.models.InterestingPhoto;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedPhotosActivity extends AppCompatActivity {
    private DatabaseReference mPhotoReference;
    private FirebaseRecyclerAdapter<InterestingPhoto, FirebasePhotoViewHolder> mFirebaseAdapter;

    @BindView(R.id.recycler2)
    RecyclerView mRecyclerView;
//    @BindView(R.id.errorTextView)
//    TextView mErrorTextView;
//    @BindView(R.id.progressBar)
//    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);
        ButterKnife.bind(this);

        mPhotoReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PHOTOS);
        setUpFirebaseAdapter();
//        hideProgressBar();
        showRestaurants();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<InterestingPhoto> options =
                new FirebaseRecyclerOptions.Builder<InterestingPhoto>()
                        .setQuery(mPhotoReference, InterestingPhoto.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<InterestingPhoto, FirebasePhotoViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebasePhotoViewHolder firebaseRestaurantViewHolder, int position, @NonNull InterestingPhoto photo) {
                firebaseRestaurantViewHolder.bindPhoto(photo);
            }

            @NonNull
            @Override
            public FirebasePhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_saved_photos, parent, false);
                return new FirebasePhotoViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }
}