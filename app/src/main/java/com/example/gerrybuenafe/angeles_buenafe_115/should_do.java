package com.example.gerrybuenafe.angeles_buenafe_115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class should_do extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTitle;

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap <String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_should_do_before);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("BEFORE THE FLOOD: WHAT YOU SHOULD DO?");

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
        listDataHeader.add("Assemble disaster supplies");
        listDataHeader.add("Be prepared to evacuate");
        listDataHeader.add("Review your Family Disaster Plan");
        listDataHeader.add("Protect your property");


        List<String> ed = new ArrayList<>();
        ed.add("Monitor your surroundings");

        List<String> ad = new ArrayList<>();
        ad.add("Identify places to go");
        ad.add("Identify alternative travel routes that are not prone to flooding");
        ad.add("Plan what to do with your pets");
        ad.add("Fill your car’s gas tank");
        ad.add("If told to leave, do so quickly");

        List<String> id = new ArrayList<>();
        id.add("Click here to learn more");


        List<String> od = new ArrayList<>();
        od.add("Discuss flood plans with your family");
        od.add("Decide where you will meet if separated");
        od.add("Designate a contact person who can be reached if family members get separated. Make sure every family member has the contact information");


        List<String> ud = new ArrayList<>();
        ud.add("Move valuables and furniture to higher levels");
        ud.add("Move hazardous materials (such as paint, oil, pesticides, and cleaning supplies) to higher locations");
        ud.add("Disconnect electrical appliances. Do not touch them if you are wet or standing in water");
        ud.add("Bring outside possessions indoors or tie them down securely. This includes lawn furniture, garbage cans, and other movable objects");
        ud.add("Seal vents to basements to prevent flooding");


        listHash.put(listDataHeader.get(0),ed);
        listHash.put(listDataHeader.get(1),id);
        listHash.put(listDataHeader.get(2),ad);
        listHash.put(listDataHeader.get(3),od);
        listHash.put(listDataHeader.get(4),ud);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                final String selected = (String) listAdapter.getChild(
                        groupPosition, childPosition);

                // Switch case to open selected child element activity on child element selection.

                Intent intent;
                switch(selected){
                    case "Click here to learn more":
                        intent = new Intent(should_do.this, whatPrepare.class);
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
