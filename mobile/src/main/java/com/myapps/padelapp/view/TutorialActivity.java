package com.myapps.padelapp.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.myapps.padelapp.R;

import butterknife.BindView;

public class TutorialActivity extends BaseActivity {

    @BindView(R.id.content_frame)
    protected FrameLayout contentFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_tutorial;

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void launchMainFragment() {
        FragmentManager mgr = this.getSupportFragmentManager();

        BaseFragment tutorial = TutorialFragment.newInstance();

        FragmentTransaction trans  = mgr.beginTransaction();

        trans.replace(R.id.content_frame, tutorial, tutorial.getComponentIdentifier());

        trans.commit();

        mgr.executePendingTransactions();
    }
}
