package com.acadgild.balu.acd_an_session_5_assignment_3_main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> array_courses = new ArrayList<String>();
    ArrayList<String> array_trainers = new ArrayList<String>();
    ArrayAdapter<String> adapter_courses;
    ListView lv_courses;
    TextView tv_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_courses = (TextView) findViewById(R.id.textView_list_of_courses);
        lv_courses = (ListView) findViewById(R.id.listView_courses);

        array_courses.add(getResources().getString(R.string.string_android_course));
        array_courses.add(getResources().getString(R.string.string_bigdata_course));
        array_courses.add(getResources().getString(R.string.string_cloud_course));
        array_courses.add(getResources().getString(R.string.string_digital_course));
        array_courses.add(getResources().getString(R.string.string_java_course));
        array_courses.add(getResources().getString(R.string.string_web_course));


        array_trainers.add(getResources().getString(R.string.string_android_trainer));
        array_trainers.add(getResources().getString(R.string.string_bigdata_trainer));
        array_trainers.add(getResources().getString(R.string.string_cloud_trainer));
        array_trainers.add(getResources().getString(R.string.string_digital_trainer));
        array_trainers.add(getResources().getString(R.string.string_java_trainer));
        array_trainers.add(getResources().getString(R.string.string_web_trainer));

        adapter_courses = new ArrayAdapter<String>(getApplicationContext(),R.layout.course_text,
                                                    R.id.textView_courses, array_courses);
        lv_courses.setAdapter(adapter_courses);
        lv_courses.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String string_course = (String) lv_courses.getItemAtPosition(position);
        Intent intent_course = new Intent(getApplicationContext(), Trainer.class);

        String string_output = String.format(getResources().getString(R.string.output_string),
                                             string_course,array_trainers.get(position));
        intent_course.putExtra("OUTPUT", string_output);

        Bundle bundle_course = new Bundle();
        bundle_course.putInt("TEXTSIZE", 25);
        intent_course.putExtras(bundle_course);

        startActivity(intent_course);
    }
}
