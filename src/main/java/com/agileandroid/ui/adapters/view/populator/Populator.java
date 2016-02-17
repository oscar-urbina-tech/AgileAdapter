package com.agileandroid.ui.adapters.view.populator;

import com.agileandroid.ui.adapters.recycler.builder.AgileAdapterBuilder;

/**
 * Created by oscar.urbina on 9/2/15.
 */
public abstract class Populator {

    /**
     * Populate current view.
     */
    public abstract void populate(final AgileAdapterBuilder agileAdapterBuilder);
}
