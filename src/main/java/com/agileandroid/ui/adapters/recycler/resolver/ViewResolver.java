package com.agileandroid.ui.adapters.recycler.resolver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agileandroid.ui.adapters.holder.HolderRecycler;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public abstract class ViewResolver {

    /**
     * Resolves current view defined in getLayoutResource method.
     *
     * @return the holder with a view reference related to the layout resource
     */
    public HolderRecycler resolve(final ViewGroup parent) {

        final LayoutInflater layoutInflater
                = LayoutInflater.from(parent.getContext());

        return getHolder(layoutInflater.inflate(this.getLayoutResource(), parent, false));
    }

    /**
     * Gets layout resource.
     *
     * @return the layout resource
     */
    protected abstract int getLayoutResource();

    /**
     * Gets holder.
     *
     * @param view the view
     * @return the holder
     */
    protected abstract HolderRecycler getHolder(View view);
}
