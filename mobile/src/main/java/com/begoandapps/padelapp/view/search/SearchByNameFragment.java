package com.begoandapps.padelapp.view.search;

import android.app.SearchManager;
import android.app.Service;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.SearchByNameAdapter;
import com.begoandapps.padelapp.adapters.interfaces.ISelection;
import com.begoandapps.padelapp.dependencies.components.DaggerSearchComponent;
import com.begoandapps.padelapp.dependencies.modules.SearchModule;
import com.begoandapps.padelapp.presenter.SearchByNamePresenter;
import com.begoandapps.padelapp.view.core.BaseFragment;
import com.begoandapps.padelapp.view.search.interfaces.ISearchByNameView;
import com.myapps.data.PlaceModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by bernatgomez on 11/4/17.
 */

public class SearchByNameFragment extends BaseFragment implements ISearchByNameView {

    private SearchView searchView;

    @BindView(R.id.search_by_name_list)
    protected RecyclerView resultList;

    private SearchByNameAdapter adapter;

    @Inject
    protected SearchByNamePresenter presenter;


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

        this.setHasOptionsMenu(true);

        this.layoutId = R.layout.fragment_search_by_name;
    }

    @Override
    public void onStart() {
        super.onStart();

        this.presenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();

        this.presenter.stop();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.search_by_name, menu);

        SearchManager mgr = (SearchManager) this.getContext().getSystemService(Service.SEARCH_SERVICE);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        searchView.setSearchableInfo(mgr.getSearchableInfo(this.getActivity().getComponentName()));

        searchView.setSubmitButtonEnabled(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.setVisibility(View.GONE);

                getActivity().invalidateOptionsMenu();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        this.searchView = searchView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

////////////////////////////////////////////////////////////////////////////////////
// ARCH
////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void configViews() {
        super.configViews();

        this.configList();
    }

    private void configList() {
        this.resultList.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        this.resultList.setHasFixedSize(false);
    }

    @Override
    protected void bindPresentersAndViews() {
        super.bindPresentersAndViews();

        this.presenter.attachView(this);
    }

    @Override
    protected void retrieveData() {
        super.retrieveData();

        this.presenter.getPlaces("");
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();

        DaggerSearchComponent.builder().applicationComponent(this.getApplicationComponent()).searchModule(new SearchModule()).build().inject(this);
    }

////////////////////////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onListSuccess(List<PlaceModel> list) {
        this.adapter = new SearchByNameAdapter(this.getContext(), (ISelection) this.getActivity(), list);

        this.resultList.setAdapter(this.adapter);

        this.adapter.notifyDataSetChanged();
    }
}
