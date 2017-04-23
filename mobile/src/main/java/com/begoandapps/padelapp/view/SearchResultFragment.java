package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.SearchResultAdapter;
import com.begoandapps.padelapp.adapters.interfaces.ISelection;
import com.begoandapps.padelapp.view.interfaces.ISearchResultView;
import com.begoandapps.padelapp.view.interfaces.IView;

import butterknife.BindView;
import fake.FakeUtils;

/**
 * Created by bernatgomez on 23/4/17.
 */

public class SearchResultFragment extends BaseFragment implements ISearchResultView {

    @BindView(R.id.search_result_list)
    protected RecyclerView list;

    private SearchResultAdapter adapter;

    private ISelection callback;

/////////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////////

    public static SearchResultFragment newInstance() {
        return new SearchResultFragment();
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_result;
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
/////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    protected void saveCallback() {
        super.saveCallback();

        if (this.getActivity() instanceof ISelection) {
            this.callback = (ISelection) this.getActivity();
        }
    }

    @Override
    public void configViews() {
        super.configViews();

        this.configList();
    }

    private void configList() {
        this.adapter = new SearchResultAdapter(this.getActivity(), this.callback, FakeUtils.getFakeClubs());

        this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));

        this.list.setHasFixedSize(false);

        this.list.setAdapter(this.adapter);

        this.adapter.notifyDataSetChanged();
    }


/////////////////////////////////////////////////////////////////////////////////////////////
// IMPL
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
