package com.example.jyw.samplelist_practice;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jyw.samplelist_practice.data.Person;
import com.example.jyw.samplelist_practice.widget.PersonView;

public class MainActivity extends AppCompatActivity {

    PersonView personView;
    ImageView pictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureView = (ImageView) findViewById(R.id.image_picture);
        pictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pictureView.setVisibility(View.GONE);
            }
        });

        personView = (PersonView) findViewById(R.id.view_person);
        personView.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, Person person) {
                pictureView.setImageDrawable(person.getPicture());
                pictureView.setVisibility(View.VISIBLE);
            }
        });

        initData();
    }

    private void initData() {
        Drawable photo = ContextCompat.getDrawable(this, R.drawable.sample_0);
        Person p = new Person("jyw", 29, photo);
        personView.setPerson(p);
    }
}
