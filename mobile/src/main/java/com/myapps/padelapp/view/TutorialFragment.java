package com.myapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.myapps.padelapp.R;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class TutorialFragment extends BaseFragment {

    public static TutorialFragment newInstance() {
        TutorialFragment frag = new TutorialFragment();

        Bundle extras = new Bundle();

        frag.setArguments(extras);

        return frag;
    }

/////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = LayoutInflater.from(this.getContext()).inflate(R.layout.fragment_tutorial, container);

        return v;
    }
}
