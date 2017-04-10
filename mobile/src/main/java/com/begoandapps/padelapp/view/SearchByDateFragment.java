package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CalendarView;
import android.widget.LinearLayout;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppTextView;

import butterknife.BindView;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchByDateFragment extends BaseFragment {

    @BindView(R.id.search_by_date_preview_container)
    protected LinearLayout selectionPreviewContainer;

    @BindView(R.id.search_by_date_preview_year)
    protected AppTextView selectionPreviewYear;

    @BindView(R.id.search_by_date_preview_date)
    protected AppTextView selectionPreviewDate;

    @BindView(R.id.search_by_date_calendar)
    protected CalendarView calendar;


////////////////////////////////////////////////////////////////////////////////////////////////
/// CONSTRUCTOR
////////////////////////////////////////////////////////////////////////////////////////////////

    public static SearchByDateFragment newInstance() {
        SearchByDateFragment f = new SearchByDateFragment();

        return f;
    }

////////////////////////////////////////////////////////////////////////////////////////////////
/// LIFE CYCLE
////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_search_by_date;
    }

////////////////////////////////////////////////////////////////////////////////////////////////
/// ARCHITECTURE
////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void configViews() {
        super.configViews();

        this.showToolbar();
    }
}
