package com.myapps.data;

import com.google.auto.value.AutoValue;

/**
 * Created by bernatgomez on 13/7/17.
 */
@AutoValue
public abstract class OptionItem {
    public abstract int getIcon();
    public abstract String getTitle();
    public static OptionItem create(int icon, String title) {
        return new AutoValue_OptionItem(icon, title);
    }
}
