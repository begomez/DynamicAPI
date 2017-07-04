package com.begoandapps.padelapp.presenter;

import com.begoandapps.padelapp.view.core.interfaces.IView;

/**
 * Created by bernatgomez on 21/3/17.
 */

public interface IPresenter<T extends IView> {
    public void start();
    public void stop();
    public void attachView(T view);
    public void unattachView();
    public T getView();
}
