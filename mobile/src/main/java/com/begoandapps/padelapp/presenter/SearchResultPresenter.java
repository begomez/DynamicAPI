package com.begoandapps.padelapp.presenter;

import com.begoandapps.padel.usecases.results.SearchResultUseCase;
import com.begoandapps.padel.usecases.results.SearchResultsUseCaseImpl;
import com.begoandapps.padelapp.view.interfaces.ISearchResultView;
import com.myapps.data.PadelClub;
import com.myapps.forms.SearchResultForm;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import apimodels.ApiErrorModel;

/**
 * Created by bernatgomez on 23/4/17.
 */

public class SearchResultPresenter extends BasePresenter<ISearchResultView> {

    protected SearchResultUseCase usecase;


/////////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////////

    public SearchResultPresenter(Bus bus, SearchResultUseCase usecase) {
        super(bus);

        this.usecase = usecase;
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// API
/////////////////////////////////////////////////////////////////////////////////////////////

    public void getClubs() {
        SearchResultForm form = new SearchResultForm();

        this.getView().showLoading();

        this.usecase.getClubs(form);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// SUSCRIPTIONS
/////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onSuccess(ArrayList<PadelClub> data) {
        this.getView().hideLoading();

        this.getView().onDataReceived(data);
    }

    @Subscribe
    public void onError(ApiErrorModel error) {
        this.getView().hideLoading();

        this.manageError(error);
    }
}
