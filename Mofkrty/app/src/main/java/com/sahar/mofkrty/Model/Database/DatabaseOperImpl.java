package com.sahar.mofkrty.Model.Database;

import android.content.Context;

import com.sahar.mofkrty.Screens.Presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatabaseOperImpl implements DatabaseOperations {

    private static String fileName = "Note.txt";

    Presenter presenter ;
    public DatabaseOperImpl(Presenter presenter)
    {
        this.presenter = presenter ;
        Context context = this.presenter.getContext();


    }


    @Override
    public boolean saveToFile(String username, String title, String body) {
        String row = username + "," + title + "," + body;

        boolean check = false;

        FileOutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            Context context = this.presenter.getContext() ;
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
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
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

        @Override
    public String loadFromFile(String username, String title) {

        String row = username + "," + title;
        System.out.println(row);
        String body = "notexist" ;
        boolean check = false;

        FileInputStream inputStream = null;
        DataInputStream dataInputStream = null;

        String data = "";
        try {
            Context context = this.presenter.getContext();
            inputStream = context.openFileInput(fileName);
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



