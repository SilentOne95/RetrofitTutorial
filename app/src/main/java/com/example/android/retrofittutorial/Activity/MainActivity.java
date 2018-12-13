package com.example.android.retrofittutorial.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.retrofittutorial.Fragment.StandingsFragment;
import com.example.android.retrofittutorial.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mBottomNavView = findViewById(R.id.navigation);
        mBottomNavView.setOnNavigationItemSelectedListener(this);
        mBottomNavView.getMenu().getItem(0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_standings:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, StandingsFragment.newInstance(null, null))
                        .commit();
                return true;
            case R.id.nav_fixtures:

                return true;
            case R.id.nav_top_scorers:

                return true;
        }

        return false;
    }
}