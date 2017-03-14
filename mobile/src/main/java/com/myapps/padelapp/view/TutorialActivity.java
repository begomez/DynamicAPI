package com.myapps.padelapp.view;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import com.myapps.padelapp.R;
import com.myapps.padelapp.adapters.TutorialAdapter;
import com.myapps.padelapp.navigation.INavigation;
import com.myapps.padelapp.navigation.NavigationUtis;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;

public class TutorialActivity extends BaseActivity {

    @BindView(R.id.content_pager)
    protected ViewPager contentPager;

    @BindView(R.id.content_pager_indicator)
    CirclePageIndicator contentPagerIndicator;

    protected TutorialAdapter contentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_tutorial;

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectViews() {
        super.injectViews();

        //this.contentPager = (ViewPager) this.findViewById(R.id.content_pager);

    }

    @Override
    protected void configViews() {
        this.contentAdapter = new TutorialAdapter(this.getSupportFragmentManager(), this);

        this.contentPager.setAdapter(this.contentAdapter);

        this.contentPagerIndicator.setViewPager(this.contentPager);
    }

/////////////////////////////////////////////////////////////////////////////////////////
// NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public INavigation getNavigationCmd() {
        super.getNavigationCmd();

        return new INavigation() {
            @Override
            public void navigate() {
                NavigationUtis.navigateToActivity(TutorialActivity.this, LoginActivity.class);
            }
        };
    }
}
