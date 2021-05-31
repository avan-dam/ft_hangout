package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText ContactFirstNameEdt, ContactLastNameEdt, ContactEmailEdt, ContactPhoneEdt, ContactAddressEdt;
    private Button addContactBtn, readContactBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        ContactFirstNameEdt = findViewById(R.id.etFirstName);
        ContactLastNameEdt = findViewById(R.id.etLastName);
        ContactEmailEdt = findViewById(R.id.etEmail);
        ContactPhoneEdt = findViewById(R.id.etPhone);
        ContactAddressEdt = findViewById(R.id.etAddress);
        addContactBtn = findViewById(R.id.idaddContactBtn);
        readContactBtn = findViewById(R.id.idreadContactBtn);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String ContactFirstName = ContactFirstNameEdt.getText().toString();
                String ContactLastName = ContactLastNameEdt.getText().toString();
                String ContactEmail = ContactEmailEdt.getText().toString();
                String ContactPhone = ContactPhoneEdt.getText().toString();
                String ContactAddress = ContactAddressEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (ContactFirstName.isEmpty() && ContactLastName.isEmpty() && ContactEmail.isEmpty() && ContactPhone.isEmpty() && ContactAddress.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewContact(ContactFirstName, ContactLastName, ContactEmail, ContactPhone, ContactAddress);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                ContactFirstNameEdt.setText("");
                ContactLastNameEdt.setText("");
                ContactEmailEdt.setText("");
                ContactPhoneEdt.setText("");
                ContactAddressEdt.setText("");
            }
        });

        readContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewContacts.class);
                startActivity(i);
            }
        });
    }
}
//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}