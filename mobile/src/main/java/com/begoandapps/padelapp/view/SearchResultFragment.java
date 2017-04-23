package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.SearchResultAdapter;
import com.begoandapps.padelapp.adapters.interfaces.ISelection;
import com.begoandapps.padelapp.dependencies.components.DaggerSearchComponent;
import com.begoandapps.padelapp.dependencies.modules.SearchModule;
import com.begoandapps.padelapp.presenter.SearchResultPresenter;
import com.begoandapps.padelapp.view.interfaces.ISearchResultView;
import com.myapps.data.PadelClub;

import java.util.ArrayList;

import javax.inject.Inject;

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

    @Inject
    protected SearchResultPresenter presenter;


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

        this.configureList();
    }

    private void configureList() {
        this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));

        this.list.setHasFixedSize(false);
    }

    @Override
    protected void retrieveData() {
        super.retrieveData();

        this.presenter.getClubs();
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();

        DaggerSearchComponent.builder().applicationComponent(this.getApplicationComponent()).searchModule(new SearchModule()).build().inject(this);
    }

    @Override
    protected void bindPresentersAndViews() {
        super.bindPresentersAndViews();

        this.presenter.attachView(this);
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

/////////////////////////////////////////////////////////////////////////////////////////////
// IMPL
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onDataReceived(ArrayList<PadelClub> data) {
        this.prepareAdapter();
    }

    private void prepareAdapter() {
        this.adapter = new SearchResultAdapter(this.getActivity(), this.callback, FakeUtils.getFakeClubs());

        this.adapter.notifyDataSetChanged();

        this.list.setAdapter(this.adapter);
    }

}
