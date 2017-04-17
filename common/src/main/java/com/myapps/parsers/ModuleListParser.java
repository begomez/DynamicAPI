package com.myapps.parsers;

import com.myapps.data.KeyValue;
import com.myapps.parsers.interfaces.IModulesParser;
import com.myapps.utils.LoggerUtils;
import com.myapps.utils.TextUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by bernatgomez on 17/4/17.
 */

public class ModuleListParser implements IModulesParser {

    private static final String TAG = ModuleListParser.class.getSimpleName();

    private static final String TARGET_DIR = "files/";
    private static final String TARGET_FILE = "modules.list";

    private static final String KEY_VALUE_SEPARATOR = " ";
    private static final int INDEX_KEY = 0;
    private static final int INDEX_VALUE = 1;


    public ModuleListParser() {

    }

    /**
     *
     * @return
     */
    public ArrayList<KeyValue<String, String>> getRestModules() {
        ArrayList<KeyValue<String, String>> modules = new ArrayList<KeyValue<String, String>>();

        try {
            InputStream is = ModuleListParser.class.getClassLoader().getResourceAsStream(TARGET_DIR + TARGET_FILE);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                KeyValue<String, String> module = this.parseLine(line);

                if (module.validate() && !modules.contains(module)) {
                    modules.add(module);
                }
            }

        } catch (Exception e) {
            LoggerUtils.logMsg(TAG, "getRestModules() " + e);

            modules = new ArrayList<KeyValue<String, String>>();
        }

        return modules;
    }

    /**
     *
     * @param line
     * @param <K>
     * @param <V>
     * @return
     */
    private <K, V>KeyValue<K, V> parseLine(String line) {
        KeyValue ret = new KeyValue();

        if (TextUtils.isValidString(line)) {
            String[] parts = line.split(KEY_VALUE_SEPARATOR);

            ret.setKey(parts[INDEX_KEY]);
            ret.setValue(parts[INDEX_VALUE]);
        }

        return ret;
    }

}
