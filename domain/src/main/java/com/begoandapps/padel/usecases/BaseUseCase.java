package com.begoandapps.padel.usecases;

import com.squareup.otto.Bus;

import rest.RestModuleDataSource;

public class BaseUseCase {

    protected final Bus bus;
    protected final RestModuleDataSource rest;

    public BaseUseCase(Bus bus, RestModuleDataSource rest) {
        this.bus = bus;
        this.rest = rest;
    }

    public void register() {
        this.bus.register(this);
    }

    public void unregister() {
        this.bus.unregister(this);
    }

}
