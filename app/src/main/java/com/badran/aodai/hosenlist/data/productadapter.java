package com.badran.aodai.hosenlist.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.badran.aodai.hosenlist.R;

/**
 * Created by user on 04/03/2018.
 */

public class productadapter extends ArrayAdapter<product> {
    public productadapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.product, parent, false);
        return view;
    }
}

