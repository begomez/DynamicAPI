package com.begoandapps.padelapp.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.interfaces.IAppView;
import com.begoandapps.padelapp.components.interfaces.IAttrView;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;

import java.io.Serializable;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class AppEditText extends android.support.v7.widget.AppCompatEditText implements IAttrView {

    private static final String TAG = AppEditText.class.getSimpleName();

    private Data data;

//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public AppEditText(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.init(context, attrs);
    }

    public AppEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

//////////////////////////////////////////////////////////////////////////////////
// IAPPVIEW IMPL
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init(Context context, AttributeSet attrs) {
        //this.setBackground(context);
        this.createData();

        this.extractAttrs(context, attrs);

        this.configViews();
    }

    @Override
    public void createData() {
        this.data = new Data();
    }

    @Override
    public void extractAttrs(Context cntxt, AttributeSet attrs) {
        TypedArray custom = cntxt.getTheme().obtainStyledAttributes(attrs, R.styleable.AppEditText, 0, 0);

        try {
            this.data.left_icon = custom.getInteger(R.styleable.AppEditText_left_icon, 0);
            this.data.img_background = custom.getInteger(R.styleable.AppEditText_img_background, 0);

            if (custom != null) {
                custom.recycle();
            }

        } catch (Exception e) {
            AndroidLoggerUtils.logError(TAG, "extractAttrs()", e);
        }
    }

    @Override
    public void bindViews(Context cntxt) {

    }

    @Override
    public void configViews() {
        this.back();

        this.icon();
    }

    @TargetApi(21)
    private void back() {
        if (this.data.img_background != 0) {
            this.setBackground(this.getResources().getDrawable(this.data.img_background));
            this.setBackgroundDrawable(this.getResources().getDrawable(this.data.img_background));
            this.setBackgroundResource(this.data.img_background);
        }
    }

    private void icon() {
        if (this.data.left_icon != 0) {
            this.setCompoundDrawablePadding(5);
            this.setCompoundDrawablesWithIntrinsicBounds(this.getResources().getDrawable(this.data.left_icon), null, null, null);
        }

    }

//////////////////////////////////////////////////////////////////////////////////
// HELPERS
//////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////
// DATA
//////////////////////////////////////////////////////////////////////////////////

    public static final class Data implements Serializable {
        public int left_icon;
        public int img_background;
    }
}
