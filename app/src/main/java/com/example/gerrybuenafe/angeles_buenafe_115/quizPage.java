package com.example.gerrybuenafe.angeles_buenafe_115;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quizPage extends AppCompatActivity {
    Button mButton;
    Dialog mDialog;
    Toolbar mToolbar;
    TextView mTextView, mTitle;
    ImageView mImageView;
    RadioGroup mRadioGroup;
    RadioButton mRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        mToolbar = findViewById(R.id.toolB);
        mTitle = mToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(mToolbar);
        mTitle.setText("TEST YOUR KNOWLEDGE");

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (quizPage.this, categoryPage.class);
                startActivity(intent);
            }
        });

        mDialog = new Dialog(this);
        mRadioGroup = findViewById(R.id.radioGrp);

        mButton = findViewById(R.id.quizBtn);

        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int radioId = mRadioGroup.getCheckedRadioButtonId();
                mRadioButton = findViewById(radioId);
                final String ans = mRadioButton.getText().toString();
                String correctAns = "Choice 3";
                showDialogBox(ans, correctAns);
            }
        });
    }

    public void showDialogBox(String ans, String correctAns){
        mDialog.setContentView(R.layout.custom_dialog);

        mButton = mDialog.findViewById(R.id.ok);
        mTextView = mDialog.findViewById(R.id.yourAns);
        mTextView.setText("Your Answer: " + ans);
        mTextView = mDialog.findViewById(R.id.correctAns);
        mTextView.setText("Correct Answer : " + correctAns);
        mTextView = mDialog.findViewById(R.id.Compare);
        mImageView = mDialog.findViewById(R.id.checkWrong);
        if(correctAns.equalsIgnoreCase(ans)){
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.check));
            mTextView.setText("Correct Answer!!");
        }else {
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.ex));
            mTextView.setText("Wrong Answer!!");
        }
        mImageView = mDialog.findViewById(R.id.close);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();

    }
}