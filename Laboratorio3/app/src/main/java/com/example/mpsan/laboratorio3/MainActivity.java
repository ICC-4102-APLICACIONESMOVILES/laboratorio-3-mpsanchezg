package com.example.mpsan.laboratorio3;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import Databases.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private static final String DATABASE_NAME = "movies_db";
    private UserDatabase userDatabase;
    userDatabase = Room.databaseBuilder(getApplicationContext(),
        .class, DATABASE_NAME)
            .fallbackToDesctructiveMigration()
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display", "");

        TextView displayInfo = (TextView) findViewById(R.id.name_text_view);

        displayInfo.setText(display);

        if (displayInfo == null){
            Intent displayLogin = new Intent(MainActivity.this, UserLoginActivity.class);
            startActivity(displayLogin);
        }*/



        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        int id = menuItem.getItemId();

                        if (id == R.id.drawer_add_form) {
                            Fragment fragment;
                            fragment = new AddFormFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
                        }
                        else if(id == R.id.drawer_forms){
                            Fragment fragment;
                            fragment = new FormFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
                        }
                        else if (id == R.id.drawer_summary_form) {
                            Fragment fragment;
                            fragment = new FormSummaryFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
                        }

                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
                        drawer.closeDrawer(GravityCompat.START);

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.drawer_add_form) {
            Fragment fragment;
            fragment = new AddFormFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
        }
        else if(id == R.id.drawer_forms){
            Fragment fragment;
            fragment = new FormFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
        }
        else if (id == R.id.drawer_summary_form) {
            Fragment fragment;
            fragment = new FormSummaryFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

/* References: https://www.youtube.com/watch?v=mN6kM_1M0cY */
