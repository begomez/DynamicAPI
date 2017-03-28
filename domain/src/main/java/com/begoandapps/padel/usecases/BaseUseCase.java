package com.begoandapps.padel.usecases;

import com.squareup.otto.Bus;

import rest.RestDataSource;

public class BaseUseCase {

    protected Bus bus;
    protected RestDataSource rest;


    public BaseUseCase() {

    }

    public BaseUseCase(Bus bus, RestDataSource rest) {
        this.bus = bus;
        this.rest = rest;
    }
}
