package com.myapps.padelapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myapps.padelapp.R;
import com.myapps.padelapp.components.AppButton;
import com.myapps.padelapp.components.AppEditText;
import com.myapps.padelapp.view.interfaces.ILoginView;

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

    @BindView(R.id.login_facebook_btn)
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

////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.login_facebook_btn)
    public void onLoginBtnClick() {

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
}
