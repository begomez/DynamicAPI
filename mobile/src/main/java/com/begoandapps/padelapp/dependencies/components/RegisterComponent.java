package com.begoandapps.padelapp.dependencies.components;


import com.begoandapps.padelapp.dependencies.modules.RegisterModule;
import com.begoandapps.padelapp.dependencies.scopes.PerActivity;
import com.begoandapps.padelapp.view.enroll.RegisterFacebookFragment;

import dagger.Component;


/**
 * Created by bernatgomez on 22/3/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules={RegisterModule.class})
public interface RegisterComponent {

    /**
     *
     * @param frag
     */
    public void inject(RegisterFacebookFragment frag);
}
