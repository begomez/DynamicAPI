package com.begoandapps.padelapp.view.search.result;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.view.core.BaseFragment;
import com.begoandapps.padelapp.view.search.result.interfaces.IDetail;
import com.myapps.utils.LoggerUtils;


/**
 * Created by bernatgomez on 4/7/17.
 */
public class SearchDetailInfoFragment extends BaseFragment implements IDetail {

    private static final String TAG = SearchDetailInfoFragment.class.getSimpleName();

    public static SearchDetailInfoFragment newInstance() {
        return new SearchDetailInfoFragment();
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_detail_info;
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
