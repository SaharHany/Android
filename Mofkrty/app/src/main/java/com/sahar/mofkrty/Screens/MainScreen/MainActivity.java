package com.sahar.mofkrty.Screens.MainScreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sahar.mofkrty.R;
import com.sahar.mofkrty.Screens.HomeScreen.Home;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , MainContract.MainView {

   // private static String fileName = "Note.txt";
    //public static FileOutputStream outputStream = null;

//    public static final String PREFS_NAME = "UserReg";
    String usernameLoggedIn = "";
  //  SharedPreferences sharedPref ;

    EditText usernameText = null;
    String usernameTextCont ="";

    EditText passwordText = null;
    String passwordTextCont  = "";

    MainContract.MainPresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainPresenterImpl(this);

  /*
        sharedPref = getSharedPreferences(PREFS_NAME , MODE_PRIVATE);
        if(!sharedPref.contains("loggedIn"))
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("loggedIn","False");
            editor.commit();
        }
*/
      //  String logged = sharedPref.getString("loggedIn","False");

        String logged = this.presenter.getLoggedInValue();
        if(!logged.equals("False"))
        {
            usernameLoggedIn = logged ;
            Intent intent = new Intent(this, Home.class);
            intent.putExtra("Name", logged);
            startActivity(intent);
        }



        Button signinBtn = findViewById(R.id.signinBtn);
        Button regBtn    =  findViewById(R.id.regBtn);

        signinBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        usernameText = (EditText) findViewById(R.id.usernameText);
        usernameTextCont = usernameText.getText().toString();

        passwordText = (EditText) findViewById(R.id.passwordText);
        passwordTextCont = passwordText.getText().toString();

        System.out.println(usernameTextCont + " ... "+ passwordTextCont+"  onclick");


        switch (v.getId()) {
            case  R.id.regBtn: {

                boolean checkReg = this.presenter.regUser(usernameTextCont,passwordTextCont);
                if(checkReg==true)
                {
                    usernameText.setText("");
                    passwordText.setText("");
                    Toast.makeText(this, "Regiseration done Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    usernameText.setText("");
                    passwordText.setText("");
                    Toast.makeText(this, "Regiseration Failed", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.signinBtn: {

                boolean checkLogin = this.presenter.checkUser(usernameTextCont,passwordTextCont);
                if(checkLogin==true)
                {
/*                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.remove("loggedIn");
                    editor.putString("loggedIn",usernameTextCont);
                    editor.commit();
*/
                    this.presenter.setLoggedInUser(usernameTextCont);
                    usernameLoggedIn = usernameTextCont ;

                    Toast.makeText(this, usernameTextCont, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, Home.class);
                    intent.putExtra("Name", usernameTextCont);
                    startActivity(intent);
                    break;

                }
                else{
                    usernameText.setText("");
                    passwordText.setText("");
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    /*
    private boolean regUser(String username,String password)
    {
        System.out.println(username + " ... "+ password+"  regUser");

        if(!checkUser(username,password))
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.remove("Name");
            editor.remove("Password");
            editor.putString("Name",username);
            editor.putString("Password",password);
            //editor.putString("loggedIn","False");
            editor.commit();

            DataOutputStream dataOutputStream = null;

            try {
                outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

                dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.flush();
                outputStream.flush();
                dataOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return true;
        }
        else return false;
    }

    private boolean checkUser(String username,String password)
    {
        String checkName = sharedPref.getString("Name","notExist");
        String checkPassword = sharedPref.getString("Password","notExist");

        System.out.println(username + " ... "+ password);

        if(checkName.equals(username) && checkPassword.equals(password) && !username.equals("") && !password.equals(""))
        {
            return true;
        }
        else{
            return false;
        }
    }

    */
    @Override
    public String getUsername() {
        return usernameTextCont;
    }

    @Override
    public String getPassword() {
        return passwordTextCont;
    }
}
