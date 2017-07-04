package com.begoandapps.padelapp.dependencies.components;

import com.begoandapps.padelapp.dependencies.modules.SearchModule;
import com.begoandapps.padelapp.dependencies.scopes.PerActivity;
import com.begoandapps.padelapp.view.search.SearchByNameFragment;
import com.begoandapps.padelapp.view.search.result.SearchResultFragment;

import dagger.Component;

/**
 * Created by bernatgomez on 22/4/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {SearchModule.class})
public interface SearchComponent {

    public void inject(SearchByNameFragment fragment);

    public void inject(SearchResultFragment fragment);
}
