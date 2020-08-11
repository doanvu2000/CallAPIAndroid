package com.example.webapidemo40;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.webapidemo40.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String json = "{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null}";
    String jsonArray1 = "[{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null},{\"id\":\"111\",\"publisher_id\":\"113\",\"content_type\":\"113\",\"tab\":\"110\",\"title\":\"Series Phim\",\"avatar\":\"----------\"}]";
    ActivityMainBinding binding;
    List<Video> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main );
        videoList = new ArrayList<>();
//       getJson();
        getJsonArray();
    }

    private void getJsonArray() {
        try {
            JSONArray jsonArray = new JSONArray( jsonArray1 );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject( i );
                int id = jsonObject.getInt( "id" );
                int publisher_id = jsonObject.getInt( "publisher_id" );
                int content_type = jsonObject.getInt( "content_type" );
                int tab = jsonObject.getInt( "tab" );
                String title = jsonObject.getString( "title" );
                String avatar = jsonObject.getString( "avatar" );
                videoList.add( new Video( id, publisher_id, content_type, tab, title, avatar ) );
            }
            String textView = "";
            for (int i = 0; i < videoList.size(); i++) {
                textView += videoList.get( i ).toString() + "\n";
            }
            binding.tvJson.setText( textView );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getJson() {
        try {
            JSONObject jsonObject = new JSONObject( json );
            int id = jsonObject.getInt( "id" );
            int publisher_id = jsonObject.getInt( "publisher_id" );
            int content_type = jsonObject.getInt( "content_type" );
            int tab = jsonObject.getInt( "tab" );
            String title = jsonObject.getString( "title" );
            String avatar = jsonObject.getString( "avatar" );

            String textview = "id: " + id
                    + "\npublisher_id: " + publisher_id
                    + "\ntitle: " + title + "\n";
            binding.tvJson.setText( textview );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}