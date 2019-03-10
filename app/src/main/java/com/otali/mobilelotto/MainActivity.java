package com.otali.mobilelotto;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;

import org.xmlpull.v1.XmlPullParser;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";

    private SectionsPagerAdapter mSectionPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_announcement_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_android_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_all_out_black_24dp);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_bar);
        Menu menu= bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_add:
                        Intent intent1 = new Intent(MainActivity.this, PlayGameActivity.class);
                        startActivity(intent1);
                        break;
                }
                return false;
            }
        });


    }

    private void setupViewPager (ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }

    private View getView(XmlPullParser layout, LayoutInflater inflater, ViewGroup viewGroup)
    {
        View view = null;
        try{
            view =  inflater.inflate(layout,viewGroup, false);
        }catch(Exception ex){
            Log.e("error getting View {}", ex.getMessage());
        }
        return view;
    }
}
