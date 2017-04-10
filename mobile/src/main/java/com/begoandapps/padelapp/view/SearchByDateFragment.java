package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

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
    protected DatePicker calendar;


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

        this.configCalendar();
    }

    private void configCalendar() {

        /*
        this.calendar.setShowWeekNumber(false);
        this.calendar.setFirstDayOfWeek(2);
        this.calendar.setSelectedWeekBackgroundColor(this.getResources().getColor(R.color.colorAccent));
        this.calendar.setUnfocusedMonthDateColor(this.getResources().getColor(R.color.colorWhite));
        this.calendar.setWeekSeparatorLineColor(this.getResources().getColor(android.R.color.transparent));
        this.calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

            }
        });
        */
    }
}
