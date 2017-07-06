package com.begoandapps.padelapp.components;


import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.interfaces.IAppView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by bernatgomez on 6/7/17.
 */
public class AppGridOptions extends GridView implements IAppView {

    @BindView(R.id.search_result_item_options_grid)
    protected GridView optionsGrid;


//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////
    public AppGridOptions(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppGridOptions(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.init(context, attrs);
    }

    public AppGridOptions(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

    @TargetApi(21)
    public AppGridOptions(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.init(context, attrs);
    }

//////////////////////////////////////////////////////////////////////////////////
// IMPL
//////////////////////////////////////////////////////////////////////////////////
    @Override
    public void init(Context context, AttributeSet attrs) {
        this.initData();

        this.bindViews(context);
    }

    private void initData() {

    }

    private void bindViews(Context cntxt) {
        LayoutInflater.from(cntxt).inflate(R.layout.view_grid_options, this, true);

        ButterKnife.bind(this);
    }
}
