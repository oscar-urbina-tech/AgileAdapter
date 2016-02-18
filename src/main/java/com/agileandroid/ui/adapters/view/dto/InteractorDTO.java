package com.agileandroid.ui.adapters.view.dto;

import android.content.Context;

import com.agileandroid.ui.adapters.holder.BaseHolder;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class InteractorDTO<T> {

    private T item;

    private BaseHolder baseHolder;
    private Context context;

    /**
     * Instantiates a new Interactor dTO.
     *
     * @param item the item
     * @param baseHolder the recycler holder
     * @param context the context
     */
    public InteractorDTO(T item, BaseHolder baseHolder, Context context) {
        this.item = item;
        this.baseHolder = baseHolder;
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
    public BaseHolder getBaseHolder() {
        return baseHolder;
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
