package com.moringaschool.classschedulerapp.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.classschedulerapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AltLandingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt_landing);
        ButterKnife.bind(this);
        //add listener to navigation drawer items
        navigationView.setNavigationItemSelectedListener(this);

        //use custom toolbar as actionbar
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //handles configuration changes
        if (savedInstanceState==null) {
            //open message fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ModulesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_modules);
        }

    }


    //handle navigation drawer click events
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_modules:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ModulesFragment()).commit();
                break;
            case R.id.nav_schedules:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScheduleFragment()).commit();
                break;
            case R.id.nav_announcements:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnnouncementsListFragment()).commit();
                break;
            case R.id.nav_profile:
                Intent profileIntent = new Intent(this, ProfileActivity.class);
                startActivity(profileIntent);
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_edit_profile:
                Intent editProfileIntent = new Intent(this, AddEditProfileActivity.class);
                startActivity(editProfileIntent);
                Toast.makeText(this, "Edit Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                logOut();
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        //close drawer on item click
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //don't leave activity on back press, but close drawer instead, if already open
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void logOut() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(AltLandingActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}