package com.example.gerrybuenafe.angeles_buenafe_115;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class causesFlood extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTitle;
    CardView mCardView;
    Button mButton;
    Dialog mDialog;
    TextView mTextView;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_causes_flood);

        mDialog = new Dialog(this);

        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("CAUSES OF FLOOD");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mCardView = findViewById(R.id.cardview1);
        mCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String desc ="Each time there are more rains than the drainage system can take, there can be floods. Sometimes, there is heavy rain for a very short period that result in floods. In other times, there may be light rain for many days and weeks and can also result in floods.";
                String image= "heavyrain";
                String title= "Heavy Rain";
                showDialogBox(desc,image,title);
            }
        });

        mCardView = findViewById(R.id.cardview2);
        mCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String desc = "Rivers or streams can overflow their banks. This happens when the river or stream holds more water upstream than usual, and it flows downstream to the neighboring low-lying areas, typically referred to as the floodplains.  As a consequence, this creates a sudden discharge of water into the adjacent lands leading to flooding.";
                String image= "overflowingriver";
                String title= "Overflowing River";
                showDialogBox(desc,image,title);
            }
        });

        mCardView = findViewById(R.id.cardview4);
        mCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String desc = "Dams are man-made structures used to hold water from flowing down from a raised ground. The potential energy stored in the dam water is used to generate electricity. At times, the walls can become weak and break because of overwhelming carriage capacity. Due to this reason, breakage of the dam can cause extensive flooding in the adjacent areas.";
                String image= "dambreakage";
                String title= "Dam Breakages";
                showDialogBox(desc,image,title);
            }
        });

        mCardView = findViewById(R.id.cardview3);
        mCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String desc = "Flooding also takes place when snowmelt or rainfall runoff cannot be channeled appropriately into the drainage systems forcing the water to flow overland. Clogged or lack of proper drainage system is usually the cause of this type of flooding. The areas remain flooded until the stormwater systems or waterways are rectified. The areas remain flooded until the excess water evaporates";
                String image= "cloggeddrainage";
                String title= "Clogged Drainage";
                showDialogBox(desc,image,title);
            }
        });
    }

    public void showDialogBox(String desc, String image, String title){
        mDialog.setContentView(R.layout.dialog_causes_flood);
        mButton = mDialog.findViewById(R.id.ok);
        mImageView = mDialog.findViewById(R.id.image);
        int resID = getResources().getIdentifier(image, "drawable", getPackageName());
        mImageView.setImageResource(resID);
        mTextView = mDialog.findViewById(R.id.title);
        mTextView.setText(title);
        mTextView = mDialog.findViewById(R.id.description);
        mTextView.setText(desc);
        mImageView = mDialog.findViewById(R.id.close);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();


        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDialog.dismiss();
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