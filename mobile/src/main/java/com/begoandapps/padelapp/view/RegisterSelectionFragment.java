package com.begoandapps.padelapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppButton;
import com.begoandapps.padelapp.components.AppTextView;
import com.begoandapps.padelapp.utils.ViewUtils;
import com.begoandapps.padelapp.view.interfaces.ILoginSelectionView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class RegisterSelectionFragment extends BaseFragment implements ILoginSelectionView {

    private static final String TAG = RegisterSelectionFragment.class.getSimpleName();

    @BindView(R.id.login_selection_btn_facebook)
    protected AppButton btnFacebook;

    @BindView(R.id.login_selection_btn_manual)
    protected AppButton btnManual;

    @BindView(R.id.login_selection_btn_later)
    protected AppTextView btnLater;

    private IFacebookRegisterNav callbackNav;


/////////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTORS
/////////////////////////////////////////////////////////////////////////////////////////////

    public static RegisterSelectionFragment newInstance() {
        return new RegisterSelectionFragment();
    }

    public RegisterSelectionFragment() {
        super();
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_register_selection;
    }

    @Override
    protected void saveCallback(Context context) {
        super.saveCallback(context);

        if (this.getActivity() instanceof IFacebookRegisterNav) {
            this.callbackNav = (IFacebookRegisterNav) this.getActivity();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////
// ARCH
/////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void prepareWindow() {
        this.hideToolbar();
    }

    @Override
    public void configViews() {
        super.configViews();

        this.btnLater.setText(ViewUtils.getAsSpannable(this.getResources().getString(R.string.login_selection_register_later)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
/////////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.login_selection_btn_facebook)
    public void onFacebookBtnClick() {
        if (this.callbackNav != null) {
            this.callbackNav.launchFacebookRegister();
        }
    }

    @OnClick(R.id.login_selection_btn_manual)
    public void onManualBtnClick() {

    }

    @OnClick(R.id.login_selection_btn_later)
    public void onLaterBtnClick() {
        if (this.callbackNav != null) {
            this.callbackNav.launchDashboard();
        }
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

    public interface IFacebookRegisterNav extends RegisterFacebookFragment.IDashboardNav {
        public void launchFacebookRegister();
    }

}
