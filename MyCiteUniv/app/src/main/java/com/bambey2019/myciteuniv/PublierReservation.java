package com.bambey2019.myciteuniv;

import android.content.Context;
import android.os.Bundle;

import com.bambey2019.myciteuniv.Model.Users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bambey2019.myciteuniv.Model.Users;
import com.google.android.material.button.MaterialButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;


public class PublierReservation extends AppCompatActivity{


        private static final String TAG = "PublierReservation";


        private DatabaseReference mPostReference;
        private String mPostKey = "codePerm";
        private TextView mAuthorView;
        private TextView mTitleView;
        private TextView mBodyView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_publier_reservation);

            // Get post key from intent


            // Initialize Database
            mPostReference = FirebaseDatabase.getInstance().getReference().child("Users").child("2016");



            // Initialize Views
            mAuthorView = findViewById(R.id.postAuthor);
            mTitleView = findViewById(R.id.postTitle);
            mBodyView = findViewById(R.id.postBody);


        }

        @Override
        public void onStart() {
            super.onStart();

            // Add value event listener to the post
            // [START post_value_event_listener]
            mPostReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    Users post = dataSnapshot.getValue(Users.class);
                    // [START_EXCLUDE]
                    mAuthorView.setText(post.getNom());
                    mTitleView.setText(post.getFiliere());
                    mBodyView.setText(post.getNiveau());
                    // [END_EXCLUDE]
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // [START_EXCLUDE]
                    Toast.makeText(PublierReservation.this, "Failed to load post.",
                            Toast.LENGTH_SHORT).show();
                    // [END_EXCLUDE]
                }
            });

            // [END post_value_event_listener]




}}
