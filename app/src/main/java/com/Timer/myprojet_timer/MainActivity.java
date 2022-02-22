package com.Timer.myprojet_timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ContentListe.Listener listener;
    RecyclerView recyclerView;
    List<Event> events;
    private static String JSON_URL = "https://theinfobenin.000webhostapp.com/json/index2.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        events = new ArrayList<>();
        GetData getData = new GetData();
        getData.execute();

    }

    public class GetData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while (data != -1){
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (urlConnection != null){
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return current;
        }

        @Override
        protected void onPostExecute(String s){
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("timer");

                for(int i = 0; i < jsonArray.length() ; i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    Event event = new Event();
                    event.setTitle(jsonObject1.getString("pays"));
                    event.setDescription(jsonObject1.getString("dateheure"));


                    events.add(event);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            PutDataIntoRecyclerView(events);
        }
    }

    private void PutDataIntoRecyclerView(List<Event> chaine_List){
        setOnClick();
        ContentListe contentListe = new ContentListe(this, events, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contentListe);
    }

    private void setOnClick() {
        listener = new ContentListe.Listener() {
            @Override
            public void onClick(View v, int position) {
               if (position == 0){
                   Intent intent = new Intent(v.getContext(),Activity_Afghanistan.class);
                   startActivity(intent);
               }else if (position == 1){
                   Intent intent = new Intent(v.getContext(),Activity_Albanie.class);
                   startActivity(intent);
               }
               else if (position == 2){
                   Intent intent = new Intent(v.getContext(),Activity_Algeria.class);
                   startActivity(intent);
               }else if (position == 3){
                   Intent intent = new Intent(v.getContext(),Activity_Andorre.class);
                   startActivity(intent);
               }else if (position == 4){
                   Intent intent = new Intent(v.getContext(),Activity_Angola.class);
                   startActivity(intent);
            }else if (position == 5){
                   Intent intent = new Intent(v.getContext(),Activity_Antigua.class);
                   startActivity(intent);
               }else if (position == 6){
                   Intent intent = new Intent(v.getContext(),Activity_Argentine.class);
                   startActivity(intent);
               }else if (position == 7){
                   Intent intent = new Intent(v.getContext(),Activity_Amenia.class);
                   startActivity(intent);
               }else if (position == 8){
                   Intent intent = new Intent(v.getContext(),Activity_Australia.class);
                   startActivity(intent);
               }else if (position == 9){
                   Intent intent = new Intent(v.getContext(),Activity_Austria.class);
                   startActivity(intent);
               }else if (position == 10){
                   Intent intent = new Intent(v.getContext(),Activity_Azerbaijan.class);
                   startActivity(intent);
               }else if (position == 11){
                   Intent intent = new Intent(v.getContext(),Activity_Bahamas.class);
                   startActivity(intent);
               }else if (position == 12){
                   Intent intent = new Intent(v.getContext(),Activity_Benin.class);
                   startActivity(intent);
               }
        }
    };

}
}
