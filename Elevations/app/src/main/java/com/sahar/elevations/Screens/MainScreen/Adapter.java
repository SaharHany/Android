package com.sahar.elevations.Screens.MainScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sahar.elevations.Model.Place;
import com.sahar.elevations.R;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private Place[] mDataset ;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view ;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TextView textView = viewHolder.view.findViewById(R.id.textView);
        textView.setText(mDataset[i].getPlaceName());

        FrameLayout frameLayout = viewHolder.view.findViewById(R.id.frameLayout);
        frameLayout.setBackgroundResource(mDataset[i].getImgRec());

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }


    public Adapter(Place [] mDataset){
        this.mDataset = mDataset;

    }



}
