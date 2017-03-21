package com.myapps.padelapp.view;

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
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_padel);
    }

//////////////////////////////////////////////////////////////////////////////////
// INTERACTION
//////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onMainBtnClick(View v) {
        super.onMainBtnClick(v);
    }
}
