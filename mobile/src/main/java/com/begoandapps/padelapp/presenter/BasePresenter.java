package com.begoandapps.padelapp.presenter;

import com.begoandapps.padelapp.view.interfaces.IView;
import com.squareup.otto.Bus;

/**
 * Created by bernatgomez on 2/3/17.
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    protected Bus bus = null;
    protected IView view = null;

////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
////////////////////////////////////////////////////////////////////////////////////////

    public BasePresenter() {
        this.bus = new Bus();
    }

////////////////////////////////////////////////////////////////////////////////////////
// IMPL
////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void start() {
        this.bus.register(this);
    }

    @Override
    public void stop() {
        this.bus.unregister(this);
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void unattachView() {
        this.view = null;
    }
}
