package rest;

import com.squareup.otto.Bus;

import rest.interfaces.IDataSource;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class RestDataSource implements IDataSource {
    private Bus bus;


    public RestDataSource(Bus bus) {
        this.bus = bus;
    }

}
