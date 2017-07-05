package com.begoandapps.padelapp.view.search;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.interfaces.ISelection;
import com.begoandapps.padelapp.navigation.NavigationUtils;
import com.begoandapps.padelapp.view.core.BaseActivity;
import com.begoandapps.padelapp.view.search.result.SearchResultDetailFragment;
import com.begoandapps.padelapp.view.search.result.SearchResultFragment;
import com.begoandapps.padelapp.view.search.SearchByDateFragment;
import com.begoandapps.padelapp.view.search.SearchByNameFragment;
import com.begoandapps.padelapp.view.search.SearchByTimeFragment;
import com.begoandapps.padelapp.view.search.SearchSelectionFragment;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchActivity extends BaseActivity implements ISelection, SearchSelectionFragment.IResultNav {

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

        NavigationUtils.launchFragment(this.getSupportFragmentManager(), SearchSelectionFragment.newInstance(), BaseActivity.CONTENT_FRAME, false);
    }

///////////////////////////////////////////////////////////////////////////////////////
// LIST INTERACTION
///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onSelected(int position, ISelection.Types types) {
        if (types == Types.SEARCH_SELECTION) {
            this.onSelectedFromSelection(position);

        } else if (types == Types.SEARCH_BY_NAME) {
            this.onSelectedFromName(position);

        } else if (types == Types.SEARCH_RESULT) {
            this.onSelectedFromResult(position);
        }
    }

    private void onSelectedFromSelection(int position) {
        switch (position) {
            case 0:
                NavigationUtils.launchFragment(this.getSupportFragmentManager(), SearchByNameFragment.newInstance(), BaseActivity.CONTENT_FRAME, true);
                break;
            case 1:
                NavigationUtils.launchFragment(this.getSupportFragmentManager(), SearchByDateFragment.newInstance(), BaseActivity.CONTENT_FRAME, true);
                break;
            case 2:
                NavigationUtils.launchFragment(this.getSupportFragmentManager(), SearchByTimeFragment.newInstance(), BaseActivity.CONTENT_FRAME, true);
                break;
            default:
                break;
        }
    }

    private void onSelectedFromName(int position) {

    }

    private void onSelectedFromResult(int position) {
        NavigationUtils.launchFragment(this.getSupportFragmentManager(), SearchResultDetailFragment.newInstance(), CONTENT_FRAME, true);
    }

///////////////////////////////////////////////////////////////////////////////////////
// NAVIGATION
///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void launchResults() {
        NavigationUtils.launchFragment(this.getSupportFragmentManager(), SearchResultFragment.newInstance(), CONTENT_FRAME, true);
    }
}