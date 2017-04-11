package com.begoandapps.padelapp.utils;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;

/**
 * Created by bernatgomez on 11/4/17.
 */

public abstract class ViewUtils {

    public static SpannableString getAsSpannable(String str) {
        return ViewUtils.getAsSpannable(str, new UnderlineSpan());
    }

    public static SpannableString getAsSpannable(String str, CharacterStyle style) {
        SpannableString span = new SpannableString(str);

        span.setSpan(style, 0, str.length(), 0);

        return span;
    }
}
