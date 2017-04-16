package com.begoandapps.padelapp.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by bernatgomez on 16/4/17.
 */

public abstract class FontUtils {

    /**
     *
     */
    private static final String DIR_FONTS = "fonts";

    /**
     *
     */
    private static final String FONT_EXTENSION = ".ttf";

    /**
     *
     */
    public enum Fonts {ROBOTO_LIGHT, ROBOTO_REGULAR, COURGETTE_REGULAR, DEFAULT};

    /**
     *
     */
    private static Typeface robotoLightFont;
    private static Typeface robotoRegularFont;
    private static Typeface corgetteRegularFont;
    private static Typeface defaultFont;

    /**
     *
     */
    public static void loadFonts(AssetManager assets) {
        FontUtils.robotoLightFont = loadFont(assets, Fonts.ROBOTO_LIGHT);
        FontUtils.robotoRegularFont = loadFont(assets, Fonts.ROBOTO_REGULAR);
        FontUtils.corgetteRegularFont = loadFont(assets, Fonts.COURGETTE_REGULAR);
        FontUtils.defaultFont = corgetteRegularFont;
    }

    /**
     *
     * @param assets
     * @param fontName
     */
    public static Typeface loadFont(AssetManager assets, Fonts fontName) {
        return
            Typeface.createFromAsset(assets, DIR_FONTS + getFontFileByFontName(fontName)) ;
    }

    /**
     *
     * @param name
     * @return
     */
    private static String getFontFileByFontName(Fonts name) {
        String ret = "";

        switch (name) {
            case ROBOTO_LIGHT:
                ret = "Roboto-Light";
                break;
            case COURGETTE_REGULAR:
                ret = "Courgette-Regular";
                break;
            case ROBOTO_REGULAR:
            default:
                ret = "Roboto-Regular";
                break;
        }

        return ret + FONT_EXTENSION;

    }

}
