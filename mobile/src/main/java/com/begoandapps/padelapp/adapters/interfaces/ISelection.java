package com.begoandapps.padelapp.adapters.interfaces;

/**
 * Created by bernatgomez on 20/4/17.
 */

public interface ISelection {

    enum Types {SEARCH_SELECTION, SEARCH_BY_NAME};

    public void onSelected(int position, Types types);
}