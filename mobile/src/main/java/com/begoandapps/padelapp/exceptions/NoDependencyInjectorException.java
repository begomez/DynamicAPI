package com.begoandapps.padelapp.exceptions;

/**
 * Created by bernatgomez on 22/3/17.
 */

public class NoDependencyInjectorException extends Exception {

    public NoDependencyInjectorException() {

    }

    public NoDependencyInjectorException(String msg) {
        super(msg);
    }
}
