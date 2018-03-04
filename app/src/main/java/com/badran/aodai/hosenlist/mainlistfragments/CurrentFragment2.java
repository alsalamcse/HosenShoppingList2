package com.badran.aodai.hosenlist.mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.badran.aodai.hosenlist.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentFragment2 extends Fragment {


    private TextView TVTotal;
    private TextView TVTotalValue;
    private TextView TVCount;
    private TextView TVCountValue;
    private ImageButton IMBSAVE;
    private ListView LSVCurrent;

    private ProductAdapter productAdapter;


    public CurrentFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current, container, false);
        TVTotal = (TextView) view.findViewById(R.id.TVTotal);
        TVTotalValue = (TextView) view.findViewById(R.id.TVTotalValue);
        TVCount = (TextView) view.findViewById(R.id.TVCount);
        TVCountValue = (TextView) view.findViewById(R.id.TVCountValue);
        IMBSAVE = (ImageButton) view.findViewById(R.id.IMBSAVE);
        LSVCurrent = (ListView) view.findViewById(R.id.LSTVCurrent);



        readAndListen();

        //4.
        return view;
    }


    //read and listen data from database
    private void readAndListen() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child(email).child("mylist").
                addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                       productAdapter.clear();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Product pd = ds.getValue(Product.class);
                            Log.d("SL", pd.toString());
                            productAdapter.add(p);
                        }

                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

}
