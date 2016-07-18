package com.example.jyw.samplelist_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChoiceListActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_list);
        listView = (ListView)findViewById(R.id.listView2);
//        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setAdapter(mAdapter);

        Button btn = (Button)findViewById(R.id.btn_delete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
                    int position = listView.getCheckedItemPosition();
                    String text = (String) listView.getItemAtPosition(position);
                    mAdapter.remove(text);
                } else if(listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
                    SparseBooleanArray array = listView.getCheckedItemPositions();
                    List<String> removeList = new ArrayList<String>();
                    for (int index = 0; index < array.size(); index++) {
                        int position = array.keyAt(index);
                        if (array.get(position)) {
                            String text = (String)listView.getItemAtPosition(position);
                            removeList.add(text);
                        }
                    }
                    for (String s : removeList) {
                        mAdapter.remove(s);
                    }
                    listView.clearChoices();
                }
            }
        });

        initData();

        listView.setItemChecked(2, true);
    }

    private void initData() {
        mAdapter.addAll(getResources().getStringArray(R.array.items));
    }
}
