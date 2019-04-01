package com.sahar.countriesmvp.Model.Network;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.sahar.countriesmvp.Model.Country;
import com.sahar.countriesmvp.Screens.MainScreen.MainActivity;
import com.sahar.countriesmvp.Screens.MainScreen.MainContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DataDownloader {

    MainContract.MainPresenter presenter;
    Handler handler ;

    ArrayList<Country> countryList = new ArrayList<Country>();

    public DataDownloader() {
    }

    public DataDownloader(MainContract.MainPresenter presenter) {
        this.presenter = presenter;

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.i("testing: ","countryList in DD size is "+countryList.size());
                DataDownloader.this.presenter.setCountryList(countryList);


            }
        };

        Thread thread = new Thread(new DataThread());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        this.presenter.displayFirstCountry();
//        new Thread(new DataThread()).start();
    }


    private ArrayList<Country> getCountryList(){return this.countryList;}

    class DataThread implements Runnable {

        JSONObject jsonObj = null;


        public DataThread() {}

        @Override
        public void run() {

            String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
            URL urlObj = null;

            String response = null;
            HttpURLConnection conn = null;
            InputStream inputStream = null;
            try {
                urlObj = new URL(url);
                conn = (HttpURLConnection) urlObj.openConnection();
                conn.connect();
                inputStream = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToStr(inputStream);
                if (response != null) {
                    jsonObj = new JSONObject(response);
                    parseJsonObj(jsonObj);
                    Log.i("testing: ","inside response check ");

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private String convertStreamToStr(InputStream inputStream) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringBuilder.toString();
        }

        private void parseJsonObj(JSONObject jsonObject) {
            if (jsonObject != null) {
                try {
                    JSONArray world = jsonObject.getJSONArray("worldpopulation");
                    for (int i = 0; i < world.length(); i++) {
                        JSONObject country = world.getJSONObject(i);
                        int rank = country.getInt("rank");
                        String countryName = country.getString("country");
                        String pop = country.getString("population");
                        String url = country.getString("flag");
                        url.replace("http", "https");
                        String urlHttps = "https" + url.substring(4);
                        System.out.println(rank + ".." + countryName + " \n " + urlHttps);

                        Country countryObj = new Country();
                        countryObj.setCountryName(countryName);
                        countryObj.setFlagUrl(urlHttps);
                        countryObj.setPop(pop);
                        countryObj.setRank(String.valueOf(rank));

                        countryList.add(countryObj);
                        System.out.println(countryList.size());

                    }
                    handler.sendEmptyMessage(0);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


/*        public ArrayList<Country> getCountries() {
            Thread thread = new Thread(this);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return countryList;
        } */
    }

}