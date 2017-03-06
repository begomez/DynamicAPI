package com.myapps.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by bernatgomez on 6/3/17.
 */

public abstract class LoggerUtils {
    private static final String LOGGER_NAME = "Padel";

    public static void logMsg(String tag, String msg) {
        Logger.getLogger(LOGGER_NAME).log(Level.INFO, tag + ":" + msg);
    }
}
