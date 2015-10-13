package com.agileandroid.ui.adapters.recycler.dto;

import com.agileandroid.ui.adapters.TypableView;
import com.agileandroid.ui.adapters.recycler.interactor.Interactor;

import com.agileandroid.ui.adapters.recycler.populator.Populator;
import com.agileandroid.ui.adapters.recycler.resolver.ViewResolverRecycler;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class AgileAdapterDTORecycler implements TypableView{

    private Populator populator;
    private ViewResolverRecycler viewResolverRecycler;
    private Interactor interactor;
    private int itemViewType;

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolverRecycler the recycler view resolver
     * @param populator the populator
     */
    public AgileAdapterDTORecycler(ViewResolverRecycler viewResolverRecycler, Populator populator) {
        this.populator = populator;
        this.viewResolverRecycler = viewResolverRecycler;
    }

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolverRecycler the recycler view resolver
     * @param populator the populator
     * @param interactor the interactor
     */
    public AgileAdapterDTORecycler(ViewResolverRecycler viewResolverRecycler, Populator populator, Interactor interactor) {

        this.populator = populator;
        this.viewResolverRecycler = viewResolverRecycler;
        this.interactor = interactor;
    }

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolverRecycler the recycler view resolver
     * @param populator the populator
     */
    public AgileAdapterDTORecycler(ViewResolverRecycler viewResolverRecycler, Populator populator, int itemViewType) {
        this.populator = populator;
        this.viewResolverRecycler = viewResolverRecycler;
        this.itemViewType = itemViewType;
    }

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolverRecycler the recycler view resolver
     * @param populator the populator
     * @param interactor the interactor
     */
    public AgileAdapterDTORecycler(ViewResolverRecycler viewResolverRecycler, Populator populator, Interactor interactor, int itemViewType) {

        this.populator = populator;
        this.viewResolverRecycler = viewResolverRecycler;
        this.interactor = interactor;
        this.itemViewType = itemViewType;
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
    public ViewResolverRecycler getViewResolverRecycler() {
        return viewResolverRecycler;
    }

    /**
     * Gets interactor.
     *
     * @return the interactor
     */
    public Interactor getInteractor() {
        return interactor;
    }

    @Override
    public int getViewType() {
        return this.itemViewType;
    }
}
