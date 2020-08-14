package com.example.testcallapi_doan;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testcallapi_doan.databinding.RecyclerviewFragmentBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {
    RecyclerviewFragmentBinding binding;
    String urlAPI = "http://demo1913415.mockable.io/GetCategory";

    public static RecyclerViewFragment newInstance() {

        Bundle args = new Bundle();

        RecyclerViewFragment fragment = new RecyclerViewFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate( inflater, R.layout.recyclerview_fragment, container, false );
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getContext(), RecyclerView.VERTICAL, false );
//        binding.listVideo.setLayoutManager( layoutManager );
//        videoObjectList = new ArrayList<>();
//        VideoObject a = new VideoObject( 1, 1, 1, 1, "a", "a", 1, 1, 1, 1
//                , "a", "a", 1, 1, 1, 1, "a", "a", 1, "a", "a", 1, "a" );
//        videoObjectList.add( a );
//        new DoGetData().execute();
////        truyen list vao adapter
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter( videoObjectList );
//        binding.listVideo.setAdapter( recyclerViewAdapter );
            new DoGetData().execute(  );
        return binding.getRoot();
    }

    public class DoGetData extends AsyncTask<Void, Void, Void> {
        List<VideoObject> videoObjectList;
        String result = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL( urlAPI );
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
                Log.d( "TAG", "doInBackground, Result =  " + result );
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            videoObjectList = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray( result );
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject( i );
                        int id = jsonObject.getInt( "id" );
                        int publisher_id = jsonObject.getInt( "publisher_id" );
                        int content_type = jsonObject.getInt( "content_type" );
                        int tab = jsonObject.getInt( "tab" );
                        String title = jsonObject.getString( "title" );
                        String avatar = jsonObject.getString( "avatar" );
                        int status = jsonObject.getInt( "status" );
                        int deleted = jsonObject.getInt( "deleted" );
                        int user_created = jsonObject.getInt( "user_created" );
                        int user_modified = jsonObject.getInt( "user_modified" );
                        String date_created = jsonObject.getString( "date_created" );
                        String date_modified = jsonObject.getString( "date_modified" );
                        int parent_id = jsonObject.getInt( "parent_id" );
                        ;
                        int lft = jsonObject.getInt( "lft" );
                        int rgt = jsonObject.getInt( "rgt" );
                        int level = jsonObject.getInt( "level" );
                        String short_code = jsonObject.getString( "short_code" );
                        String command_code = jsonObject.getString( "command_code" );
                        double price = jsonObject.getDouble( "price" );
                        String finished_message = jsonObject.getString( "finished_message" );
                        String help_message = jsonObject.getString( "help_message" );
                        int icash = jsonObject.getInt( "icash" );
                        String thumb = jsonObject.getString( "thumb" );
                    VideoObject videoObject = new VideoObject( id, publisher_id, content_type, tab, title, avatar,
                            status, deleted, user_created, user_modified, date_created, date_modified, parent_id, lft, rgt, level,
                            short_code, command_code, price, finished_message, help_message, icash, thumb );
                    videoObjectList.add( videoObject );
                }
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getContext(), 2,RecyclerView.VERTICAL, false );
                binding.listVideo.setLayoutManager( layoutManager );
                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter( videoObjectList );
                binding.listVideo.setAdapter( recyclerViewAdapter );
            } catch (Exception e) {
                e.printStackTrace();
            }

            super.onPostExecute( aVoid );
        }
    }
}
