package com.begoandapps.padelapp.dependencies.modules;

import com.begoandapps.padel.usecases.search.SearchByNameUseCaseImpl;
import com.begoandapps.padel.usecases.search.SearchByNameUseCase;
import com.begoandapps.padelapp.dependencies.scopes.PerActivity;
import com.begoandapps.padelapp.presenter.SearchByNamePresenter;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;
import rest.RestModuleDataSource;

/**
 * Created by bernatgomez on 22/4/17.
 */
@Module
public class SearchModule {

    /**
     *
     * @param bus
     * @param usecase
     * @return
     */
    @Provides
    @PerActivity
    public SearchByNamePresenter provideSearchPresenter(Bus bus, SearchByNameUseCase usecase) {
        return new SearchByNamePresenter(bus, usecase);
    }

    /**
     *
     * @param bus
     * @param rest
     * @return
     */
    @Provides
    @PerActivity
    public SearchByNameUseCase provideSearchUsecase(Bus bus, RestModuleDataSource rest) {
        return new SearchByNameUseCaseImpl(bus, rest);
    }
}
