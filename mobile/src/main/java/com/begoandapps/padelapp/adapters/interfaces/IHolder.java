package com.begoandapps.padelapp.adapters.interfaces;

import android.view.View;

/**
 * Created by bernatgomez on 20/4/17.
 */

public interface IHolder extends View.OnClickListener {

    /**
     *
     * @param position
     */
    public void setValuesForItemInPosition(int position);
}
