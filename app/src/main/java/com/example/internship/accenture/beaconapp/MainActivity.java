package com.example.internship.accenture.beaconapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.internship.accenture.beaconapp.fragments.FragmentHealth;
import com.example.internship.accenture.beaconapp.fragments.FragmentSearch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adding default fragment
        if (findViewById(R.id.fragment) != null){
            if (savedInstanceState != null){
                return;
            }

            FragmentSearch fragmentSearch = new FragmentSearch();
            FragmentManager fM = getFragmentManager();
            fM.beginTransaction().add(R.id.fragment, fragmentSearch).commit();
        }



        changeFragment();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            Intent intent = new Intent(this, TeamActivity.class);
            startActivity(intent);
            return true;
        }
        */

        return super.onOptionsItemSelected(item);
    }


    public void changeFragment(){
        Fragment fragment = new FragmentHealth();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment);
        ft.commit();
    }


}
