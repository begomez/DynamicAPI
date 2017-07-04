package com.begoandapps.padelapp.view.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.SearchSelectionAdapter;
import com.begoandapps.padelapp.adapters.interfaces.ISelection;
import com.begoandapps.padelapp.view.core.BaseFragment;
import com.begoandapps.padelapp.view.core.interfaces.IView;
import com.myapps.utils.ValueUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchSelectionFragment extends BaseFragment implements IView {

    @BindView(R.id.search_list)
    protected RecyclerView list;

    private IResultNav callback;


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
        this.list.setAdapter(new SearchSelectionAdapter(this.getActivity(), (ISelection) this.getActivity()));
        this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        this.list.setHasFixedSize(true);
    }

    @Override
    protected void saveCallback() {
        super.saveCallback();

        if (this.getActivity() instanceof IResultNav) {
            this.callback = (IResultNav) this.getActivity();
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
///////////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.search_selection_main_btn)
    @Override
    public void onMainBtnClick(View v) {
        super.onMainBtnClick(v);

        if (ValueUtils.isValidObj(this.callback)) {
            this.callback.launchResults();
        }
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
// INTERFACE DECL
///////////////////////////////////////////////////////////////////////////////////////////////

    public interface IResultNav {
        public void launchResults();
    }

}
