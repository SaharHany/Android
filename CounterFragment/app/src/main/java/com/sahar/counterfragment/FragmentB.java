package com.sahar.counterfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {



    int counter = 0;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState!=null)
        {
            counter = savedInstanceState.getInt("counter");
        }

        View view = inflater.inflate(R.layout.fragmentb, container, false);;
        TextView countTV = (TextView) view.findViewById(R.id.counterTV);
        countTV.setText(counter+"");
        return view ;
    }

    public void incrementCounter()
    {
        TextView countTV = (TextView) getView().findViewById(R.id.counterTV);
        counter++;
        countTV.setText(counter+"");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("counter",counter);
        super.onSaveInstanceState(outState);

    }
}
