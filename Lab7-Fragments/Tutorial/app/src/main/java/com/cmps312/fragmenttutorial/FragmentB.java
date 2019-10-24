package com.cmps312.fragmenttutorial;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    private static final String ARGS_KEY = "name";
    private String name = "";

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        if (getArguments() != null)
            name = getArguments().getString(ARGS_KEY);
    }



    public static FragmentB newInstance(String name){
        FragmentB fragmentB = new FragmentB();

        Bundle bundle = new Bundle();
        bundle.putString(ARGS_KEY, "Abdulahi");

        fragmentB.setArguments(bundle);
        return fragmentB;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.fragment_b, container, false);

        TextView fragmentBTV = rootview.findViewById(R.id.fragment_b_tv);

        fragmentBTV.setText(fragmentBTV.getText().toString() + " " + name);

        return rootview;
    }

}
