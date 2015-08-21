package com.agileandroid.ui.listeners;

import android.view.View;

/**
 * Created by oscar.urbina on 8/21/15.
 */
public interface Permissionable {

    /**
     * Execute action.
     *
     * @param v the v
     */
    void executeAction(View v);

    /**
     * Execute user unathorized action.
     */
    void executeUserUnathorizedAction(View v);
}
