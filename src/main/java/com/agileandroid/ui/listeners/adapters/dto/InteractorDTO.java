package com.agileandroid.ui.listeners.adapters.dto;

import android.content.Context;

import com.agileandroid.ui.listeners.adapters.holders.RecyclerHolder;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class InteractorDTO<T> {

    private T item;

    private RecyclerHolder recyclerHolder;
    private Context context;

    /**
     * Instantiates a new Interactor dTO.
     *
     * @param item the item
     * @param recyclerHolder the recycler holder
     * @param context the context
     */
    public InteractorDTO(T item, RecyclerHolder recyclerHolder, Context context) {
        this.item = item;
        this.recyclerHolder = recyclerHolder;
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
    public RecyclerHolder getRecyclerHolder() {
        return recyclerHolder;
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
