package com.begoandapps.padel.usecases;

import com.squareup.otto.Bus;

import rest.RestDataSource;

public class BaseUseCase {

    protected Bus bus;
    protected RestDataSource rest;

    public BaseUseCase(Bus bus, RestDataSource rest) {
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
