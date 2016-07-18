package com.example.jyw.samplelist_practice;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jyw.samplelist_practice.data.Person;
import com.example.jyw.samplelist_practice.widget.PersonView;

import java.util.Random;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter mAdapter;
    ImageView pictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = (ListView)findViewById(R.id.listView3);
        pictureView = (ImageView) findViewById(R.id.image_picture);
        pictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pictureView.setVisibility(View.GONE);
            }
        });
        mAdapter = new PersonAdapter();
        mAdapter.setOnAdapterImageClickListener(new PersonAdapter.OnAdapterImageClickListener() {
            @Override
            public void onAdapterImageClick(PersonAdapter adapter, PersonView view, Person person) {
                pictureView.setImageDrawable(person.getPicture());
                pictureView.setVisibility(View.VISIBLE);
            }
        });
        listView.setAdapter(mAdapter);
        initData();
    }

    int[] resIds = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3,R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7};

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i ++) {
            Person p = new Person();
            p.setName("name" + i);
            p.setAge(20 + r.nextInt(30));
            p.setPicture(ContextCompat.getDrawable(this, resIds[i % resIds.length]));
            mAdapter.add(p);
        }
    }
}
