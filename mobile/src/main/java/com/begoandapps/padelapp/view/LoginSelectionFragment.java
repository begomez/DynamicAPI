package com.begoandapps.padelapp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppButton;
import com.begoandapps.padelapp.components.AppTextView;
import com.begoandapps.padelapp.view.interfaces.ILoginSelectionView;

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

    private ILoginTransaction callback;


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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (this.getActivity() instanceof ILoginTransaction) {
            this.callback = (ILoginTransaction) this.getActivity();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
/////////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.login_selection_btn_facebook)
    public void onFacebookBtnClick() {
        if (this.callback != null) {
            this.callback.launchFacebookLogin();
        }
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

/////////////////////////////////////////////////////////////////////////////////////////////
// INTERFACE DECL
/////////////////////////////////////////////////////////////////////////////////////////////

    public interface ILoginTransaction {
        public void launchFacebookLogin();
    }

}
