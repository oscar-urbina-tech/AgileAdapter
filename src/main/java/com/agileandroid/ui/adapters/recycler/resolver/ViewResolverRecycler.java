package com.agileandroid.ui.adapters.recycler.resolver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.agileandroid.ui.adapters.recycler.builder.ViewResolverRecyclerBuilder;
import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public abstract class ViewResolverRecycler{

    /**
     * The View resolver builder.
     */
    private ViewResolverRecyclerBuilder viewResolverRecyclerBuilder;

    /**
     * Sets recycler view resolver builder.
     *
     * @param viewResolverRecyclerBuilder the recycler view resolver builder
     */
    public void setViewResolverRecyclerBuilder(ViewResolverRecyclerBuilder viewResolverRecyclerBuilder) {
        this.viewResolverRecyclerBuilder = viewResolverRecyclerBuilder;
    }

    /**
     * Invoke banner gA view resolver.
     *
     * @return the banner gA view resolver
     */
    public HolderRecycler resolve() {

        final LayoutInflater layoutInflater = (LayoutInflater)
                this.viewResolverRecyclerBuilder.getParent().getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return getHolder(layoutInflater.inflate(this.getLayoutResource(), this.viewResolverRecyclerBuilder.getParent(), false));
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
