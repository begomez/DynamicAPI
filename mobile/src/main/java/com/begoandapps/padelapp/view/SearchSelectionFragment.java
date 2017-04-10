package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.SearchSelectionAdapter;
import com.begoandapps.padelapp.view.interfaces.IView;

import butterknife.BindView;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchSelectionFragment extends BaseFragment implements IView {

    @BindView(R.id.search_list)
    protected RecyclerView list;

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
// ARCHITECTURE
///////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void configViews() {
        super.configViews();

        this.configureList();
    }

    private void configureList() {
        this.list.setAdapter(new SearchSelectionAdapter(this.getContext(), (ISelection) this.getActivity()));
        this.list.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        this.list.setHasFixedSize(true);
    }

///////////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
///////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onMainBtnClick(View v) {
        super.onMainBtnClick(v);

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

///////////////////////////////////////////////////////////////////////////////////////////////
// IVIEW IMPL
///////////////////////////////////////////////////////////////////////////////////////////////

    public interface ISelection {
        public void onSelected(int position);
    }

}
