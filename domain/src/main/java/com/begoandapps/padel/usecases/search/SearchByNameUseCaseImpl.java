package com.begoandapps.padel.usecases.search;

import com.begoandapps.padel.usecases.BaseUseCase;
import com.myapps.forms.SearchForm;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import apimodels.ApiErrorModel;
import apimodels.PlaceByName;
import fake.FakeUtils;
import rest.RestModuleDataSource;

/**
 * Created by bernatgomez on 20/4/17.
 */

public class SearchByNameUseCaseImpl extends BaseUseCase implements SearchByNameUseCase {
    public SearchByNameUseCaseImpl(Bus bus, RestModuleDataSource rest) {
        super(bus, rest);
    }

    @Override
    public void getPlaces(SearchForm form) {
        this.register();

        this.onSuccess(null);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// SUSCRIPTIONS
/////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onSuccess(ArrayList<PlaceByName> list) {
        this.unregister();

        this.bus.post(FakeUtils.getFakePlaces());
    }

    @Subscribe
    public void onError(ApiErrorModel apiErrorModel) {
        this.unregister();

        this.bus.post(apiErrorModel);
    }
}
