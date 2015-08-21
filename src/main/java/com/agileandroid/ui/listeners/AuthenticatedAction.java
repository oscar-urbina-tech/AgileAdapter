package com.agileandroid.ui.listeners;

/**
 * Created by Oscar on 20/08/2015.
 */
public abstract class AuthenticatedAction {

    protected abstract void executeUserUnathorizedAction();

    protected abstract boolean isUserAuthenticated();
}
