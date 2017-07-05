package com.begoandapps.padelapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.adapters.interfaces.IHolder;
import com.begoandapps.padelapp.adapters.interfaces.ISelection;
import com.begoandapps.padelapp.components.AppTextView;
import com.begoandapps.padelapp.view.interfaces.ISearchResultView;
import com.myapps.data.PadelClub;
import com.myapps.utils.ValueUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 23/4/17.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.SearchResultHolder> {

    private Context cntxt;
    protected ISelection callback;
    protected ArrayList<PadelClub> clubs;


/////////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
/////////////////////////////////////////////////////////////////////////////////////////////
    public SearchResultAdapter(Context cntxt, ISelection callback, ArrayList<PadelClub> clubs) {
        this.cntxt = cntxt;
        this.callback = callback;
        this.clubs = clubs;
    }

    @Override
    public SearchResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.cntxt).inflate(R.layout.item_search_result, parent, false);
        return new SearchResultHolder(v);
    }

    @Override
    public void onBindViewHolder(SearchResultHolder holder, int position) {
        holder.setValuesForItemInPosition(position);
    }

    @Override
    public int getItemCount() {
        return ValueUtils.isValidObj(this.clubs)? this.clubs.size() : 0;
    }

    public class SearchResultHolder extends RecyclerView.ViewHolder implements IHolder {

        @BindView(R.id.search_result_item_padel_club_name)
        protected AppTextView clubName;

        @BindView(R.id.search_result_item_padel_club_rating)
        protected RatingBar rate;

        @BindView(R.id.search_result_item_padel_club_time)
        protected AppTextView clubTime;

        @BindView(R.id.search_result_item_padel_distance)
        protected AppTextView clubDistance;

        @BindView(R.id.search_result_item_padel_type)
        protected AppTextView clubType;


        public SearchResultHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void setValuesForItemInPosition(int position) {
            PadelClub data = clubs.get(position);

            this.clubName.setCustomText(data.getName());
            this.rate.setRating(data.getRating());
            this.clubTime.setCustomText(data.getTime().toString());
            this.clubDistance.setCustomText(data.getDistance() + "");
            this.clubType.setCustomText(data.getType() + "");
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();

            if (ValueUtils.isValidObj(callback)) {
                callback.onSelected(pos, ISelection.Types.SEARCH_RESULT);
            }
        }
    }
}
