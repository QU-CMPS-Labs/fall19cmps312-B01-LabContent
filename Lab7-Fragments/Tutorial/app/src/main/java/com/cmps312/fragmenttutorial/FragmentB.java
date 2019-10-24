package com.cmps312.fragmenttutorial;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    private static final String ARGS_KEY = "name";
    private String name = "";

    private InteractionInterface listner;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listner = (InteractionInterface) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        if (getArguments() != null)
            name = getArguments().getString(ARGS_KEY);
    }

    public static FragmentB newInstance(String name) {
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


        fragmentBTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.sayHello("Message from fragment B");
            }
        });

        return rootview;
    }

    public interface InteractionInterface {
        void sayHello(String message);
    }

}
