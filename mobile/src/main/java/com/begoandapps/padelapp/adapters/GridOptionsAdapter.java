package com.begoandapps.padelapp.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.myapps.data.PadelClubFeature;

import java.util.List;

/**
 * Created by bernatgomez on 6/7/17.
 */

public class GridOptionsAdapter extends ArrayAdapter<PadelClubFeature> {
    public GridOptionsAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public GridOptionsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<PadelClubFeature> objects) {
        super(context, resource, objects);
    }
}
