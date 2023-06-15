 package com.nkdev.budgettracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nkdev.budgettracker.R;
import com.nkdev.budgettracker.adapter.ItemAdapter;

import java.util.ArrayList;

 public class Dashboardctivity extends AppCompatActivity {
     RecyclerView recyclerView1;
     LinearLayoutManager layoutManager;
     ItemAdapter itemAdapter;
     ArrayList<String> datasource;
     int [] IdImage={R.drawable.ic_bookmark,R.drawable.ic_reminder,R.drawable.ic_budget};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardctivity);
        recyclerView1=findViewById(R.id.id_horizontal_RV);
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