package com.sahar.countriesmvp.Model.Network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.sahar.countriesmvp.Screens.MainScreen.MainContract;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ImageDownloader extends AsyncTask<String,Void, Bitmap> {

    MainContract.MainPresenter presenter ;
    public ImageDownloader(){

    }

    public ImageDownloader(MainContract.MainPresenter presenter){
        this.presenter = presenter ;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        HttpsURLConnection httpsConn;
        String url = strings[0];
        URL urlObj = null;
        InputStream inputStream = null;
        Bitmap img = null;

        try {
            urlObj = new URL(url);
            httpsConn = (HttpsURLConnection) urlObj.openConnection();
            httpsConn.connect();
            inputStream = httpsConn.getInputStream();
            img = BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return img;
        }

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap!=null)
            this.presenter.setImage(bitmap);
        else{
            this.presenter.viewErrMsg();
        }
    }
}
