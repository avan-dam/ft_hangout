package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewContacts extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<ContactModal> contactModalArrayList;
    private DBHandler dbHandler;
    private ContactRVAdapter contactRVAdapter;
    private RecyclerView contactsRV;
    private Button gotoaddContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);
        gotoaddContactBtn = findViewById(R.id.idgotoaddContactBtn);

        // initializing our all variables.
        contactModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewContacts.this);
        // getting our contact array
        // list from db handler class.
        contactModalArrayList = dbHandler.readContacts();

        // on below line passing our array lost to our adapter class.
        contactRVAdapter = new ContactRVAdapter(contactModalArrayList, ViewContacts.this);
        contactsRV = findViewById(R.id.idRVcontacts);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewContacts.this, RecyclerView.VERTICAL, false);
        contactsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        contactsRV.setAdapter(contactRVAdapter);

        gotoaddContactBtn.setOnClickListener(new View.OnClickListener() {
            //            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(ViewContacts.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
};
