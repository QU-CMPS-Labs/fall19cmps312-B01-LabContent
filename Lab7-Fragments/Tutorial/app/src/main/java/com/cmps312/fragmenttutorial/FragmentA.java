package com.cmps312.fragmenttutorial;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentA extends Fragment {


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView =  inflater.inflate(R.layout.fragment_a, container, false);

        TextView textView = rootView.findViewById(R.id.fragment_a_tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "I was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
