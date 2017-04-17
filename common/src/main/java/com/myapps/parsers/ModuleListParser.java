package com.myapps.parsers;

import com.myapps.data.KeyValue;
import com.myapps.utils.LoggerUtils;
import com.myapps.utils.TextUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by bernatgomez on 17/4/17.
 */

public abstract class ModuleListParser {

    private static final String TAG = ModuleListParser.class.getSimpleName();

    private static final String DIR_FILES = "files/";

    private static final String KEY_VALUE_SEPARATOR = " ";

    private static final int INDEX_KEY = 0;
    private static final int INDEX_VALUE = 1;


    /**
     *
     * @param line
     * @param <K>
     * @param <V>
     * @return
     */
    private static <K, V>KeyValue<K, V> parseLine(String line) {
        KeyValue ret = new KeyValue();

        if (TextUtils.isValidString(line)) {
            String[] parts = line.split(KEY_VALUE_SEPARATOR);

            ret.setKey(parts[INDEX_KEY]);
            ret.setValue(parts[INDEX_VALUE]);
        }

        return ret;
    }

    /**
     *
     * @param name
     * @return
     */
    public static ArrayList<KeyValue<String, String>> readModulesFile(String name) {
        ArrayList<KeyValue<String, String>> modules = new ArrayList<KeyValue<String, String>>();

        try {
            InputStream is = ModuleListParser.class.getClassLoader().getResourceAsStream(DIR_FILES + name);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                KeyValue<String, String> module = ModuleListParser.parseLine(line);

                if (module.validate() && !modules.contains(module)) {
                    modules.add(module);
                }
            }

        } catch (Exception e) {
            LoggerUtils.logMsg(TAG, "readModulesFile() " + e);

            modules = new ArrayList<KeyValue<String, String>>();
        }

        return modules;
    }
}
