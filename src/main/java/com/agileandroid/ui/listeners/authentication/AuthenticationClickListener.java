package com.agileandroid.ui.listeners.authentication;

import android.view.View;

import com.agileandroid.ui.listeners.AuthenticatedAction;

/**
 * Created by Oscar on 20/08/2015.
 */
public class AuthenticationClickListener extends AuthenticatedAction implements View.OnClickListener {

    /**
     * The permission.
     */
    private boolean permission;

    /**
     * Sets permission.
     *
     * @param permission the permission
     */
    private void setPermission(boolean permission) {
        this.permission = permission;
    }

    /**
     * User has permission.
     *
     * @return the boolean
     */
    private boolean hasPermission() {
        return this.permission;
    }

    /**
     * Instantiates a new Authentication click listener.
     *
     * @param isUserAuthenticated the is user authenticated
     */
    protected AuthenticationClickListener(boolean isUserAuthenticated) {
        this.setPermission(isUserAuthenticated);
    }

    /**
     * Execute action.
     *
     * @param view implementing onClickListener
     */
    @Override
    public void executeAction(View view) {
        super.executeAction(view);
    }

    /**
     * Execute user unathorized action.
     *
     * @param view implementing onClickListener
     */
    @Override
    public void executeUserUnathorizedAction(View view) {
        super.executeUserUnathorizedAction(view);
    }

    /**
     *
     * @param view Current view
     */
    @Override
    public void onClick(View view) {

        if (!this.hasPermission()) {
            this.executeUserUnathorizedAction(view);
            return;
        }

        this.executeAction(view);
    }
}
