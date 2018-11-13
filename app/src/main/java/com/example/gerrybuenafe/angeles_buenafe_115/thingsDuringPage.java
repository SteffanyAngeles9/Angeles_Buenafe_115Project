package com.example.gerrybuenafe.angeles_buenafe_115;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class thingsDuringPage extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTitle;

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_during_page);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("DURING THE FLOOD: DO'S AND DONT'S");

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

        listDataHeader.add("DO'S");
        listDataHeader.add("DONT'S");

        List<String> dos = new ArrayList<>();

        dos.add("Switch off electrical and gas appliances, and turn off services off at the mains");
        dos.add("Carry your emergency kit and let your friends and family know where you are going");
        dos.add("Avoid contact with flood water it may be contaminated with sewage,oil,chemicals or other substances");
        dos.add("If you have to walk in standing water, use a pole or stick to ensure that you do not step into deep water, open manholes or ditches");
        dos.add("Stay away from power lines electrical current can travel through water, Report power lines that are down to the power company");
        dos.add("Look before you step-after a flood, the ground and floors are covered with debris, which may include broken bottles, sharp objects, nails etc.Floors and stairs covered with mud and debris can be slippery");
        dos.add("Listen to the radio or television for updates and information");
        dos.add("If the ceiling is wet shut off electricity. Place a bucket underneath the spot and poke a small hole into the ceiling to relieve the pressure");
        dos.add("Use buckets,clean towels and mops to remove as much of the water from the afflicted rooms as possible");
        dos.add("Place sheets of aluminium foil between furniture wet carpet");


        List<String> no = new ArrayList<>();
        no.add("Don't walk through flowing water - currents can be deceptive, and shallow, fast moving water can knock you off your feet");
        no.add("Don't swim through fast flowing water - you may get swept away or struck by an object in the water");
        no.add("Don't drive through a flooded area - You may not be able to see abrupt drop - offs and only half a meter of flood water can carry a car away. Driving through flood water can also cause additional damage to nearby property");
        no.add("Don't eat any food that has come into contact with flood water");
        no.add("Don't reconnect your power supply until a qualified engineer has checked it. Be alert for gas leaks - do not smoke or use candles, lanterns, or open flames");
        no.add("Don't scrub or brush mud and other deposits from materials, This may cause further damage");
        no.add("Never turn on ceiling fixtures if ceiling is wet. Stay away from ceilings those are sagging");
        no.add("Never use TVs, VCRS, CRT terminals or other electrical equipment while standing on wet floors, especially concrete");
        no.add("Don't attempt to remove standing water using your vacuum cleaner.");
        no.add("Don't remove standing water in a basement too fast. If the pressure is relieved too quickly it may put undue stress on the walls");

        listHash.put(listDataHeader.get(0),dos);
        listHash.put(listDataHeader.get(1),no);


    }

    @Override
        public boolean onOptionsItemSelected(MenuItem item){
            if(item.getItemId()==android.R.id.home)
                finish();
            return super.onOptionsItemSelected(item);
        }
}
