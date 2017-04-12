package com.begoandapps.padelapp.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.interfaces.IAttrView;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class AppToolbar extends Toolbar implements IAttrView {

    private static final String TAG = AppToolbar.class.getSimpleName();

    @Nullable
    @BindView(R.id.toolbar_container)
    protected LinearLayout container;

    @Nullable
    @BindView(R.id.toolbar_icon)
    protected ImageView icon;

    @Nullable
    @BindView(R.id.toolbar_title)
    protected AppTextView title;

    private Data data;

//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public AppToolbar(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.init(context, attrs);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

//////////////////////////////////////////////////////////////////////////////////
// IAAPVIEW IMPL
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init(Context context, AttributeSet attrs) {
        this.createData();

        //this.bindViews(context);

        this.extractAttrs(context, attrs);

        //this.configViews();
    }

    @Override
    public void createData() {
        this.data = new Data();
    }

    @Override
    public void bindViews(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_toolbar, this, true);

        ButterKnife.bind(this, v);
    }

    @Override
    public void extractAttrs(Context context, AttributeSet attrs) {
        TypedArray custom = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AppToolbar, 0, 0);

        try {
            this.data.title = custom.getString(R.styleable.AppToolbar_title);
            this.data.icon = custom.getInt(R.styleable.AppToolbar_icon, R.drawable.ic_back);
            this.data.backColor = custom.getColor(R.styleable.AppToolbar_backColor, context.getResources().getColor(R.color.colorToolbarBackDef));
            this.data.backColor = custom.getColor(R.styleable.AppToolbar_foreColor, context.getResources().getColor(R.color.colorToolbarForeDef));

            if (custom != null) {
                custom.recycle();
            }

        } catch (Exception e) {
            AndroidLoggerUtils.logError(TAG, "extractAttrs()", e);
        }
    }

    @Override
    public void configViews() {
        if (this.data != null) {
            this.container.setBackgroundColor(this.data.backColor);
            this.title.setTextColor(this.data.foreColor);
            this.title.setCustomText(this.data.title);
            this.icon.setImageDrawable(this.getResources().getDrawable(this.data.icon));
        }
    }

//////////////////////////////////////////////////////////////////////////////////
// ACCESSORS
//////////////////////////////////////////////////////////////////////////////////

    public void setIcon(int icon) {
        this.setNavigationIcon(icon);
    }

    public void setTitle(String title) {
        this.setTitle(title);
    }

    public void setForeColor(int color) {
        this.setTitleTextColor(color);
    }

    public void setBackColor(int color) {
        this.setBackgroundColor(color);
    }

//////////////////////////////////////////////////////////////////////////////////
// DATA
//////////////////////////////////////////////////////////////////////////////////

    public static final class Data implements Serializable {
        String title;
        int icon;
        int backColor;
        int foreColor;
    }

}
