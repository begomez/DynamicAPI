package com.myapps.parsers.interfaces;

import com.myapps.data.KeyValue;

import java.util.ArrayList;

/**
 * Created by bernatgomez on 17/4/17.
 */

public interface IModulesParser {

    /**
     *
     * @return
     */
    public ArrayList<KeyValue<String, String>> getRestModules();
}
