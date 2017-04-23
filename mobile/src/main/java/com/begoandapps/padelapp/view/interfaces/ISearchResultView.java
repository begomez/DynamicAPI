package com.begoandapps.padelapp.view.interfaces;


import com.myapps.data.PadelClub;

import java.util.ArrayList;

/**
 * Created by bernatgomez on 23/4/17.
 */

public interface ISearchResultView extends IView {
    public void onDataReceived(ArrayList<PadelClub> data);
}
