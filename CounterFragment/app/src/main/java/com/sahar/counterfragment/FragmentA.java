package com.sahar.counterfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment implements View.OnClickListener {

    Communicator comm ;
    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmenta, container, false);

        Button b = (Button) v.findViewById(R.id.countBtn);
        b.setOnClickListener(this);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
    }


    @Override
    public void onClick(View v) {
        comm.increment();

    }
}

