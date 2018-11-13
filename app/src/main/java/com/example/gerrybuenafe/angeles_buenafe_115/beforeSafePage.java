package com.example.gerrybuenafe.angeles_buenafe_115;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class beforeSafePage extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTitle;

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap <String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_safe_page);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("WHAT YOU SHOULD KNOW?");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        listView = findViewById(R.id.expandable);
        initData();
        listAdapter = new expandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

    }

    private void initData(){
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Know your flood risk");
        listDataHeader.add("Know how to stay informed");
        listDataHeader.add("Know your evacuation routes");

        List<String> ed = new ArrayList<>();
        ed.add("Learn whether you live, work, or travel through areas " +
                "that are prone to flooding");

        List<String> ad = new ArrayList<>();
        ad.add("Monitor the weather reports provided by your local news media. ");
        ad.add("Many communities have text or email alerting systems for emergency notifications. " +
                "To find out what alerts are available in your area, do an Internet search with your " +
                "town, city, or county name and the word “alerts.”");
        ad.add("Think about how you will stay informed if there is a power outage. Have extra " +
                "batteries for a battery-operated radio and your cell phone. Consider having a hand " +
                "crank radio or cell phone charger.");


        List<String> od = new ArrayList<>();
        od.add("Know your community’s local flood evacuation plan and identify several escape routes " +
                "for your location if roads are blocked; include plans to evacuate people with disabilities " +
                "and others with access and functional needs, pets, service animals, and livestock.");

        od.add("If you will evacuate by car, keep your car fueled and in good condition. Keep " +
                "emergency supplies and a change of clothes in your car.");

        od.add("If you will need to share transportation, make arrangements now. If you will need " +
                "to use public transportation, including paratransit, contact your local government " +
                "emergency management agency to ask how an evacuation will work, how you " +
                "will get current information during an evacuation, the location of staging areas, and " +
                "other information.");
        od.add("If you need to relocate for an extended period of time, identify a place away from " +
                "home now where you could go if you had to leave. Consider family or friends who " +
                "live outside of the local area.");
        od.add("If you have pets and plan to go to a shelter, call to inquire whether the shelter can " +
                "accommodate your pets. Shelters will accept service animals");



        listHash.put(listDataHeader.get(0),ed);
        listHash.put(listDataHeader.get(1),ad);
        listHash.put(listDataHeader.get(2),od);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
