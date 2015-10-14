package com.agileandroid.ui.adapters.view.interactor;

import com.agileandroid.ui.adapters.recycler.builder.AgileRecyclerBuilder;
import com.agileandroid.ui.listeners.BaseOnClickListener;
import com.agileandroid.ui.adapters.view.dto.InteractorDTO;

import java.util.List;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public abstract class Interactor {

    /**
     * Sets interaction.
     */
    public abstract void setInteraction(AgileRecyclerBuilder agileRecyclerBuilder);
}
