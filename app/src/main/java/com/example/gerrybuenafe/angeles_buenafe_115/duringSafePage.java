package com.example.gerrybuenafe.angeles_buenafe_115;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class duringSafePage extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTitle;

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_safe_page);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("THINGS TO REMEMBER DURING THE FLOOD");

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

        listDataHeader.add("Be Alert");
        listDataHeader.add("Don’t drive unless you have to");
        listDataHeader.add("Get to high ground – Climb to safety");
        listDataHeader.add("NEVER drive through flooded roadways");
        listDataHeader.add("Evacuate immediately");
        listDataHeader.add("Never try to walk or swim through flowing water");


        List<String> alert = new ArrayList<>();
        alert.add("Monitor your surroundings");

        List<String> drive = new ArrayList<>();
        drive.add("Make sure your vehicle has enough fuel");
        drive.add("Follow recommended routes. DO NOT sightsee");
        drive.add("Avoid disaster areas. Your presence might hamper rescue or other emergency operations and put you at further risk");
        drive.add("Watch for washed out roads, earth slides, and downed trees or power lines");
        drive.add("Be especially cautious at night, when it is harder to recognize flood dangers");
        drive.add("If the vehicle stalls, abandon it");
        drive.add("If water rises around your car, leave the vehicle immediately. Climb to higher ground as quickly as possible");

        List<String> never = new ArrayList<>();
        never.add("The roadbed may be washed out");
        never.add("You can lose control of your vehicle in only a few inches of water");
        never.add("Your car may float. Vehicles can be swept away by less than 2 feet of water");
        never.add("Do not drive around a barricade. Turn around and go another way");


        List<String> high = new ArrayList<>();
        high.add("Get out of low areas that may be subject to flooding");
        high.add("Avoid already-flooded areas and do not attempt to cross flowing water");
        high.add("Stay away from power lines and electrical wires");


        List<String> evacuate = new ArrayList<>();
        evacuate.add("Act quickly. Save yourself, not your belongings");
        evacuate.add("Move to a safe area before access is cut off by rising water");
        evacuate.add("Families should use only one vehicle to avoid getting separated and reduce traffic jams");
        evacuate.add("Shut off water, gas, and electrical services before leaving");
        evacuate.add("Secure your home: lock all doors and windows");
        evacuate.add("If directed to a specific location, go there");

        List<String> walk = new ArrayList<>();
        walk.add("If flowing water is above your ankles, STOP! Turn around and go another way");
        walk.add("If it is moving swiftly, water 6 inches deep can knock you off your feet");
        walk.add("Be aware that people have been swept away wading through flood waters");
        walk.add("NEVER allow children to play around high water, storm drains, creeks, or rivers");

        listHash.put(listDataHeader.get(0),alert);
        listHash.put(listDataHeader.get(1),drive);
        listHash.put(listDataHeader.get(2),never);
        listHash.put(listDataHeader.get(3),high);
        listHash.put(listDataHeader.get(4),evacuate);
        listHash.put(listDataHeader.get(5),walk);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
