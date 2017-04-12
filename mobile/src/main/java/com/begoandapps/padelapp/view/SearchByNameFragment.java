package com.begoandapps.padelapp.view;

import android.app.SearchManager;
import android.app.Service;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begoandapps.padelapp.R;

/**
 * Created by bernatgomez on 11/4/17.
 */

public class SearchByNameFragment extends BaseFragment {

////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
////////////////////////////////////////////////////////////////////////////////////

    public static SearchByNameFragment newInstance() {
        SearchByNameFragment f = new SearchByNameFragment();

        return f;
    }

////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_by_name;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_by_name, menu);

        SearchManager mgr = (SearchManager) this.getContext().getSystemService(Service.SEARCH_SERVICE);

        SearchView sv = (SearchView) menu.findItem(R.id.menu_search).getActionView();

        super.onCreateOptionsMenu(menu, inflater);


    }
}
