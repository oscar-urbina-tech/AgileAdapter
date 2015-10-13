package com.agileandroid.ui.adapters.view.interactor;

import com.agileandroid.ui.listeners.BaseOnClickListener;
import com.agileandroid.ui.adapters.view.dto.InteractorDTO;

import java.util.List;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public abstract class Interactor {

    /**
     * The Populator builder.
     */
    protected InteractorDTO interactorDTO;

    /**
     * The Click listener provider.
     */
    protected List<BaseOnClickListener> baseOnClickListenerList;

    /**
     * Instantiates a new Interactor.
     *
     * @param interactorDTO the interactor dTO
     * @param baseOnClickListenerList the base on click listener list
     */
    public Interactor(InteractorDTO interactorDTO, List<BaseOnClickListener> baseOnClickListenerList) {
        this.interactorDTO = interactorDTO;
        this.baseOnClickListenerList = baseOnClickListenerList;
    }

    /**
     * Sets interaction.
     */
    public abstract void setInteraction(InteractorDTO interactorDTO);
}
