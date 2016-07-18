package com.example.jyw.samplelist_practice.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jyw.samplelist_practice.R;
import com.example.jyw.samplelist_practice.data.Person;

/**
 * Created by JYW on 2016-07-17.
 */
public class PersonView extends FrameLayout {

    public PersonView(Context context) {
        this(context, null);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    ImageView photoView;
    TextView nameView, ageView;

    public interface OnImageClickListener {
        public void onImageClick(PersonView view, Person person);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener (OnImageClickListener listener) {
        mListener = listener;
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.view_person, this);
        photoView = (ImageView) findViewById(R.id.image_photo);
        nameView = (TextView) findViewById(R.id.text_name);
        ageView = (TextView) findViewById(R.id.text_age);
        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClick(PersonView.this, person);
            }
        });

        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.PersonView);
            String name = ta.getString(R.styleable.PersonView_my_name);
            Person p = new Person();
            if (!TextUtils.isEmpty(name)) {
                nameView.setText(name);
                p.setName(name);
                person = p;
            }
            int age = ta.getInt(R.styleable.PersonView_my_age, -1);
            if (age != -1) {
                ageView.setText("" + age);
                p.setAge(age);
                person = p;
            }
            Drawable d = ta.getDrawable(R.styleable.PersonView_my_photo);
            if (d != null) {
                photoView.setImageDrawable(d);
                p.setPicture(d);
                person = p;
            }
            ta.recycle();
        }
    }

    Person person;
    public void setPerson(Person person) {
        this.person = person;
        nameView.setText(person.getName());
        ageView.setText("" + person.getAge());
        photoView.setImageDrawable(person.getPicture());
    }

    public Person getPerson() {
        return person;
    }
}
