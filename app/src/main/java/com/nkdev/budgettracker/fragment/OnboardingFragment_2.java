package com.nkdev.budgettracker.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nkdev.budgettracker.MainActivity;
import com.nkdev.budgettracker.R;


public class OnboardingFragment_2 extends Fragment {
    Button BtnNext,BtnSkip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_onboarding_2, container, false);
        BtnNext=view.findViewById(R.id.id_B2_next);
        BtnSkip=view.findViewById(R.id.id_B2_skip);
        BtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perform the fragment transaction here to open the target fragment_onboarding_1
//                Fragment targetFragment = new OnboardingFragment_2();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.OnboardingFragment_3, targetFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();

            }
        });


        return view;
    }
}