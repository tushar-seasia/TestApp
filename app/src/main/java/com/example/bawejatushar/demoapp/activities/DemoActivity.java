package com.example.bawejatushar.demoapp.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bawejatushar.demoapp.R;
import com.example.bawejatushar.demoapp.dtos.Diseases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);


    }

    class JsonTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream=connection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                String response=null;
                StringBuffer stringBuffer=new StringBuffer();
                while (bufferedReader.readLine() != null){
                    stringBuffer.append(bufferedReader.readLine());
                }
                response=stringBuffer.toString();

                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray=jsonObject.getJSONArray("country");

                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);


                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
