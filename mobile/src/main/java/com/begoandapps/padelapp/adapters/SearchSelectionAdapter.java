package com.begoandapps.padelapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppTextView;
import com.begoandapps.padelapp.utils.ArrayUtils;
import com.begoandapps.padelapp.view.SearchSelectionFragment;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchSelectionAdapter
        extends RecyclerView.Adapter<SearchSelectionAdapter.SearchSelectionHolder> {

    protected Context cntxt;

    protected SearchSelectionFragment.ISelection callback;

    protected int[] icons = {R.drawable.ic_pin, R.drawable.ic_calendar, R.drawable.ic_clock};

    protected ArrayList<String> titles;

    protected ArrayList<String> subtitles;



    /**
     *
     * @param cntxt
     */
    public SearchSelectionAdapter(Context cntxt, SearchSelectionFragment.ISelection callback) {
        super();

        this.cntxt = cntxt;

        this.callback = callback;

        this.init();
    }

    private void init() {
        //this.icons = this.cntxt.getResources().getIntArray(R.array.search_selection_icons);

        this.titles = new ArrayList<String>(Arrays.asList(this.cntxt.getResources().getStringArray(R.array.search_selection_options)));

        this.subtitles = new ArrayList<String>(Arrays.asList(this.cntxt.getResources().getStringArray(R.array.search_selection_default_values)));
    }

    @Override
    public SearchSelectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.cntxt).inflate(R.layout.item_search_selection, parent, false);

        SearchSelectionHolder vh = new SearchSelectionHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(SearchSelectionHolder holder, int position) {
        holder.setValuesForItemInPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.titles.size();
    }

//////////////////////////////////////////////////////////////////////////////////////////////
// HOLDER
//////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     */
    public class SearchSelectionHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.search_selection_item_icon)
        public ImageView icon;

        @BindView(R.id.search_selection_item_title)
        public AppTextView title;

        @BindView(R.id.search_selection_item_subtitle)
        public AppTextView subtitle;


        public SearchSelectionHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();

            if (callback != null) {
                callback.onSelected(pos);
            }
        }

        public void setValuesForItemInPosition(int position) {
            if (ArrayUtils.valueInRange(position, titles != null? titles.size() : 0)) {
                this.icon.setImageDrawable(cntxt.getResources().getDrawable(icons[position]));
                this.title.setCustomText(titles.get(position));
                this.subtitle.setCustomText(subtitles.get(position));
            }
        }
    }
}
