package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;
    androidx.appcompat.widget.Toolbar foodpanda;
    NavigationView navbar;
    ActionBarDrawerToggle hamburger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        foodpanda = (androidx.appcompat.widget.Toolbar) findViewById(R.id.foodpanda);
        navbar = (NavigationView) findViewById(R.id.navbar);

        hamburger = new ActionBarDrawerToggle(this,drawer, foodpanda,R.string.open,R.string.close);
        drawer.addDrawerListener(hamburger);
        hamburger.syncState();
        Home home = new Home();
        FragmentTransaction homechange = getSupportFragmentManager().beginTransaction();
        homechange.replace(R.id.placeholder,home).commit();
        navbar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.one:
                        Toast.makeText(MainActivity.this, "hahha", Toast.LENGTH_SHORT).show();
                    Home home = new Home();
                        FragmentTransaction homechange = getSupportFragmentManager().beginTransaction();
                        homechange.replace(R.id.placeholder,home).commit();
                        break;
                    case R.id.two:
                        Services services = new Services();
                        FragmentTransaction serviceschange = getSupportFragmentManager().beginTransaction();
                        serviceschange.replace(R.id.placeholder,services).commit();
                        break;
                    case R.id.three:
                        Voucher voucher = new Voucher();
                        FragmentTransaction voucherchange = getSupportFragmentManager().beginTransaction();
                        voucherchange.replace(R.id.placeholder,voucher).commit();
                        break;
                    case R.id.four:
                        Feedback feedback = new Feedback();
                        FragmentTransaction feedbackchange = getSupportFragmentManager().beginTransaction();
                        feedbackchange.replace(R.id.placeholder,feedback).commit();
                        break;
                    case R.id.five:
                        Contact contact = new Contact();
                        FragmentTransaction contactchange = getSupportFragmentManager().beginTransaction();
                        contactchange.replace(R.id.placeholder,contact).commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

}