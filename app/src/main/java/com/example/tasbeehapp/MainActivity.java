package com.example.tasbeehapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count=1;
    TextView text;
    AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alert = new AlertDialog.Builder(this);
        text=findViewById(R.id.counter);

    }

    public void increment(View view) {
        text.setText(" "+count);
        count++;

    }

    public void addTasbeeh(View view) {
        LayoutInflater inflater=this.getLayoutInflater();
        View inflaterView =inflater.inflate(R.layout.add_tasbeeh_layout,null);
        alert.setView(inflaterView);
        alert.show();
    }
}