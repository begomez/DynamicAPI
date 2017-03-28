package com.begoandapps.padelapp.presenter;

import com.begoandapps.padelapp.utils.AndroidLoggerUtils;
import com.begoandapps.padelapp.view.interfaces.IView;
import com.squareup.otto.Bus;

/**
 * Created by bernatgomez on 2/3/17.
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    private static final String TAG = BasePresenter.class.getSimpleName();

    protected Bus bus = null;
    protected T view = null;

////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
////////////////////////////////////////////////////////////////////////////////////////

    public BasePresenter() {
        this.bus = new Bus();

        AndroidLoggerUtils.logMsg(TAG, "BasePresenter()");
    }

////////////////////////////////////////////////////////////////////////////////////////
// IMPL
////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void start() {
        this.bus.register(this);

        AndroidLoggerUtils.logMsg(TAG, "start()");
    }

    @Override
    public void stop() {
        this.bus.unregister(this);

        AndroidLoggerUtils.logMsg(TAG, "stop()");
    }

    public void attachView(T view) {
        this.view = view;

        AndroidLoggerUtils.logMsg(TAG, "attachView() " + view.getClass().getSimpleName());
    }

    public void unattachView() {
        this.view = null;

        AndroidLoggerUtils.logMsg(TAG, "unattachView()");
    }

    public T getView() {
        return this.view;
    }
}