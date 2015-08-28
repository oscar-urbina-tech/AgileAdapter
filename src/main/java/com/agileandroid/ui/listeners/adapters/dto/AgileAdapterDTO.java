package com.agileandroid.ui.listeners.adapters.dto;

import com.agileandroid.ui.listeners.adapters.Agilable;
import com.agileandroid.ui.listeners.adapters.interactors.Interactor;
import com.agileandroid.ui.listeners.adapters.populators.Populator;
import com.agileandroid.ui.listeners.adapters.resolvers.RecyclerViewResolver;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class AgileAdapterDTO implements Agilable {

    private Populator populator;
    private RecyclerViewResolver recyclerViewResolver;
    private Interactor interactor;

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param recyclerViewResolver the recycler view resolver
     * @param populator the populator
     */
    public AgileAdapterDTO(RecyclerViewResolver recyclerViewResolver, Populator populator) {
        this.populator = populator;
        this.recyclerViewResolver = recyclerViewResolver;
    }

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param recyclerViewResolver the recycler view resolver
     * @param populator the populator
     * @param interactor the interactor
     */
    public AgileAdapterDTO(RecyclerViewResolver recyclerViewResolver, Populator populator, Interactor interactor) {

        this.populator = populator;
        this.recyclerViewResolver = recyclerViewResolver;
        this.interactor = interactor;
    }

    /**
     * Gets populator.
     *
     * @return the populator
     */
    public Populator getPopulator() {
        return populator;
    }

    /**
     * Gets recycler view resolver.
     *
     * @return the recycler view resolver
     */
    public RecyclerViewResolver getRecyclerViewResolver() {
        return recyclerViewResolver;
    }

    /**
     * Gets interactor.
     *
     * @return the interactor
     */
    public Interactor getInteractor() {
        return interactor;
    }
}
