package com.agileandroid.ui.listeners;

import android.view.View;

/**
 * Created by Oscar on 20/08/2015.
 */
public abstract class AuthenticatedAction implements Permissionable{

    /**
     * Execute action.
     *
     * @param v the v
     */
    @Override
    public void executeAction(View v) {

    }

    /**
     * Execute user unathorized action.
     */
    @Override
    public void executeUserUnathorizedAction(View v) {

    }
}
