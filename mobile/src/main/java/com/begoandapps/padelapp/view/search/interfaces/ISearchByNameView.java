package com.begoandapps.padelapp.view.search.interfaces;

import com.begoandapps.padelapp.view.core.interfaces.IView;
import com.myapps.data.PlaceModel;

import java.util.List;

/**
 * Created by bernatgomez on 22/4/17.
 */

public interface ISearchByNameView extends IView {

    /**
     *
     * @param list
     */
    public void onListSuccess(List<PlaceModel> list);
}
