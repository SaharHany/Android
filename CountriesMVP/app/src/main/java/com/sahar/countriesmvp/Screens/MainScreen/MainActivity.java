package com.sahar.countriesmvp.Screens.MainScreen;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sahar.countriesmvp.Model.Country;
import com.sahar.countriesmvp.R;

public class MainActivity extends AppCompatActivity implements MainContract.MainView , View.OnClickListener {

    private int position = 0;
    ImageView countryImg ;
    MainContract.MainPresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainPresenterImpl(this);

        this.countryImg = findViewById(R.id.imageView);
        Button prevBtn = findViewById(R.id.previousBtn);
        Button nextBtn = findViewById(R.id.nextBtn);

        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.previousBtn:
                if(position>0)
                    position--;
                else
                    position = 9 ;
               presenter.displayCountry(position);
               break;

            case R.id.nextBtn:
                if(position<9)
                    position++;
                else
                    position = 0 ;
                presenter.displayCountry(position);
                break;
        }
    }

    @Override
    public void setImage(Bitmap img)
    {
        this.countryImg.setImageBitmap(img);
    }

    @Override
    public void setCountryRank(String countryRank)
    {
        TextView countryIndx = findViewById(R.id.countryIndxText);
        countryIndx.setText(countryRank);
    }

    @Override
    public void setCountryName(String countryName)
    {
        TextView countryNameTV = findViewById(R.id.countryNameText);
        countryNameTV.setText(countryName);
    }

    @Override
    public void setCountryPop(String countryPop)
    {
        TextView pop = findViewById(R.id.popText);
        pop.setText(countryPop);
    }

    @Override
    public void displayFirstCountry(Country country) {
      /*  MainActivity.this.runOnUiThread(()->{

        });*/
    }


}
