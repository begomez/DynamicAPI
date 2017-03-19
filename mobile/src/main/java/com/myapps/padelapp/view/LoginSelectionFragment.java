package com.myapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapps.padelapp.R;
import com.myapps.padelapp.components.AppButton;
import com.myapps.padelapp.components.AppTextView;
import com.myapps.padelapp.view.interfaces.ILoginSelectionView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class LoginSelectionFragment extends BaseFragment implements ILoginSelectionView {

    private static final String TAG = LoginSelectionFragment.class.getSimpleName();

    @BindView(R.id.login_selection_btn_facebook)
    protected AppButton btnFacebook;

    @BindView(R.id.login_selection_btn_manual)
    protected AppButton btnManual;

    @BindView(R.id.login_selection_btn_later)
    protected AppTextView btnLater;

/////////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
/////////////////////////////////////////////////////////////////////////////////////////////

    public static LoginSelectionFragment newInstance() {
        return new LoginSelectionFragment();
    }

    public LoginSelectionFragment() {
        super();
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_login_selection;
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
/////////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.login_selection_btn_facebook)
    public void onFacebookBtnClick() {

    }

    @OnClick(R.id.login_selection_btn_manual)
    public void onManualBtnClick() {

    }

    @OnClick(R.id.login_selection_btn_later)
    public void onLaterBtnClick() {

    }

/////////////////////////////////////////////////////////////////////////////////////////////
// ILOGINSELECTIONVIEW IMPL
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
