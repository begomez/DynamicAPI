package com.begoandapps.padelapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.view.BaseActivity;

public class PadelActivity extends BaseActivity {

//////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
//////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layoutId = R.layout.activity_padel;

        super.onCreate(savedInstanceState);

    }

//////////////////////////////////////////////////////////////////////////////////
// INTERACTION
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onMainBtnClick(View v) {
        super.onMainBtnClick(v);
    }
}
