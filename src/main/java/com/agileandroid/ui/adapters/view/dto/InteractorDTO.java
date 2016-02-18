package com.agileandroid.ui.adapters.view.dto;

import android.content.Context;

import com.agileandroid.ui.adapters.holder.HolderRecycler;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class InteractorDTO<T> {

    private T item;

    private HolderRecycler holderRecycler;
    private Context context;

    /**
     * Instantiates a new Interactor dTO.
     *
     * @param item the item
     * @param holderRecycler the recycler holder
     * @param context the context
     */
    public InteractorDTO(T item, HolderRecycler holderRecycler, Context context) {
        this.item = item;
        this.holderRecycler = holderRecycler;
        this.context = context;
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Gets recycler holder.
     *
     * @return the recycler holder
     */
    public HolderRecycler getHolderRecycler() {
        return holderRecycler;
    }

    /**
     * Gets item.
     *
     * @return the item
     */
    public T getItem() {
        return item;
    }
}
