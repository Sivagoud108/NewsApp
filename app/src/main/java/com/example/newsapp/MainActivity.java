package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,mscience,msports,mentertainment,mtechnology,mhealth;
    Toolbar toolbar;
    PagerAdapter pagerAdapter;

    String api = "2a1a8c6564114b3eb59f17a30ea0dcd4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mhome = findViewById(R.id.home);
        mscience = findViewById(R.id.science);
        mentertainment = findViewById(R.id.entertainment);
        mtechnology = findViewById(R.id.technology);
        msports = findViewById(R.id.sports);
        mhealth = findViewById(R.id.health);
        ViewPager viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.include);

        pagerAdapter= new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);


       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());

               if (tab.getPosition() == 0 ||tab.getPosition() == 1 ||tab.getPosition() == 2 ||tab.getPosition() == 3 ||tab.getPosition() == 4 ||tab.getPosition() == 5){
                    pagerAdapter.notifyDataSetChanged();
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}