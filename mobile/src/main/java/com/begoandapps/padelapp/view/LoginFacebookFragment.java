package com.begoandapps.padelapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.begoandapps.padelapp.R;
import com.begoandapps.padelapp.components.AppButton;
import com.begoandapps.padelapp.components.AppEditText;
import com.begoandapps.padelapp.presenter.LoginFacebookPresenter;
import com.begoandapps.padelapp.utils.MessageUtils;
import com.begoandapps.padelapp.view.interfaces.ILoginFacebookView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.myapps.utils.TextUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bernatgomez on 19/3/17.
 */

public class LoginFacebookFragment extends BaseFragment implements ILoginFacebookView {

    private static final String TAG = LoginFacebookFragment.class.getSimpleName();

    @BindView(R.id.login_facebook_user)
    protected AppEditText txtUser;

    @BindView(R.id.login_facebook_password)
    protected AppEditText txtPass;

    @BindView(R.id.login_facebook_main_btn)
    protected AppButton btnLogin;

    private IDashboardNavigation callback;

    private LoginFacebookPresenter presenter;

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
    public void configViews() {
        super.configViews();

        this.txtUser.setText("bego.and.apps.test1@gmail.com");
        this.txtPass.setText("begotest1");
    }

    @Override
    protected void initPresenters() {
        super.initPresenters();

        this.presenter = new LoginFacebookPresenter();

        this.presenter.attachView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (this.getActivity() instanceof IDashboardNavigation) {
            this.callback = (IDashboardNavigation) this.getActivity();
        }
    }

////////////////////////////////////////////////////////////////////////////////////////
// INTERACTION
////////////////////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.login_facebook_btn)
    public void onFacebookBtnClick(View v) {
        //MessageUtils.showToast(this.getContext(), "1");

        //test();

        this.presenter.doLogin();

        //onLoginSuccess();
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
    public void onLoginSuccess() {
        MessageUtils.showToast(getContext(), "Success!");

        if (this.callback != null) {
            this.callback.launchDashboard();
        }
    }

    @Override
    public void onLoginError(String msg) {
        MessageUtils.showToast(getContext(), "Error " + msg);

        if (this.callback != null) {
            this.callback.launchDashboard();
        }

    }

////////////////////////////////////////////////////////////////////////////////////////
// ILOGINVIEW IMPL
////////////////////////////////////////////////////////////////////////////////////////

    private void test() {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(this.getUser(), this.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            MessageUtils.showToast(getContext(), "Success!");

                        } else {
                            MessageUtils.showToast(getContext(), "Error " + task.getException().toString());
                        }
                    }
                }
            );
    }

////////////////////////////////////////////////////////////////////////////////////////
// INTERFACE DECL
////////////////////////////////////////////////////////////////////////////////////////

    public interface IDashboardNavigation {
        public void launchDashboard();
    }

}
