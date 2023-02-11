package com.example.tasbeehapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int count=1;
    TextView text,cardTasbeehTxt,cardMinMaxCounterTxt,animation;
    AlertDialog.Builder alert;
    RecyclerView recyclerView;
    TasbeehAdapter adapter;
    ArrayList<Tasbeeh> list;
    private int index=0;
    private int counts=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        list=new ArrayList<>();
        alert = new AlertDialog.Builder(this);
        text=findViewById(R.id.counter);
        cardTasbeehTxt=findViewById(R.id.card_tasbeeh);
        cardMinMaxCounterTxt=findViewById(R.id.cardminmax);
        animation=findViewById(R.id.animation);

        cardTasbeehTxt.setText(" ");
        cardMinMaxCounterTxt.setText("Select check boxes and select  + to Start");
        text.setText("Start");

        //adding tasbeehs to recycler list
        list.add(new Tasbeeh("أَسْتَغْفِرُ اللّٰهَ\u200E",3));
        list.add(new Tasbeeh("سُبْحَانَ ٱللَّٰهِ",3));
        list.add(new Tasbeeh("ٱلْحَمْدُ لِلَّٰهِ",2));


        adapter=new TasbeehAdapter(this,list);
        LinearLayoutManager llm=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

    }

    public void increment(View view) {
        int totalSelected=adapter.getListOfSelectedTasbeeh().size();
        counts++;
        if(counts==list.get(index).getNoOfTimesTasbeeh()) {
            index++;
            counts=0;
            count=0;
        }
        if(index<totalSelected) {
            String txt=adapter.getListOfSelectedTasbeeh().get(index).getTasbeeh();
            cardTasbeehTxt.setText(txt);
            cardMinMaxCounterTxt.setText(" "+adapter.getListOfSelectedTasbeeh().get(index).getNoOfTimesTasbeeh());
            text.setText(" " + count);
            count++;
            showAnimation(txt);
        }
        else
        {    cardTasbeehTxt.setText("");
            cardMinMaxCounterTxt.setText("");
            text.setText("Completed");
            reset(null);
        }

    }
    private void showAnimation(String txt){
        animation.setVisibility(View.VISIBLE);
        animation.setText(txt);
        animation.animate().translationY(-100).alpha(0).setDuration(0600);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animation.setVisibility(View.GONE);
                animation.animate().translationY(100).alpha(1).setDuration(0001);
            }
        },0600);

    }

    public void addTasbeeh(View view) {
        LayoutInflater inflater=this.getLayoutInflater();
        View inflaterView =inflater.inflate(R.layout.add_tasbeeh_layout,null);
        alert.setView(inflaterView);

        TextInputLayout tasbeeh= inflaterView.findViewById(R.id.tasbeeh);
        TextInputLayout noOfTimes= inflaterView.findViewById(R.id.no_of_times);
        Button add=inflaterView.findViewById(R.id.btn);
        add.setOnClickListener(view1 -> {

            String tasbehText=tasbeeh.getEditText().getText().toString();
           int tasbehTimes=Integer.parseInt(noOfTimes.getEditText().getText().toString());

            adapter.addTasbeeh(new Tasbeeh(tasbehText,tasbehTimes));
        });

        alert.show();
    }

    public void reset(View view) {
        cardTasbeehTxt.setText(" ");
        cardMinMaxCounterTxt.setText("Select check boxes and select  + to Start");
        text.setText("Start");
        adapter.refreshData();
        //renew
        recyclerView.setAdapter(adapter);
        index=0;
        counts=0;
        count=0;
    }
}
