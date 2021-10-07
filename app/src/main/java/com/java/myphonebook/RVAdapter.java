package com.java.myphonebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    ArrayList<Contact> list = new ArrayList<>();
    public RVAdapter(Context ctx){
        this.context = ctx;
    }
    public void setItems(ArrayList<Contact> contact){
        list.addAll(contact);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
       return new ContactVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position)
    {
        ContactVH vh = (ContactVH) holder;
        Contact contact = list.get(position);
        vh.t_name.setText(contact.getName());
        vh.t_mobile.setText(contact.getMobile());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
