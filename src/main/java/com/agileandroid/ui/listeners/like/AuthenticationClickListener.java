package com.agileandroid.ui.listeners.like;

import android.view.View;

/**
 * Created by Oscar on 20/08/2015.
 */
public class AuthenticationClickListener extends AuthenticationClickAction implements View.OnClickListener{

    @Override
    protected void executeUserUnathorizedAction() {}

    @Override
    protected boolean isUserAuthenticated() {
        return false;
    }

    @Override
    protected void executeAction(View v) {}

    @Override
    public void onClick(View v) {

        if (!this.isUserAuthenticated()) {
            this.executeUserUnathorizedAction();
            return;
        }

        this.executeAction(v);
    }
}
