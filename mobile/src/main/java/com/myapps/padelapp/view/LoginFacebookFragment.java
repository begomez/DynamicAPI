package com.myapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.myapps.padelapp.R;
import com.myapps.padelapp.components.AppButton;
import com.myapps.padelapp.components.AppEditText;
import com.myapps.padelapp.utils.MessageUtils;
import com.myapps.padelapp.view.interfaces.ILoginView;
import com.myapps.utils.TextUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class LoginFacebookFragment extends BaseFragment implements ILoginView {

    private static final String TAG = LoginFacebookFragment.class.getSimpleName();

    @BindView(R.id.login_facebook_user)
    protected AppEditText txtUser;

    @BindView(R.id.login_facebook_password)
    protected AppEditText txtPass;

    @BindView(R.id.login_facebook_main_btn)
    protected AppButton btnLogin;


////////////////////////////////////////////////////////////////////////////////////////
// CONSTRUCTOR
////////////////////////////////////////////////////////////////////////////////////////

    public static LoginFacebookFragment newInstance() {
        return new LoginFacebookFragment();
    }

////////////////////////////////////////////////////////////////////////////////////////
// LIFE CYCLE
////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.layoutId = R.layout.fragment_login_facebook;
    }

    @Override
    public void configViews() {
        super.configViews();

        this.txtUser.setText("bego.and.apps@gmail.com");
        this.txtPass.setText("Temp2015oral");
    }

////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.login_facebook_main_btn)
    @Override
    public void onMainBtnClick(View v) {
        MessageUtils.showToast(this.getContext(), "Click");
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
}
