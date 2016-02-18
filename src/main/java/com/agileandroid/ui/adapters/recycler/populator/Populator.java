package com.agileandroid.ui.adapters.recycler.populator;

import com.agileandroid.ui.adapters.AgileAdapterBuilder;
import com.agileandroid.ui.adapters.holder.BaseHolder;

/**
 * Created by oscar.urbina on 8/28/15.
 *
 * @param <T> the type parameter
 * @param <H> the type parameter
 */
public abstract class Populator<T, H extends BaseHolder>{

    /**
     * Populate current view.
     *
     * @param agileAdapterBuilder the agile adapter builder
     */
    public abstract void populate(final AgileAdapterBuilder<T, H> agileAdapterBuilder);
}
