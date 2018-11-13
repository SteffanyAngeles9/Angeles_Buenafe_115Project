package com.example.gerrybuenafe.angeles_buenafe_115;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class whatPrepare extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTitle;
    CardView mCardView;
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_prepare);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        mLinearLayout = findViewById(R.id.linear);

        mLinearLayout.setVisibility(View.GONE);

        setSupportActionBar(mToolbar);
        mTitle.setText("WHAT TO PREPARE");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


    }
    public void toggle_contents(View v){
        if(mLinearLayout.isShown()){
            Fx.slide_up(this, mLinearLayout);
            mLinearLayout.setVisibility(View.GONE);
        }
        else{
            mLinearLayout.setVisibility(View.VISIBLE);
            Fx.slide_down(this, mLinearLayout);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
