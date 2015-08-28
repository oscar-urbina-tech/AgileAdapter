package com.agileandroid.ui.listeners.adapters.populators;

import com.agileandroid.ui.listeners.adapters.builders.PopulatorBuilder;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public abstract class Populator {

    /**
     * Populate current view.
     */
    public abstract void populate(PopulatorBuilder populatorBuilder);
}
