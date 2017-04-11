package com.begoandapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.f2prateek.dart.InjectExtra;
import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppButton;
import com.begoandapps.padelapp.components.AppTextView;
import com.begoandapps.padelapp.components.AppTitleSwitch;
import com.begoandapps.padelapp.view.interfaces.INavigable;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class TutorialFragment extends BaseFragment {

    public static final String EXTRA_DATA = "extra_data";

    private static final int PAGE_1 = 0;
    private static final int PAGE_2 = 1;
    private static final int PAGE_3 = 2;
    private static final int PAGE_4 = 3;

    @BindView(R.id.tutorial_frag_line)
    protected ImageView tutLine;

    @BindView(R.id.tutorial_frag_icon)
    protected ImageView tutIcon;

    @BindView(R.id.tutorial_frag_title)
    protected AppTitleSwitch tutTitle;

    @BindView(R.id.tutorial_frag_subtitle)
    protected AppTextView tutSubtitle;

    @BindView(R.id.tutorial_frag_btn)
    protected AppButton tutButton;

    @InjectExtra(EXTRA_DATA)
    protected Data data;


    protected INavigable navCallback;


//////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
//////////////////////////////////////////////////////////////////////////////////

    public static TutorialFragment newInstance(int position) {
        TutorialFragment frag = new TutorialFragment();

        Bundle extras = new Bundle();

        extras.putSerializable(EXTRA_DATA, new Data(position));

        frag.setArguments(extras);

        return frag;
    }

/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_tutorial;
    }

    @Override
    public void configViews() {
        super.configViews();

        this.configPages();
    }

    private void configPages() {

        switch (this.data.position) {
            case PAGE_1:
                this.tutLine.setVisibility(View.VISIBLE);
                this.tutTitle.setType(AppTitleSwitch.Type.TITLE);
                this.setTextsAndIcon(R.string.tutorial_step_1_title, R.string.tutorial_step_1_subtitle, R.drawable.tut_step_1);
                break;
            case PAGE_2:
                this.tutLine.setVisibility(View.INVISIBLE);
                this.tutTitle.setType(AppTitleSwitch.Type.CONTENT);
                this.setTextsAndIcon(R.string.tutorial_step_2_title, R.string.tutorial_step_2_subtitle, R.drawable.tut_step_2);
                break;
            case PAGE_3:
                this.tutLine.setVisibility(View.INVISIBLE);
                this.tutTitle.setType(AppTitleSwitch.Type.CONTENT);
                this.setTextsAndIcon(R.string.tutorial_step_3_title, R.string.tutorial_step_3_subtitle, R.drawable.tut_step_3);
                break;
            case PAGE_4:
                this.tutLine.setVisibility(View.INVISIBLE);
                this.tutTitle.setType(AppTitleSwitch.Type.CONTENT);
                this.setTextsAndIcon(R.string.tutorial_step_4_title, R.string.tutorial_step_4_subtitle, R.drawable.tut_step_4);
                break;
            default:
                break;
        }

        this.tutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMainBtnClick(v);
            }
        });

    }

    private void setTextsAndIcon(int title, int subtitle, int icon) {
        this.tutTitle.setCustomText(title);
        this.tutSubtitle.setCustomText(subtitle);
        this.tutIcon.setImageDrawable(this.getResources().getDrawable(icon));
    }

/////////////////////////////////////////////////////////////////////////////////////////
// NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    @OnClick(R.id.tutorial_frag_btn)
    public void onMainBtnClick(View v) {
        if (this.navCallback != null) {
            this.navCallback.navigateTo(this.navCallback.getNavigationCmd());
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////
// DATA
/////////////////////////////////////////////////////////////////////////////////////////

    public static final class Data implements Serializable {
        public int position;

        public Data(int position) {
            this.position = position;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////
// ACCESSORS
/////////////////////////////////////////////////////////////////////////////////////////

    public void setNavCallback(INavigable navCallback) {
        this.navCallback = navCallback;
    }


}
