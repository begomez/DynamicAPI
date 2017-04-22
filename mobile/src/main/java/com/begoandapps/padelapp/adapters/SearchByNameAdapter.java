package com.begoandapps.padelapp.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.interfaces.IHolder;
import com.begoandapps.padelapp.adapters.interfaces.ISelection;
import com.begoandapps.padelapp.components.AppTextView;
import com.myapps.data.PlaceModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 20/4/17.
 */

public class SearchByNameAdapter extends RecyclerView.Adapter<SearchByNameAdapter.SearchByNameHolder> {

    private Context cntxt;

    private ISelection callback;

    private List<PlaceModel> data = new ArrayList<PlaceModel>();


    public SearchByNameAdapter(Context cntxt, ISelection callback, List<PlaceModel> data) {
        this.cntxt = cntxt;
        this.callback = callback;
        this.data = data;
    }

    @Override
    public SearchByNameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.cntxt).inflate(R.layout.item_search_by_name, parent, false);

        return new SearchByNameHolder(v);
    }

    @Override
    public void onBindViewHolder(SearchByNameHolder holder, int position) {
        holder.setValuesForItemInPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.data != null? this.data.size() : 0;
    }

////////////////////////////////////////////////////////////////////////////////////
// HOLDER
////////////////////////////////////////////////////////////////////////////////////

    public class SearchByNameHolder extends RecyclerView.ViewHolder implements IHolder {

        @BindView(R.id.search_by_name_container)
        public ConstraintLayout container;

        @BindView(R.id.search_by_name_icon)
        public ImageView icon;

        @BindView(R.id.search_by_name_title)
        public AppTextView title;

        @BindView(R.id.search_by_name_subtitle)
        public AppTextView subtitle;

        @BindView(R.id.search_by_name_descrip)
        public AppTextView descrip;


        public SearchByNameHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = this.getAdapterPosition();

            if (callback != null) {
                callback.onSelected(pos, ISelection.Types.SEARCH_BY_NAME);
            }
        }

        @Override
        public void setValuesForItemInPosition(int position) {
            PlaceModel item = data.get(position);

            this.title.setCustomText(item.getTitle());
            this.subtitle.setCustomText(item.getSubtitle());
            this.descrip.setCustomText(item.getDescrip());
        }

    }
}
