package com.example.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class SecondActivity extends ListActivity implements View.OnClickListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        View v = findViewById(R.id.activity_second__back);
        v.setOnClickListener(this);

        listView = findViewById(android.R.id.list);
        ArrayList<Person> contactsArray = new ArrayList<>();

        contactsArray.add(new Person(R.drawable.item1, "George Washington"));
        contactsArray.add(new Person(R.drawable.item2, "Adams John"));
        contactsArray.add(new Person(R.drawable.item3, "Thomas Jefferson"));
        contactsArray.add(new Person(R.drawable.item4, "Martin Van Buren"));
        contactsArray.add(new Person(R.drawable.item5, "Abraham Lincoln"));
        contactsArray.add(new Person(R.drawable.item6, "Theodore Roosevelt"));
        contactsArray.add(new Person(R.drawable.item7, "John Kennedy"));
        contactsArray.add(new Person(R.drawable.item8, "Barack Obama"));

        PersonAdapter personAdapter = new PersonAdapter(this, R.layout.list_row, contactsArray);

        listView.setAdapter(personAdapter);
    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.activity_second__back) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
    }
}