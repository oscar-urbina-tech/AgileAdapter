package com.agileandroid.ui.adapters.view.populator;

import com.agileandroid.ui.adapters.AgileAdapterBuilder;
import com.agileandroid.ui.adapters.holder.HolderRecycler;

/**
 * Created by oscar.urbina on 9/2/15.
 *
 * @param <T> the type parameter
 * @param <H> the type parameter
 */
public abstract class Populator<T, H extends HolderRecycler> {

    /**
     * Populate current view.
     *
     * @param agileAdapterBuilder the agile adapter builder
     */
    public abstract void populate(final AgileAdapterBuilder<T, H> agileAdapterBuilder);
}
