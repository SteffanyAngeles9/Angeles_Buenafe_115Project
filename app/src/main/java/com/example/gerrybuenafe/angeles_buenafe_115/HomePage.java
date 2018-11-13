package com.example.gerrybuenafe.angeles_buenafe_115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

    }
    public void process(View v) {
        Intent i = null, chooser = null;
        if (v.getId() == R.id.button) {
            i = new Intent(this, categoryPage.class);
            startActivity(i);
        } else if (v.getId() == R.id.button2) {
            i = new Intent(this, aboutPage.class);
            startActivity(i);
        }
    }
}
