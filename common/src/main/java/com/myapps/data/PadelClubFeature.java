package com.myapps.data;


import com.google.auto.value.AutoValue;

/**
 * Created by bernatgomez on 6/7/17.
 */
@AutoValue
public abstract class PadelClubFeature {
    public abstract String title();
    public abstract int icon();
    public static PadelClubFeature create(String title, int icon) {
        return new AutoValue_PadelClubFeature(title, icon);
    }
}
