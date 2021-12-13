package com.example.techmarket.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.techmarket.Constants;
import com.example.techmarket.R;
import com.example.techmarket.models.InterestingPhoto;
import com.example.techmarket.ui.AllProductsActivity;
import com.example.techmarket.ui.SavedPhotosActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

////package com.example.techmarket.adapters;
////
////import android.content.Context;
////import android.content.Intent;
////import android.view.View;
////import android.widget.ImageView;
////import android.widget.TextView;
////
////import androidx.recyclerview.widget.RecyclerView;
////
////import com.example.techmarket.Constants;
////import com.example.techmarket.R;
////import com.example.techmarket.models.InterestingPhoto;
////import com.example.techmarket.ui.InterestingPhotosActivity;
////import com.example.techmarket.ui.SavedPhotosActivity;
////import com.google.firebase.database.DataSnapshot;
////import com.google.firebase.database.DatabaseError;
////import com.google.firebase.database.DatabaseReference;
////import com.google.firebase.database.FirebaseDatabase;
////import com.google.firebase.database.ValueEventListener;
////import com.squareup.picasso.Picasso;
////
////import org.parceler.Parcels;
////
////import java.util.ArrayList;
////
////public class FirebasePhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
////    View mView;
////    Context mContext;
////
////    public FirebasePhotoViewHolder(View itemView){
////        super(itemView);
////        mView = itemView;
////        mContext = itemView.getContext();
////        itemView.setOnClickListener(this);
////    }
////    public void bindRestaurant(InterestingPhoto photo){
////        ImageView imgPhoto = mView.findViewById(R.id.imgPhoto);
////        TextView txtPhotoName = mView.findViewById(R.id.txtPhotoName);
////
////        photo = new InterestingPhoto();
////
////
////
////
////        Picasso.get().load(photo.getPhotoURL()).into(imgPhoto);
////
////        txtPhotoName.setText((photo.getTitle()));
////
////    }
////
////    @Override
////    public void onClick(View view) {
////        final ArrayList<InterestingPhoto> photos = new ArrayList<>();
////        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PHOTOS);
////        ref.addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
////                    photos.add(snapshot.getValue(InterestingPhoto.class));
////                }
//////                int itemPosition = getLayoutPosition();
////
////                Intent intent = new Intent(mContext, SavedPhotosActivity.class);
//////                intent.putExtra("position", itemPosition + "");
//////                intent.putExtra("photos", Parcels.wrap(photos));
////
////                mContext.startActivity(intent);
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////
////            }
////        });
////    }
////
////
////
////}
//
//
//package com.example.techmarket.adapters;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.example.techmarket.R;
//        import com.example.techmarket.models.InterestingPhoto;
//        import com.firebase.ui.database.FirebaseRecyclerAdapter;
//        import com.firebase.ui.database.FirebaseRecyclerOptions;
//
//// FirebaseRecyclerAdapter is a class provided by
//// FirebaseUI. it provides functions to bind, adapt and show
//// database contents in a Recycler View
//public class FirebasePhotoViewHolder extends FirebaseRecyclerAdapter<InterestingPhoto, FirebasePhotoViewHolder.PhotosViewholder> {
//
//    public FirebasePhotoViewHolder(
//            @NonNull FirebaseRecyclerOptions<InterestingPhoto> options) {
//        super(options);
//    }
//
//        // Function to bind the view in Card view(here
//    // "person.xml") iwth data in
//    // model class(here "person.class")
//    @Override
//    protected void
//    onBindViewHolder(@NonNull PhotosViewholder holder,
//                     int position, @NonNull InterestingPhoto model)
//    {
//
//        // Add firstname from model class (here
//        // "person.class")to appropriate view in Card
//        // view (here "person.xml")
//      //  holder.firstname.setText(model.getFirstname());
//
//        holder.title.setText(model.getTitle());
//        // Add lastname from model class (here
//        // "person.class")to appropriate view in Card
//        // view (here "person.xml")
//        holder.date.setText(model.getDateTaken());
//
//        // Add age from model class (here
//        // "person.class")to appropriate view in Card
//        // view (here "person.xml")
//      //  holder.age.setText(model.getAge());
//    }
//
//    // Function to tell the class about the Card view (here
//    // "person.xml")in
//    // which the data will be shown
//    @NonNull
//    @Override
//    public PhotosViewholder
//    onCreateViewHolder(@NonNull ViewGroup parent,
//                       int viewType)
//    {
//        View view
//                = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.activity_saved_photos, parent, false);
//        return new FirebasePhotoViewHolder.PhotosViewholder(view);
//    }
//
//    // Sub Class to create references of the views in Crad
//    // view (here "person.xml")
//    class PhotosViewholder
//            extends RecyclerView.ViewHolder {
//        TextView title, date, url;
//        public PhotosViewholder(@NonNull View itemView)
//        {
//            super(itemView);
//
//            title = itemView.findViewById(R.id.title);
//            date = itemView.findViewById(R.id.date);
//            url = itemView.findViewById(R.id.url);
//        }
//    }
//}
//
public class FirebasePhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebasePhotoViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindPhoto(InterestingPhoto photo) {
        ImageView photoImageView = (ImageView) mView.findViewById(R.id.imgPhoto);
        TextView titleTextView = (TextView) mView.findViewById(R.id.title);
        TextView dateTextView = (TextView) mView.findViewById(R.id.date);
        TextView urlTextView = (TextView) mView.findViewById(R.id.url);

       // Picasso.get().load(restaurant.getImageUrl()).into(restaurantImageView);

        titleTextView.setText(photo.getTitle());
        dateTextView.setText(photo.getDateTaken());
        urlTextView.setText(photo.getPhotoURL());
        Picasso.get().load(photo.getPhotoURL()).into(photoImageView);
    }

    @Override
    public void onClick(View view) {
        final ArrayList<InterestingPhoto> photos = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PHOTOS).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    photos.add(snapshot.getValue(InterestingPhoto.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, SavedPhotosActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("photos", Parcels.wrap(photos));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}