package com.myapps.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by bernatgomez on 17/4/17.
 */

public abstract class FileUtils {

    private static final String TAG = FileUtils.class.getSimpleName();

    private static final String DIR_FILES = "files/";

    public static ArrayList<String> readFile(String name) {
        ArrayList<String> modules = new ArrayList<String>();

        try {
            InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(DIR_FILES + name);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                LoggerUtils.logMsg(TAG, "read: " + line);

                if ((line != null) && (!line.trim().equals("")) && (!modules.contains(line))) {
                    modules.add(line);
                }
            }

        } catch (Exception e) {
            LoggerUtils.logMsg(TAG, "readFile() " + e);

            modules = new ArrayList<String>();
        }

        return modules;
    }
}
