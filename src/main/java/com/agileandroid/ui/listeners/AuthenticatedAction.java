package com.agileandroid.ui.listeners;

import android.view.View;

/**
 * Created by Oscar on 20/08/2015.
 */
public abstract class AuthenticatedAction implements Permissionable{

    /**
     * The permission.
     */
    private boolean permission;

    /**
     * Execute action.
     *
     * @param v the v
     */
    @Override
    public void executeAction(View v) {

    }

    /**
     * User has permission.
     *
     * @return the boolean
     */
    protected boolean hasPermission() {
        return this.permission;
    }

    /**
     * Set user permission
     *
     * @param permission
     */
    @Override
    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    /**
     * Execute user unathorized action.
     */
    @Override
    public void executeUserUnathorizedAction() {

    }
}
