package com.myapps.exceptions;

/**
 * Created by bernatgomez on 7/4/17.
 */

public class BaseException extends Exception {

    private static final String TAG = BaseException.class.getSimpleName();

    public BaseException() {
        super(TAG);
    }

    public BaseException(String name) {
        super(name);
    }
}
