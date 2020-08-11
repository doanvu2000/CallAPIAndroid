package com.example.webapidemo40;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.webapidemo40.databinding.ActivityMainBinding;
import com.example.webapidemo40.databinding.ActivityWebAPIDemoBinding;

public class WebAPIDemo extends AppCompatActivity {
    private static final String TAG = "WebAPIDemo";
    ActivityWebAPIDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding= DataBindingUtil.setContentView( this, R.layout.activity_web_a_p_i_demo );
        getFragment( Video_Fragment.newInstance() );
    }
    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_container, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }
}