package com.sahar.mofkrty.Screens.HomeScreen;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sahar.mofkrty.R;
import com.sahar.mofkrty.Screens.MainScreen.MainActivity;
import com.sahar.mofkrty.Screens.OptionsScreen.OptionsPage;

public class Home extends AppCompatActivity implements View.OnClickListener ,HomeContract.HomeView{

    public String titleTextCont = "";
    public String bodyTextCont = "";
    String username = "";
    //SharedPreferences sharedPref ;
  //  public static final String PREFS_NAME = "UserReg";

    HomeContract.HomePresenter presenter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        presenter = new HomePresenterImpl(this);

//        sharedPref = getSharedPreferences(PREFS_NAME , MODE_PRIVATE);

        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);

        Button closeBtn = (Button) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(this);

        Intent intent = getIntent();
        username = intent.getStringExtra("Name");

        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

    }




    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case  R.id.nextBtn: {
                Intent intent = new Intent(this, OptionsPage.class);
                intent.putExtra("Name", username);

                EditText titleText = (EditText) findViewById(R.id.titleText);
                titleTextCont = titleText.getText().toString();
                //     System.out.println("hnaaaaaaaaaaa: "+mobTextCont);
                intent.putExtra("Title", titleTextCont);

                EditText bodyText = (EditText) findViewById(R.id.bodyText);
                bodyTextCont = bodyText.getText().toString();
                //   System.out.println("hnaaaaaaaaaaa: "+msgTextCont);

                intent.putExtra("Body", bodyTextCont);

                startActivity(intent);
                break;
            }

            case R.id.closeBtn: {
           /*
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.remove("loggedIn");
                editor.putString("loggedIn","False");
                editor.commit();*/
                this.presenter.signOut();
                finish();
                break;
            }
        }
    }
}
