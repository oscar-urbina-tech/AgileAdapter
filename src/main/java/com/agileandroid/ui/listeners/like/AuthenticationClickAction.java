package com.agileandroid.ui.listeners.like;

import android.view.View;

import com.agileandroid.ui.listeners.AuthenticatedAction;

/**
 * Created by Oscar on 20/08/2015.
 */
public abstract class AuthenticationClickAction extends AuthenticatedAction {

    protected abstract void executeAction(View v);
}
