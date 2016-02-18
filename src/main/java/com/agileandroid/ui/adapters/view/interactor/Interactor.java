package com.agileandroid.ui.adapters.view.interactor;

import com.agileandroid.ui.adapters.recycler.builder.AgileAdapterBuilder;
import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;

/**
 * Created by oscar.urbina on 8/28/15.
 *
 * @param <T> the type parameter
 * @param <H> the type parameter
 */
public abstract class Interactor<T, H extends HolderRecycler> {

    /**
     * Sets interaction.
     *
     * @param agileAdapterBuilder the agile adapter builder
     */
    public abstract void setInteraction(AgileAdapterBuilder<T, H> agileAdapterBuilder);
}
