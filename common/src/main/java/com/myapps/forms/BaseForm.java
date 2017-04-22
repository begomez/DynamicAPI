package com.myapps.forms;

import java.io.Serializable;

/**
 * Created by bernatgomez on 20/4/17.
 */
public abstract class BaseForm implements Serializable {

    public BaseForm() {

    }

    public abstract boolean validate();
}
