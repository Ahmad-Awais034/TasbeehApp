package com.example.tasbeehapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class TasbeehAdapter extends RecyclerView.Adapter<TasbeehAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Tasbeeh> list;

    public TasbeehAdapter(Context context, ArrayList<Tasbeeh> list) {
        this.context = context;
        this.list = list;
    }
    public void addTasbeeh(Tasbeeh tasbeeh){
    list.add(tasbeeh);
    this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TasbeehAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tasbeeh_recycler_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasbeehAdapter.ViewHolder holder, int position) {
    holder.text.setText(list.get(position).getTasbeeh());
    holder.limit.getEditText().setText(""+list.get(position).getNoOfTimesTasbeeh());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox text;
        TextInputLayout limit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text= itemView.findViewById(R.id.checkbox_tasbeeh);
            limit= itemView.findViewById(R.id.no_of_times_recycler_design);
        }
    }
}