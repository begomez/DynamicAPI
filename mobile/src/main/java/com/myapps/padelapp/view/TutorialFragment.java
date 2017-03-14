package com.myapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.f2prateek.dart.InjectExtra;
import com.myapps.padelapp.R;
import com.myapps.padelapp.components.AppButton;
import com.myapps.padelapp.components.AppTextView;
import com.myapps.padelapp.interfaces.INavigable;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class TutorialFragment extends BaseFragment {

    public static final String EXTRA_DATA = "extra_data";

    @BindView(R.id.tutorial_frag_icon)
    protected ImageView tutIcon;

    @BindView(R.id.tutorial_frag_title)
    protected AppTextView tutTitle;

    @BindView(R.id.tutorial_frag_subtitle)
    protected AppTextView tutSubtitle;

    @BindView(R.id.tutorial_frag_btn)
    protected AppButton tutButton;

    @InjectExtra(EXTRA_DATA)
    protected Data data;


    protected INavigable navCallback;


    public static TutorialFragment newInstance(int position) {
        TutorialFragment frag = new TutorialFragment();

        Bundle extras = new Bundle();

        extras.putSerializable(EXTRA_DATA, new Data(position));

        frag.setArguments(extras);

        return frag;
    }

    private void f(int position) {

        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////
// NAVIGATION
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    @OnClick(R.id.tutorial_frag_btn)
    public void onMainBtnClick(View v) {
        if (this.navCallback != null) {
            this.navCallback.navigateToNext(this.navCallback.getNavigationCmd());
        }
    }


/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_tutorial;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        Button btn = (Button) v.findViewById(R.id.tutorial_frag_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMainBtnClick(v);
            }
        });

        return v;
    }

/////////////////////////////////////////////////////////////////////////////////////////
// DATA
/////////////////////////////////////////////////////////////////////////////////////////

    static final class Data implements Serializable {
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
