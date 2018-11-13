package com.example.gerrybuenafe.angeles_buenafe_115;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class explainPage extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTitle;
    ListView listview;
    int images [] = {R.drawable.arrow,
                    R.drawable.arrow,
                    R.drawable.arrow,
                    R.drawable.arrow};

    String category[] = {"What is a flood?", "Causes of flood" , "Types of flood", "Effects of flood"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain_page);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("EXPLAIN");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (explainPage.this, categoryPage.class);
                startActivity(intent);
            }
        });
        listview = findViewById(R.id.list);

        MyAdapter myAdapter = new MyAdapter(this,category,images);

        listview.setAdapter(myAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent (explainPage.this, whatPage.class);
                    intent.putExtra("Category", listview.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent (explainPage.this, causesFlood.class);
                    intent.putExtra("Category", listview.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent (explainPage.this, typesFlood.class);
                    intent.putExtra("Category", listview.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent (explainPage.this, effectsFlood.class);
                    intent.putExtra("Category", listview.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context mContext;
        String mCategory [];
        int mImage [];

        MyAdapter(Context c, String category[], int images[]){
            super(c,R.layout.activity_custome_layout, R.id.textView, category);
            this.mContext=c;
            this.mCategory=category;
            this.mImage=images;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.activity_custome_layout, parent, false);
            ImageView image = row.findViewById(R.id.imageView9);
            TextView myCategory = row.findViewById(R.id.textView);
            image.setImageResource(images[position]);
            myCategory.setText(category[position]);
            return row;

        }
    }
            @Override
            public boolean onOptionsItemSelected(MenuItem item){
                if(item.getItemId()==android.R.id.home)
                    finish();
                return super.onOptionsItemSelected(item);
            }
}
