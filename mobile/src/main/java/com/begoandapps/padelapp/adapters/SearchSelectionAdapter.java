package com.begoandapps.padelapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppTextView;
import com.begoandapps.padelapp.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 10/4/17.
 */

public class SearchSelectionAdapter
        extends RecyclerView.Adapter<SearchSelectionAdapter.SearchSelectionHolder> {

    protected Context cntxt;

    protected ArrayList<String> titles;

    protected ArrayList<String> subtitles;



    /**
     *
     * @param cntxt
     */
    public SearchSelectionAdapter(Context cntxt) {
        super();

        this.cntxt = cntxt;

        this.init();
    }

    private void init() {
        this.titles = new ArrayList<String>(Arrays.asList(this.cntxt.getResources().getStringArray(R.array.search_selection_options)));

        this.subtitles = new ArrayList<String>(Arrays.asList(this.cntxt.getResources().getStringArray(R.array.search_selection_default_values)));
    }

    @Override
    public SearchSelectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.cntxt).inflate(R.layout.item_search_selection, parent, false);

        return new SearchSelectionHolder(v);
    }

    @Override
    public void onBindViewHolder(SearchSelectionHolder holder, int position) {
        holder.setValuesForItem(position);
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
    public class SearchSelectionHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.search_selection_item_title)
        public AppTextView title;

        @BindView(R.id.search_selection_item_subtitle)
        public AppTextView subtitle;


        public SearchSelectionHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        public void setValuesForItem(int position) {
            if (ArrayUtils.valueInRange(position, titles != null? titles.size() : 0)) {
                this.title.setCustomText(titles.get(position));
                this.subtitle.setCustomText(subtitles.get(position));
            }
        }
    }
}
