package com.agileandroid.ui.adapters.recycler.interactor;

import com.agileandroid.ui.adapters.recycler.builder.AgileAdapterBuilder;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public abstract class Interactor{

    /**
     * Sets interaction.
     * @param agileAdapterBuilder the agile recycler builder
     */
    public abstract void setInteraction(AgileAdapterBuilder agileAdapterBuilder);
}
