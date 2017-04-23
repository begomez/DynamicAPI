package com.begoandapps.padel.usecases.results;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.myapps.forms.SearchResultForm;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import apimodels.ApiErrorModel;
import fake.FakeUtils;
import rest.RestModuleDataSource;

/**
 * Created by bernatgomez on 23/4/17.
 */

public class SearchResultsUseCaseImpl extends BaseUseCase implements SearchResultUseCase {

    public SearchResultsUseCaseImpl(Bus bus, RestModuleDataSource rest) {
        super(bus, rest);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// API
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void getClubs(SearchResultForm form) {
        this.register();

        this.onSuccess(null);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// SUSCRIPTIONS
/////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onSuccess(Void none) {
        this.unregister();

        this.bus.post(FakeUtils.getFakeClubs());
    }

    @Subscribe
    public void onError(ApiErrorModel error) {
        this.unregister();

        this.bus.post(error);
    }

}
