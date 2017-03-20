package com.begoandapps.padelapp.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.interfaces.IAppView;
import com.begoandapps.padelapp.utils.AndroidLoggerUtils;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class AppTitleSwitch extends FrameLayout implements IAppView {

    private static final String TAG = AppTitleSwitch.class.getSimpleName();

    @BindView(R.id.switch_title_container)
    protected RelativeLayout container;

    @BindView(R.id.switch_title_title)
    protected AppTextView title;

    @BindView(R.id.switch_title_content)
    protected AppTextView content;

    private Data data;


    public AppTitleSwitch(Context context) {
        super(context);

        this.init(context, null);
    }

    public AppTitleSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.init(context, attrs);
    }

    public AppTitleSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.init(context, attrs);
    }

    @TargetApi(21)
    public AppTitleSwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.init(context, attrs);
    }

    @Override
    public void init(Context context, AttributeSet attrs) {
        this.createData();

        this.bindViews(context);
        
        this.extractAttrs(context, attrs);

        //this.configViews();
    }

    private void createData() {
        this.data = new Data();
    }

    private void bindViews(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_title_switch, this, true);

        ButterKnife.bind(this);
    }

    private void extractAttrs(Context context, AttributeSet attrs) {
        TypedArray custom =
            context.getTheme().obtainStyledAttributes(attrs, R.styleable.AppTitleSwitch, 0, 0);


        try {
            this.data.type = custom.getInteger(R.styleable.AppTitleSwitch_type, 0) == 0? Type.TITLE : Type.CONTENT;

            this.data.text = custom.getString(R.styleable.AppTitleSwitch_text);

            if (custom != null) {
                custom.recycle();
            }

        } catch (Exception e) {
            AndroidLoggerUtils.logError(TAG, "extractAttrs()", e);
        }
    }

    private void configViews() {

        // TITLE
        if (this.isTitle()) {

            this.title.setVisibility(View.VISIBLE);
            this.content.setVisibility(View.GONE);

        // CONTENT
        } else {
            this.title.setVisibility(View.GONE);
            this.content.setVisibility(View.VISIBLE);
        }
    }

    public void setType(Type type) {
        this.configViews();

        this.data.type = type;
    }

    public void setCustomText(int text) {
        this.configViews();

        // TITLE
        if (this.isTitle()) {
            this.title.setCustomText(text);

        // CONTENT
        } else {
            this.content.setCustomText(text);
        }
    }

    private boolean isTitle() {
        return this.data.type == Type.TITLE;
    }

    private boolean isContent() {
        return !this.isTitle();
    }

////////////////////////////////////////////////////////////////////////////////////////
// DATA
////////////////////////////////////////////////////////////////////////////////////////

    public enum Type {TITLE, CONTENT};

    public static final class Data implements Serializable {
        private AppTitleSwitch.Type type = AppTitleSwitch.Type.TITLE;
        private String text = "";
    }

}
