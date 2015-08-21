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
     * @param v the v
     */
    @Override
    public void executeAction(View v) {
        super.executeAction(v);
    }

    /**
     * Execute user unathorized action.
     */
    @Override
    public void executeUserUnathorizedAction(View v) {
        super.executeUserUnathorizedAction(v);
    }

    @Override
    public void onClick(View v) {

        if (!this.hasPermission()) {
            this.executeUserUnathorizedAction(v);
            return;
        }

        this.executeAction(v);
    }
}
