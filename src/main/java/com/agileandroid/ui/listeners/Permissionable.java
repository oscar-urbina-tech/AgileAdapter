package com.agileandroid.ui.listeners;

import android.view.View;

/**
 * Created by oscar.urbina on 8/21/15.
 */
public interface Permissionable {

    /**
     * Execute action.
     *
     * @param view implementing onClickListener
     */
    void executeAction(View view);

    /**
     * Execute user unathorized action.
     *
     * @param view implementing onClickListener
     */
    void executeUserUnathorizedAction(View view);
}
