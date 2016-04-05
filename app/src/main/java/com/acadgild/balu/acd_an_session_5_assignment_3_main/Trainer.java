package com.acadgild.balu.acd_an_session_5_assignment_3_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Trainer extends AppCompatActivity
{
    TextView tv_course_trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        tv_course_trainer = (TextView) findViewById(R.id.textView_course_trainer);
        tv_course_trainer.setText(getIntent().getStringExtra("OUTPUT"));

        Bundle bundle_course = getIntent().getExtras();
        tv_course_trainer.setTextSize(bundle_course.getInt("TEXTSIZE"));
    }
}
