package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.view.interfaces.IDetail;
import com.myapps.utils.LoggerUtils;

/**
 * Created by bernatgomez on 4/7/17.
 */

public class SearchDetailCommentsFragment extends BaseFragment implements IDetail {

    private static final String TAG = SearchDetailCommentsFragment.class.getSimpleName();

    public static SearchDetailCommentsFragment newInstance() {
        return new SearchDetailCommentsFragment();
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_detail_comments;
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
/////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////
// IMPL
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void pageWithFocus() {
        LoggerUtils.logMsg(TAG, "pageWithFocus()");
    }


}
