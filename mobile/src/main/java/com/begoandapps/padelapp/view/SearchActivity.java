package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.navigation.NavigationUtils;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchActivity extends BaseActivity {

///////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
///////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_search;

        super.onCreate(savedInstanceState);
    }

///////////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
///////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void launchContentFragment() {
        super.launchContentFragment();

        NavigationUtils.launchFragment(this.getSupportFragmentManager(), SearchSelectionFragment.newInstance(), BaseActivity.CONTENT_FRAME, true);
    }
}
