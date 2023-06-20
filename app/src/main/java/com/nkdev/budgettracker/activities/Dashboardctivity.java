 package com.nkdev.budgettracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.nkdev.budgettracker.R;
import com.nkdev.budgettracker.adapter.ItemAdapter;

import java.util.ArrayList;

 public class Dashboardctivity extends AppCompatActivity {
     RecyclerView recyclerView1,recyclerView2;
     LinearLayoutManager layoutManager;
     ItemAdapter itemAdapter;
     ArrayList<String> datasource;
     ImageButton BtnMore;
     int [] IdImage={R.drawable.ic_bookmark,R.drawable.ic_reminder,R.drawable.ic_budget};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardctivity);
        recyclerView1=findViewById(R.id.id_horizontal_RV);
        recyclerView2=findViewById(R.id.id_vertical_RV);
        BtnMore=findViewById(R.id.id_btn_more);
        BtnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Dashboardctivity.this,EntriesActivity.class));
            }
        });
        datasource=new ArrayList<String>();
        datasource.add("Savings");
        datasource.add("Reminders");
        datasource.add("Budgets");
        layoutManager=new LinearLayoutManager(Dashboardctivity.this,LinearLayoutManager.HORIZONTAL,false);
        itemAdapter= new ItemAdapter(this,datasource,IdImage);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(itemAdapter);

    }
}