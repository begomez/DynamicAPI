package com.begoandapps.padelapp.view.dashboard;


import android.support.annotation.Nullable;
import android.os.Bundle;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppTabBar;
import com.begoandapps.padelapp.navigation.NavigationUtils;
import com.begoandapps.padelapp.navigation.interfaces.INavigation;
import com.begoandapps.padelapp.utils.MessageUtils;
import com.begoandapps.padelapp.view.search.SearchActivity;
import com.begoandapps.padelapp.view.core.BaseActivity;
import com.begoandapps.padelapp.view.interfaces.ITabBar;

import butterknife.BindView;


/**
 *
 */
public class PadelActivity
    extends BaseActivity
    implements ITabBar {

    @Nullable
    @BindView(R.id.tab_bar)
    protected AppTabBar tabBar;


//////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_padel;

        super.onCreate(savedInstanceState);

    }

//////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void launchContentFragment() {
        super.launchContentFragment();

        NavigationUtils.launchFragment(this.getSupportFragmentManager(), NoReservationFragment.newInstance(), BaseActivity.CONTENT_FRAME,  false);
    }

    @Override
    public void configViews() {
        super.configViews();

        this.configTabBar();
    }

    private void configTabBar() {
        if (this.tabBar != null) {
            this.tabBar.setCallback(this);
        }
    }

//////////////////////////////////////////////////////////////////////////////////
// ITABBAR IMPL
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onGeoClick() {
        MessageUtils.showToast(this, "Geo");
    }

    @Override
    public void onSearchClick() {
        new INavigation() {
            @Override
            public void navigate() {
                NavigationUtils.navigateToActivity(PadelActivity.this, SearchActivity.class);
            }
        }.navigate();

    }

    @Override
    public void onProfileClick() {
        MessageUtils.showToast(this, "Profile");
    }
}
