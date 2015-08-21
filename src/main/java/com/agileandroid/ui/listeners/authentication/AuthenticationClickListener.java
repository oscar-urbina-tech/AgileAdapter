package com.agileandroid.ui.listeners.authentication;

import android.view.View;

import com.agileandroid.ui.listeners.AuthenticatedAction;

/**
 * Created by Oscar on 20/08/2015.
 */
public class AuthenticationClickListener extends AuthenticatedAction implements View.OnClickListener{

    @Override
    public void executeUserUnathorizedAction() {}

    @Override
    public void executeAction(View v) {}

    @Override
    public void onClick(View v) {

        if (!super.hasPermission()) {
            this.executeUserUnathorizedAction();
            return;
        }

        this.executeAction(v);
    }
}
