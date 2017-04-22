package com.begoandapps.padelapp.view.interfaces;

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
