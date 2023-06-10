package com.nkdev.budgettracker.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nkdev.budgettracker.MainActivity;
import com.nkdev.budgettracker.R;


public class OnboardingFragment_3 extends Fragment {
Button BtnGetstarted;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_onboarding_3, container, false);
       BtnGetstarted=view.findViewById(R.id.id_btn_getStarted);
       BtnGetstarted.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getContext(), MainActivity.class);
               startActivity(intent);
           }
       });
        return view;
    }
}