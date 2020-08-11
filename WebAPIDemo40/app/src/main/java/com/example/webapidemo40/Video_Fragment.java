package com.example.webapidemo40;

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

import com.example.webapidemo40.databinding.VideoFragmentBinding;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Video_Fragment extends Fragment {
    VideoFragmentBinding binding;
    String urlAPI = "http://demo1913415.mockable.io/GetCategory";

    public static Video_Fragment newInstance() {

        Bundle args = new Bundle();

        Video_Fragment fragment = new Video_Fragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate( inflater, R.layout.video_fragment, container, false );
        (new DoGetData()).execute();
        return binding.getRoot();
    }

    class DoGetData extends AsyncTask<Void, Void, Void> {
        String result;

        @Override
        protected void onPreExecute() {
            binding.progessBar.setVisibility( View.VISIBLE );
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
                Log.d( "TAG", "doInBackground: " + result );
                binding.tvName.setText( result );
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute( aVoid );

            binding.progessBar.setVisibility( View.GONE );
        }
    }
}
