package com.nkdev.budgettracker.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nkdev.budgettracker.MainActivity;
import com.nkdev.budgettracker.R;
import com.nkdev.budgettracker.activities.LoginActivity;


public class OnboardingFragment_1 extends Fragment {
    Button  BtnNext,BtnSkip;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_onboarding_1, container, false);
        BtnNext=view.findViewById(R.id.id_B1_next);
        BtnSkip=view.findViewById(R.id.id_B1_skip);
        OnboardingFragment_1 fragment1=new OnboardingFragment_1();
        BtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the target activity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //loadFragment(fragment1);
            }
        });



        return view;
    }
    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.OnboardingFragment_2, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}