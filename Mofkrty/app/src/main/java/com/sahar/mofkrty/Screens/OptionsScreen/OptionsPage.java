package com.sahar.mofkrty.Screens.OptionsScreen;

import android.content.Context;
import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

import com.sahar.mofkrty.Model.Database.DatabaseAdapter;
import com.sahar.mofkrty.R;
import com.sahar.mofkrty.Screens.MainScreen.MainActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OptionsPage extends AppCompatActivity implements View.OnClickListener{

    private static String fileName = "Note.txt";
    String username = "";
    String titleTextCont = "";
    String bodyTextCont  = "";
    DatabaseAdapter dbAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionspage);

        dbAdapter = new DatabaseAdapter(this);
        Intent intent = getIntent();
        username = intent.getStringExtra("Name");


        titleTextCont = intent.getStringExtra("Title");

        TextView titleTV = findViewById(R.id.titleText);
        titleTV.setText(titleTextCont);


        bodyTextCont = intent.getStringExtra("Body");

        TextView bodyTV = findViewById(R.id.bodyText);
        bodyTV.setText(bodyTextCont);



        Button closeBtn = (Button) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(this);


        Button stfBtn = (Button) findViewById(R.id.stfBtn);
        stfBtn.setOnClickListener(this);

        Button lffBtn = (Button) findViewById(R.id.lffBtn);
        lffBtn.setOnClickListener(this);

        Button stsBtn = (Button) findViewById(R.id.stsBtn);
        stsBtn.setOnClickListener(this);

        Button lfsBtn = (Button) findViewById(R.id.lfsBtn);
        lfsBtn.setOnClickListener(this);

            //String name = "";

/*            try {

                FileOutputStream outputStream = null;
                DataOutputStream dataOutputStream = null;

                outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

                dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.flush();
                outputStream.flush();
                dataOutputStream.close();
                outputStream.close();

//            name = dataInputStream.readUTF();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

/*
        if(!name.equals(username))
        {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case  R.id.stfBtn: {
                boolean check = saveToFile(username,titleTextCont ,bodyTextCont);
                if(check)
                {
                    Toast.makeText(this, "Note Saved Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Saving is failed", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case  R.id.lffBtn: {
                String body = loadFromFile(username,titleTextCont);
                Toast.makeText(this,"Note doesn't exist", Toast.LENGTH_SHORT);

                if(!body.equals("notexist"))
                {
                    System.out.println(body+" ...........");
                    TextView bodyTV = findViewById(R.id.bodyText);
                    bodyTV.setText(body);
                    Toast.makeText(this,"Note exists", Toast.LENGTH_SHORT);

                }
                else{
                    Toast.makeText(this,"Note doesn't exist", Toast.LENGTH_SHORT);

                }
                break;
            }

            case  R.id.stsBtn: {
                boolean check = dbAdapter.insertNote(username,titleTextCont,bodyTextCont);
                if(check)
                {
                    Toast.makeText(this,"Note is saved successfully", Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(this,"Saving is failed", Toast.LENGTH_SHORT);
                }
                break;
            }

            case  R.id.lfsBtn: {
                String body = dbAdapter.QueryNote(username,titleTextCont);
                if(body!=null) {
                    TextView bodyTV = findViewById(R.id.bodyText);
                    bodyTV.setText(body);
                }
                else{
                    Toast.makeText(this, "Note doesn't exist.", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.closeBtn: {
                finish();
                break;
            }
        }
    }


    private boolean saveToFile(String username , String title , String body)
    {
        String row = username + "," + title + "," + body;

        boolean check = false;

        FileOutputStream outputStream = MainActivity.outputStream;
        DataOutputStream dataOutputStream = null;

        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF(row);
            //dataOutputStream.flush();
            //outputStream.flush();
            System.out.println(row);
            dataOutputStream.close();
//            outputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return  false ;
        } catch (IOException e) {
            e.printStackTrace();
            return false ;
        }

    }

    private String loadFromFile(String username , String title)
    {

        String row = username + "," + title;
        System.out.println(row);
        String body = "notexist" ;
        boolean check = false;

        FileInputStream inputStream = null;
        DataInputStream dataInputStream = null;

        String data = "";
        try {
            inputStream = openFileInput(fileName);
            dataInputStream = new DataInputStream(inputStream);
            System.out.println("Here...");
            /*data = dataInputStream.readUTF();
            if (data.contains(row))
                check = true;
*/
            while ((!check) && (dataInputStream.available() > 0)) {
                System.out.println("while...");

                data = dataInputStream.readUTF();
                System.out.println(data+"...");

                if (data.contains(row)) {
                    check = true;
                    System.out.println(check);
                }
            }

            dataInputStream.close();
            inputStream.close();
            if(check) {
                String[] arr = data.split(",");
                body = arr[2];

            }
            System.out.println(body);


        }catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return body ;
        }
    }

}

/*
    private boolean saveToFile(String username , String title , String body) {
        String row = username + "," + title + "," + body;

        boolean check = false;

        FileInputStream inputStream = null;
        DataInputStream dataInputStream = null;
        FileOutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;

        String data = "";
        try {


            inputStream = openFileInput(fileName);
            dataInputStream = new DataInputStream(inputStream);

            while ((!check) && (dataInputStream.available() > 0)) {
                data = dataInputStream.readUTF();
                if (data.equals(row))
                    check = true;
            }
            dataInputStream.close();
            inputStream.close();

            if (check) {

                return false;
            } else {
                outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                dataOutputStream = new DataOutputStream(outputStream);

                dataOutputStream.writeUTF(row);

                System.out.println(row);
                dataOutputStream.close();
                outputStream.close();
                return true;
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return false ;
        } catch (IOException e1) {
            e1.printStackTrace();
            return false ;
        }
    }



    private String loadFromFile(String username , String title)
    {
        String row = username + "," + title;
        System.out.println(row);
        String body = null ;
        boolean check = false;

        FileInputStream inputStream = null;
        DataInputStream dataInputStream = null;

        String data = "";
        try {
            inputStream = openFileInput(fileName);
            dataInputStream = new DataInputStream(inputStream);
            System.out.println("Here...");

            while ((!check) && (dataInputStream.available() > 0)) {
                System.out.println("while...");

                data = dataInputStream.readUTF();
                System.out.println(data+"...");

                if (data.contains(row))
                    check = true;
            }
            dataInputStream.close();
            inputStream.close();
            String [] arr = data.split(",");
            body = arr[2];

            System.out.println(body);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{

            return body ;
        }

    }*/

