package com.agileandroid.ui.listeners.adapters.resolvers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.agileandroid.ui.listeners.adapters.builders.RecyclerViewResolverBuilder;
import com.agileandroid.ui.listeners.adapters.holders.RecyclerHolder;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public abstract class RecyclerViewResolver {

    /**
     * The View resolver builder.
     */
    private RecyclerViewResolverBuilder recyclerViewResolverBuilder;

    /**
     * Sets recycler view resolver builder.
     *
     * @param recyclerViewResolverBuilder the recycler view resolver builder
     */
    public void setRecyclerViewResolverBuilder(RecyclerViewResolverBuilder recyclerViewResolverBuilder) {
        this.recyclerViewResolverBuilder = recyclerViewResolverBuilder;
    }

    /**
     * Invoke banner gA view resolver.
     *
     * @return the banner gA view resolver
     */
    public RecyclerHolder resolve() {

        final LayoutInflater layoutInflater = (LayoutInflater)
                this.recyclerViewResolverBuilder.getParent().getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return getHolder(layoutInflater.inflate(this.getLayoutResource(), this.recyclerViewResolverBuilder.getParent(), false));
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
    protected abstract RecyclerHolder getHolder(View view);
}
