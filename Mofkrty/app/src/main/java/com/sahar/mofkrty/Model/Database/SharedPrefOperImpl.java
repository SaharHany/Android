package com.sahar.mofkrty.Model.Database;

import android.content.Context;
import android.content.SharedPreferences;

import com.sahar.mofkrty.Screens.MainScreen.MainContract;
import com.sahar.mofkrty.Screens.MainScreen.MainPresenterImpl;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefOperImpl implements SharedPrefOperations {
    MainContract.MainPresenter presenter ;

    private static String fileName = "Note.txt";
    public static FileOutputStream outputStream = null;

    public static final String PREFS_NAME = "UserReg";
    SharedPreferences sharedPref ;

    public SharedPrefOperImpl(MainContract.MainPresenter presenter) {
        this.presenter = presenter ;

        Context context = this.presenter.getContext();
        sharedPref = context.getSharedPreferences(PREFS_NAME , MODE_PRIVATE);
        if(!sharedPref.contains("loggedIn"))
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("loggedIn","False");
            editor.commit();
        }

    }


    @Override
    public boolean regUser(String username,String password)
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
                Context context = this.presenter.getContext();
                outputStream = context.openFileOutput(fileName, MODE_PRIVATE);

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

    @Override
    public void setLoggedInUser(String username) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("loggedIn");
        editor.putString("loggedIn",username);
        editor.commit();

    }

    @Override
    public String getLoggedInValue() {
        return sharedPref.getString("loggedIn","False");
    }

    @Override
    public boolean checkUser(String username,String password)
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


}
