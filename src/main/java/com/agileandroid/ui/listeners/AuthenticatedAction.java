package com.agileandroid.ui.listeners;

import android.view.View;

/**
 * Created by Oscar on 20/08/2015.
 */
public abstract class AuthenticatedAction implements Permissionable{

    /**
     * Execute action.
     *
     * @param view implementing onClickListener
     */
    @Override
    public void executeAction(View view) {

    }

    /**
     * Execute user unathorized action.
     *
     * @param view implementing onClickListener
     */
    @Override
    public void executeUserUnathorizedAction(View view) {

    }
}
