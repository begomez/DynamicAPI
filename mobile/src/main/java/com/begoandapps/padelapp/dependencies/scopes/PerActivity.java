package com.begoandapps.padelapp.dependencies.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by bernatgomez on 28/3/17.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
