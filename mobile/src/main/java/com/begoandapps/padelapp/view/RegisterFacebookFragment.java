package com.begoandapps.padelapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppButton;
import com.begoandapps.padelapp.components.AppEditText;
import com.begoandapps.padelapp.dependencies.components.DaggerRegisterComponent;
import com.begoandapps.padelapp.dependencies.modules.RegisterModule;
import com.begoandapps.padelapp.presenter.RegisterFacebookPresenter;
import com.begoandapps.padelapp.utils.MessageUtils;
import com.begoandapps.padelapp.view.interfaces.IRegisterFacebookView;
import com.myapps.utils.TextUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class RegisterFacebookFragment extends BaseFragment implements IRegisterFacebookView {

    private static final String TAG = RegisterFacebookFragment.class.getSimpleName();

    @BindView(R.id.login_facebook_user)
    protected AppEditText txtUser;

    @BindView(R.id.login_facebook_password)
    protected AppEditText txtPass;

    @BindView(R.id.login_facebook_main_btn)
    protected AppButton btnLogin;

    private IDashboardNav callback;

    @Inject
    protected RegisterFacebookPresenter presenter;


////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
////////////////////////////////////////////////////////////////////////////////////////

    public static RegisterFacebookFragment newInstance() {
        return new RegisterFacebookFragment();
    }

////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_register_facebook;
    }

    @Override
    public void onStart() {
        super.onStart();

        this.presenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();

        this.presenter.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void saveCallback(Context context) {
        super.saveCallback(context);

        if (this.getActivity() instanceof IDashboardNav) {
            this.callback = (IDashboardNav) this.getActivity();
        }
    }

////////////////////////////////////////////////////////////////////////////////////////
// ARCHITECTURE
////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void prepareWindow() {
        super.prepareWindow();

        this.showToolbar();
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();

        DaggerRegisterComponent.builder().applicationComponent(this.getApplicationComponent()).registerModule(new RegisterModule()).build().inject(this);
    }

    @Override
    public void configViews() {
        super.configViews();

        this.txtUser.setText(this.getString(R.string.facebook_user));
        this.txtPass.setText(this.getString(R.string.facebook_pass));
    }

    @Override
    protected void bindPresentersAndViews() {
        super.bindPresentersAndViews();

        this.presenter.attachView(this);
    }

////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.login_facebook_btn)
    public void onFacebookBtnClick(View v) {

        this.presenter.doRegistration();
    }

    @OnClick(R.id.login_facebook_main_btn)
    @Override
    public void onMainBtnClick(View v) {
        MessageUtils.showToast(this.getContext(), "2");
    }

////////////////////////////////////////////////////////////////////////////////////////
// ILOGINVIEW IMPL
////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public String getUser() {
        return TextUtils.trim(this.txtUser.getText().toString());
    }

    @Override
    public String getPassword() {
        return TextUtils.trim(this.txtPass.getText().toString());
    }

    @Override
    public void onRegisterSuccess() {
        if (this.callback != null) {
            this.callback.launchDashboard();
        }
    }

    @Override
    public void onRegisterError(String msg) {
        MessageUtils.showToast(getContext(), "Error " + msg);
    }

////////////////////////////////////////////////////////////////////////////////////////
// INTERFACE DECL
////////////////////////////////////////////////////////////////////////////////////////

    public interface IDashboardNav {
        public void launchDashboard();
    }

}
