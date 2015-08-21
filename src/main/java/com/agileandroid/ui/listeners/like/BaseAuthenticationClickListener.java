package com.agileandroid.ui.listeners.like;

import android.view.View;

/**
 * Created by Oscar on 20/08/2015.
 */
public class BaseAuthenticationClickListener extends AuthenticationClickListener {

    @Override
    protected void executeAction(View v) {

    }

    @Override
    protected void executeUserUnathorizedAction() {

    }

    @Override
    protected boolean isUserAuthenticated() {
        return false;
    }
}
