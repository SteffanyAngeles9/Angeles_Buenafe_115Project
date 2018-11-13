package com.example.gerrybuenafe.angeles_buenafe_115;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class afterSafePafe extends AppCompatActivity{
    Toolbar mToolbar;
    TextView mTitle;

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_safe_pafe);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("AFTER THE FLOOD: WHAT YOU SHOULD DO?");

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


    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Wait until it is safe to return");
        listDataHeader.add("Travel with care");
        listDataHeader.add("If a building was flooded, check for safety before entering");
        listDataHeader.add("Use extreme caution when entering buildings");
        listDataHeader.add("Your home is no longer a safe place");
        listDataHeader.add("When making repairs, protect your property from future flood damage");

        List<String> safe = new ArrayList<>();
        safe.add("Do not return to flooded areas until authorities indicate it is safe to do so");
        safe.add("Do not visit disaster areas following a flood. Your presence may hamper urgent emergency response and rescue operations");

        List<String> travel = new ArrayList<>();
        travel.add("Follow recommended routes. DO NOT sightsee");
        travel.add("Watch for washed out roads, earth slides, and downed trees or power lines");
        travel.add("Stay away from downed power lines");

        List<String> bldg = new ArrayList<>();
        bldg.add("Do not enter a building if it is still flooded or surrounded by floodwater");
        bldg.add("Check for structural damage. Inspect foundations for cracks or other damage");
        bldg.add("Turn off any outside gas lines at the meter tank");
        bldg.add("Do not enter a building that has flooded until local building officials have inspected it for safety");

        List<String> caution = new ArrayList<>();
        caution.add("Wear sturdy shoes. The most common injury following a disaster is cut feet");
        caution.add("Use ONLY battery-powered lighting. Flammable material may be present");
        caution.add("Look for fire hazards (such as damaged gas lines, flooded electrical circuits, or submerged furnaces)");
        caution.add("Check for gas leaks. If you smell gas or hear a blowing or hissing noise, open a window and quickly leave the building. If possible turn off the gas at the outside main valve. Call the gas company");
        caution.add("Report broken utility lines to appropriate authorities");
        caution.add("Check for electrical system damage (sparks, broken or frayed wires, or the smell of burning insulation). Turn off the electricity at the main circuit breaker if you can reach it without stepping in water");
        caution.add("Examine walls, floors, doors, windows, and ceilings for risk of collapsing");
        caution.add("Watch out for animals that might have entered with the floodwaters");
        caution.add("Let the building air out to remove foul odors or escaping gas");


        List<String> home = new ArrayList<>();
        home.add("Throw away medicine, food, or water that had contact with floodwaters (including canned goods");
        home.add("If water is of questionable purity, boil drinking water for 10 minutes");
        home.add("Restrict children from playing in flooded areas");
        home.add("Keep windows and doors open for ventilation");
        home.add("Pump out flooded basements gradually (removing about 1/3 of the water volume each day) to avoid structural damage");
        home.add("Keep the power off until an electrician has inspected the system for safety. All electrical equipment should be checked and dried before being returned to service");
        home.add("Clean and disinfect everything that got wet");
        home.add("Service damaged sewage systems as soon as possible");

        List<String> repair = new ArrayList<>();
        repair.add("Follow local building codes");
        repair.add("Use flood-resistant materials and techniques");
        repair.add("Elevate electrical components above the potential flood height");
        repair.add("Elevate utilities (washer, dryer, furnace, and water heater) above the level of anticipated flooding");
        repair.add("Consider elevation of the entire structure");

        listHash.put(listDataHeader.get(0), safe);
        listHash.put(listDataHeader.get(1), travel);
        listHash.put(listDataHeader.get(2), bldg);
        listHash.put(listDataHeader.get(3), caution);
        listHash.put(listDataHeader.get(4), home);
        listHash.put(listDataHeader.get(5), repair);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
