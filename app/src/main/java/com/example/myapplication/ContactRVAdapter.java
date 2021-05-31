package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ContactModal> contactModalArrayList;
    private Context context;

    // constructor
    public ContactRVAdapter(ArrayList<ContactModal> contactModalArrayList, Context context) {
        this.contactModalArrayList = contactModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ContactModal modal = contactModalArrayList.get(position);
        holder.contactFirstNameTV.setText(modal.getFirstName());
        holder.contactLastNameTV.setText(modal.getLastName());
        holder.contactEmailTV.setText(modal.getEmail());
        holder.contactPhoneTV.setText(modal.getPhone());
        holder.contactAddressTV.setText(modal.getAddress());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return contactModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView contactFirstNameTV, contactLastNameTV, contactEmailTV, contactPhoneTV, contactAddressTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            contactFirstNameTV = itemView.findViewById(R.id.idTVContactFirstName);
            contactLastNameTV = itemView.findViewById(R.id.idTVContactLastName);
            contactEmailTV = itemView.findViewById(R.id.idTVContactEmail);
            contactPhoneTV = itemView.findViewById(R.id.idTVContactPhone);
            contactAddressTV = itemView.findViewById(R.id.idTVContactAddress);
        }
    }
}
