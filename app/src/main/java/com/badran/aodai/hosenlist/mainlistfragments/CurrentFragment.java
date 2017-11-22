package com.badran.aodai.hosenlist.mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.badran.aodai.hosenlist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentFragment extends Fragment {
    private TextView TVTotal;
    private TextView TVTotalValue;
    private TextView TVCount;
    private TextView TVCountValue;
    private ImageButton IMBSAVE;
    private ListView LSVCurrent;


    public CurrentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_current, container, false);
        TVTotal=(TextView) view.findViewById(R.id.TVTotal);
        TVTotalValue=(TextView) view.findViewById(R.id.TVTotalValue);
        TVCount=(TextView) view.findViewById(R.id.TVCount);
        TVCountValue=(TextView) view.findViewById(R.id.TVCountValue);
        IMBSAVE=(ImageButton) view.findViewById(R.id.IMBSAVE);
        LSVCurrent=(ListView) view.findViewById(R.id.LSTVCurrent);

        String []ar={"stam1","stam2","stam3"};
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,)

        //4.
        return view;
    }

}
