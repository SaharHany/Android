package com.sahar.countries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    JSONObject jsonObj = null;
    ArrayList<Country> countries = new ArrayList();

    ImageView countryImg = null;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView countryIndx = findViewById(R.id.countryIndxText);
        TextView countryName = findViewById(R.id.countryNameText);
        TextView pop = findViewById(R.id.popText);
        countryImg = findViewById(R.id.imageView);

        new Thread(new Countries()).start();

        Button nextBtn = findViewById(R.id.nextBtn);
        Button previousBtn = findViewById(R.id.previousBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<9) {
                    position++;
                }
                else{
                    position = 0 ;
                }
                showData();
            }
        });



        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>0) {
                    position--;
                }
                else{
                    position = 9 ;
                }
                showData();
            }
        });
    }


    private void showData()
    {
        TextView countryIndx = findViewById(R.id.countryIndxText);
        TextView countryName = findViewById(R.id.countryNameText);
        TextView pop = findViewById(R.id.popText);

        countryIndx.setText(countries.get(position).getRank());
        countryName.setText(countries.get(position).getCountryName());
        pop.setText(countries.get(position).getPop());
        Downloader downloader = new Downloader();
        downloader.execute(countries.get(position).flagUrl);
    }

    class Countries implements Runnable{

        Handler handler = new Handler();
        @Override
        public void run() {

            String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
            URL urlObj = null;

            String response = null ;
            HttpURLConnection conn = null;
            InputStream inputStream = null ;
            try {
                urlObj = new URL(url);
                conn = (HttpURLConnection) urlObj.openConnection();
                conn.connect();
                inputStream = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToStr(inputStream);
                if(response!=null) {
                    jsonObj = new JSONObject(response);
                    parseJsonObj(jsonObj);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            TextView countryIndx = findViewById(R.id.countryIndxText);
                            TextView countryName = findViewById(R.id.countryNameText);
                            TextView pop = findViewById(R.id.popText);

                            countryIndx.setText(countries.get(0).getRank());
                            countryName.setText(countries.get(0).getCountryName());
                            pop.setText(countries.get(0).getPop());
                            Downloader downloader = new Downloader();
                            downloader.execute(countries.get(0).flagUrl);

                        }
                    });

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private String convertStreamToStr(InputStream inputStream)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line ;
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringBuilder.toString();
        }

        private void parseJsonObj(JSONObject jsonObject)
        {
            if(jsonObject != null)
            {
                try {
                    JSONArray world = jsonObject.getJSONArray("worldpopulation");
                    for(int i = 0 ;i<world.length();i++)
                    {
                        JSONObject country = world.getJSONObject(i);
                        int rank = country.getInt("rank");
                        String countryName = country.getString("country");
                        String pop = country.getString("population");
                        String url = country.getString("flag");
                        url.replace("http","https");
                        String urlHttps = "https"+url.substring(4);
                        System.out.println(rank+ ".."+countryName+" \n "+urlHttps);

                        Country countryObj = new Country();
                        countryObj.setCountryName(countryName);
                        countryObj.setFlagUrl(urlHttps);
                        countryObj.setPop(pop);
                        countryObj.setRank(String.valueOf(rank));

                        countries.add(countryObj);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    class Downloader extends AsyncTask<String, Void, Bitmap> {
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
            if(bitmap!=null){
                countryImg.setImageBitmap(bitmap);
                Toast.makeText(MainActivity.this, "Image is downloaded Successfully", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Downloading failed ", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
