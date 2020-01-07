package com.rizky92.latihanfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFrag = new HomeFragment();
        Fragment frag = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(frag instanceof HomeFragment)) {
            Log.d("MyFlexibleFragment", "Fragment Name: " + HomeFragment.class.getSimpleName());
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFrag, HomeFragment.class.getSimpleName())
                    .commit();
        }
    }
}
