package com.agileandroid.ui.adapters.recycler.dto;

import com.agileandroid.ui.adapters.TypableView;
import com.agileandroid.ui.adapters.recycler.interactor.Interactor;
import com.agileandroid.ui.adapters.recycler.populator.Populator;
import com.agileandroid.ui.adapters.recycler.resolver.ViewResolver;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class AgileAdapterDTO implements TypableView{

    /**
     * The Populator.
     */
    private Populator populator;
    /**
     * The View resolver.
     */
    private ViewResolver viewResolver;
    /**
     * The Interactor.
     */
    private Interactor interactor;
    /**
     * The Item view type.
     */
    private int itemViewType;

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolver the recycler view resolver
     * @param populator    the populator
     */
    public AgileAdapterDTO(ViewResolver viewResolver, Populator populator) {
        this.populator = populator;
        this.viewResolver = viewResolver;
    }

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolver the recycler view resolver
     * @param populator    the populator
     * @param interactor   the interactor
     */
    public AgileAdapterDTO(ViewResolver viewResolver, Populator populator, Interactor interactor) {
        this.populator = populator;
        this.viewResolver = viewResolver;
        this.interactor = interactor;
    }

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolver the recycler view resolver
     * @param populator    the populator
     * @param itemViewType the item view type
     */
    public AgileAdapterDTO(ViewResolver viewResolver, Populator populator, int itemViewType) {
        this.populator = populator;
        this.viewResolver = viewResolver;
        this.itemViewType = itemViewType;
    }

    /**
     * Instantiates a new Agile adapter dTO.
     *
     * @param viewResolver the recycler view resolver
     * @param populator    the populator
     * @param interactor   the interactor
     * @param itemViewType the item view type
     */
    public AgileAdapterDTO(ViewResolver viewResolver, Populator populator, Interactor interactor, int itemViewType) {
        this.populator = populator;
        this.viewResolver = viewResolver;
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
    public ViewResolver getViewResolver() {
        return viewResolver;
    }

    /**
     * Gets interactor.
     *
     * @return the interactor
     */
    public Interactor getInteractor() {
        return interactor;
    }

    /**
     * Gets view type.
     *
     * @return the view type
     */
    @Override
    public int getViewType() {
        return this.itemViewType;
    }
}
