package com.nkdev.budgettracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.nkdev.budgettracker.R;
import com.nkdev.budgettracker.adapter.FragmentAdapter;
import com.nkdev.budgettracker.fragment.OnboardingFragment_1;
import com.nkdev.budgettracker.fragment.OnboardingFragment_2;
import com.nkdev.budgettracker.fragment.OnboardingFragment_3;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {
    ViewPager viewPager;
    //DotsIndicator dotsIndicator ;
    PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        viewPager=findViewById(R.id.viewPager);
        pageIndicatorView=findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setAnimationType(AnimationType.THIN_WORM);

        //dotsIndicator=findViewById(R.id.dot1);
        List<Fragment> fragments= new ArrayList<>();
        fragments.add(new OnboardingFragment_1());
        fragments.add(new OnboardingFragment_2());
        fragments.add(new OnboardingFragment_3());
        FragmentAdapter onboardingAdapter=new FragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(onboardingAdapter);
    }
}