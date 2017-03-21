package com.begoandapps.padelapp.presenter;

/**
 * Created by bernatgomez on 21/3/17.
 */

public interface IPresenter<T> {
    public void start();
    public void stop();
    public void attachView(T view);
    public void unattachView();
}
