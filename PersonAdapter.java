package com.example.jyw.samplelist_practice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.jyw.samplelist_practice.data.Person;
import com.example.jyw.samplelist_practice.widget.PersonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JYW on 2016-07-17.
 */
public class PersonAdapter extends BaseAdapter implements PersonView.OnImageClickListener {
    List<Person> items = new ArrayList<>();

    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    public void addAll(List<Person> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        PersonView view;
        if (convertView == null) {
            view = new PersonView(viewGroup.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (PersonView) convertView;
        }
        view.setPerson(items.get(i));
        return view;
    }

    public interface OnAdapterImageClickListener {
        public void onAdapterImageClick(PersonAdapter adapter, PersonView view, Person person);
    }

    OnAdapterImageClickListener mAdapterListener;
    public void setOnAdapterImageClickListener(OnAdapterImageClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(PersonView view, Person person) {
        mAdapterListener.onAdapterImageClick(this, view, person);
    }
}
