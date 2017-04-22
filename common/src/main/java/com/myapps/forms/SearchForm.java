package com.myapps.forms;

import com.myapps.utils.ValueUtils;

/**
 * Created by bernatgomez on 20/4/17.
 */

public class SearchForm extends BaseForm {

    private String name;

    public SearchForm() {
        this.setName("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean validate() {
        return ValueUtils.isValidObj(this.getName());
    }

}
