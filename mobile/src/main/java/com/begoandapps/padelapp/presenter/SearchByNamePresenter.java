package com.begoandapps.padelapp.presenter;

import com.begoandapps.padel.usecases.search.SearchByNameUseCase;
import com.begoandapps.padelapp.view.search.interfaces.ISearchByNameView;
import com.myapps.data.PlaceModel;
import com.myapps.forms.SearchForm;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import javax.inject.Inject;

import apimodels.ApiErrorModel;

/**
 * Created by bernatgomez on 22/4/17.
 */

public class SearchByNamePresenter extends BasePresenter<ISearchByNameView> {

    protected SearchByNameUseCase usecase;


////////////////////////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////////////////////////

    @Inject
    public SearchByNamePresenter(Bus bus, SearchByNameUseCase usecase) {
        super(bus);

        this.usecase = usecase;
    }

////////////////////////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////////////////////////

    public void getPlaces(String name) {
        SearchForm form = new SearchForm();

        form.setName(name);

        this.getView().showLoading();

        this.usecase.getPlaces(form);
    }

////////////////////////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onSuccess(ArrayList<PlaceModel> places) {
        this.getView().hideLoading();

        this.getView().onListSuccess(places);
    }

    @Subscribe
    public void onError(ApiErrorModel error) {
        this.getView().hideLoading();

        this.manageError(error);
    }
}
