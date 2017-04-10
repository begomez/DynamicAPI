package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.view.interfaces.IView;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchSelectionFragment extends BaseFragment implements IView {

///////////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
///////////////////////////////////////////////////////////////////////////////////////////////

    public static SearchSelectionFragment newInstance() {
        SearchSelectionFragment f = new SearchSelectionFragment();

        return f;
    }

///////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
///////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_selection;
    }

///////////////////////////////////////////////////////////////////////////////////////////////
// IVIEW IMPL
///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
