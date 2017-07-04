package com.begoandapps.padelapp.view.tutorial;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.TutorialAdapter;
import com.begoandapps.padelapp.navigation.interfaces.INavigation;
import com.begoandapps.padelapp.navigation.NavigationUtils;
import com.begoandapps.padelapp.view.core.BaseActivity;
import com.begoandapps.padelapp.view.enroll.RegisterActivity;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;

public class TutorialActivity extends BaseActivity {

    @BindView(R.id.content_pager)
    protected ViewPager contentPager;

    @BindView(R.id.content_pager_indicator)
    CirclePageIndicator contentPagerIndicator;

    protected TutorialAdapter contentAdapter;


//////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_tutorial;

        super.onCreate(savedInstanceState);
    }

//////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void configViews() {
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
                NavigationUtils.navigateToActivity(TutorialActivity.this, RegisterActivity.class);
            }
        };
    }
}
