package com.begoandapps.padelapp.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
    protected RelativeLayout container;

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

        this.bindViews(context);

        this.extractAttrs(context, attrs);

        this.configViews();
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
            this.data.title = custom.getInt(R.styleable.AppToolbar_title, R.string.app_name);
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
            this.setBackColor(this.data.backColor);
            this.setTitle(this.data.title);
            this.setForeColor(this.data.foreColor);
            this.setIcon(this.data.icon);

            // NAV ICON
            if (this.data.showIcon) {
                this.showIcon();

            // NO NAV ICON
            } else {
                this.hideIcon();
            }
        }
    }

    public void reset() {
        this.showIcon();
        this.setBackColor(R.color.colorGrey);
        this.setForeColor(R.color.colorBlack);
        this.setTitle(R.string.app_name);
    }

//////////////////////////////////////////////////////////////////////////////////
// ACCESSORS
//////////////////////////////////////////////////////////////////////////////////

    public void showIcon() {
        this.toogleIcon(true, false);
    }

    public void hideIcon() {
        this.toogleIcon(false, false);
    }

    public void toogleIcon(boolean shown, boolean restart) {
        this.getNavigationIcon().setVisible(shown, false);
    }

    public void setIcon(int icon) {
        this.setNavigationIcon(icon);
    }

    public void setTitle(int title) {
        this.title.setCustomText(title);
    }

    public void setForeColor(int color) {
        this.title.setTextColor(color);
        //this.setTitleTextColor(color);
    }

    public void setBackColor(int color) {
        this.setBackgroundColor(color);
    }

//////////////////////////////////////////////////////////////////////////////////
// DATA
//////////////////////////////////////////////////////////////////////////////////

    public static final class Data implements Serializable {
        public boolean showIcon;
        public int title;
        public int icon;
        public int backColor;
        public int foreColor;

        public Data defaultData() {
            this.showIcon = true;
            this.title = R.string.app_name;
            this.icon = R.drawable.ic_back;
            this.backColor = R.color.colorGreyToolbar;
            this.foreColor = R.color.colorBlack;

            return this;
        }
    }

}
