package com.example.gerrybuenafe.angeles_buenafe_115;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class categoryPage extends AppCompatActivity {
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        mToolbar = findViewById(R.id.toolB);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        int redActionButtonSize = getResources().getDimensionPixelSize(R.dimen.red_action_button_size);
        int redActionButtonMargin = getResources().getDimensionPixelOffset(R.dimen.action_button_margin);
        int redActionMenuRadius = getResources().getDimensionPixelSize(R.dimen.red_action_menu_radius);
        int blueSubActionButtonSize = getResources().getDimensionPixelSize(R.dimen.blue_sub_action_button_size);

        ImageView fabIconStar = new ImageView(this);
        fabIconStar.setImageDrawable(getResources().getDrawable(R.drawable.logo));

        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(redActionButtonSize, redActionButtonSize);
        starParams.setMargins(redActionButtonMargin,
                redActionButtonMargin,
                redActionButtonMargin,
                redActionButtonMargin);
        fabIconStar.setLayoutParams(starParams);

        final FloatingActionButton leftCenterButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconStar)
                .setPosition(FloatingActionButton.POSITION_LEFT_CENTER)
                .setLayoutParams(starParams)
                .build();

        SubActionButton.Builder lCSubBuilder = new SubActionButton.Builder(this);

        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(blueSubActionButtonSize, blueSubActionButtonSize);
        lCSubBuilder.setLayoutParams(blueParams);

        ImageView explainBtn = new ImageView(this);
        ImageView beforeBtn = new ImageView(this);
        ImageView duringBtn = new ImageView(this);
        ImageView afterBtn = new ImageView(this);
        ImageView quizBtn = new ImageView(this);

        explainBtn.setImageDrawable(getResources().getDrawable(R.drawable.explain));
        beforeBtn.setImageDrawable(getResources().getDrawable(R.drawable.before));
        duringBtn.setImageDrawable(getResources().getDrawable(R.drawable.during));
        afterBtn.setImageDrawable(getResources().getDrawable(R.drawable.after));
        quizBtn.setImageDrawable(getResources().getDrawable(R.drawable.quiz));

        final FloatingActionMenu leftCenterMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(lCSubBuilder.setContentView(quizBtn).build())
                .addSubActionView(lCSubBuilder.setContentView(afterBtn).build())
                .addSubActionView(lCSubBuilder.setContentView(duringBtn).build())
                .addSubActionView(lCSubBuilder.setContentView(beforeBtn).build())
                .addSubActionView(lCSubBuilder.setContentView(explainBtn).build())
                .setRadius(redActionMenuRadius)
                .setStartAngle(70)
                .setEndAngle(-70)
                .attachTo(leftCenterButton)
                .build();


        explainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftCenterMenu.close(true);
                Intent i = new Intent(categoryPage.this, explainPage.class);
                categoryPage.this.startActivity(i);
            }

        });
        beforeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftCenterMenu.close(true);
                Intent i = new Intent(categoryPage.this, beforePage.class);
                categoryPage.this.startActivity(i);
            }

        });
        duringBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftCenterMenu.close(true);
                Intent i = new Intent(categoryPage.this, duringPage.class);
                categoryPage.this.startActivity(i);
            }

        });
        afterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftCenterMenu.close(true);
                Intent i = new Intent(categoryPage.this, afterPage.class);
                categoryPage.this.startActivity(i);
            }

        });
       quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftCenterMenu.close(true);
                Intent i = new Intent(categoryPage.this, quizPage.class);
                categoryPage.this.startActivity(i);
            }

        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                leftCenterButton.performClick();
            }
        }, 100);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}