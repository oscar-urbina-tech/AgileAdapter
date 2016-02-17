package com.agileandroid.ui.adapters.view.resolver;

import android.view.LayoutInflater;
import android.view.View;

import com.agileandroid.ui.adapters.recycler.builder.AgileAdapterBuilder;
import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;
import com.agileandroid.ui.adapters.view.builders.ViewResolverBuilder;
import com.agileandroid.ui.adapters.view.interactor.Interactor;
import com.agileandroid.ui.adapters.view.populator.Populator;

/**
 * Created by oscar.urbina on 7/17/15.
 */
public abstract class ViewResolver {

    /**
     * Invoke banner gA view resolver.
     *
     * @return the banner gA view resolver
     */
    public <T> View resolve(final ViewResolverBuilder<T> viewResolverBuilder) {

        HolderRecycler recyclerHolder;

        View convertView = viewResolverBuilder.getConvertView();

        if (convertView == null) {

            final LayoutInflater layoutInflater
                    = LayoutInflater.from(viewResolverBuilder.getParent().getContext());

            convertView
                    = layoutInflater.inflate(this.getLayoutResource(), viewResolverBuilder.getParent(), false);

            recyclerHolder = this.getHolder(convertView);

            convertView.setTag(recyclerHolder);

        } else {
            recyclerHolder = (HolderRecycler) convertView.getTag();
        }

        final Populator populator = viewResolverBuilder.getAgileAdapterDTO().getPopulator();

        final AgileAdapterBuilder<T> agileAdapterBuilder
                = new AgileAdapterBuilder.Builder<T>(recyclerHolder)
                    .setContext(viewResolverBuilder.getParent().getContext())
                    .setItem(viewResolverBuilder.getItem()).build();

        populator.populate(agileAdapterBuilder);

        if (viewResolverBuilder.getAgileAdapterDTO().getInteractor() != null) {
            final Interactor interactor = viewResolverBuilder.getAgileAdapterDTO().getInteractor();
            interactor.setInteraction(agileAdapterBuilder);
        }

        return convertView;
    }

    /**
     * Sets gA banner view.
     *
     * @param convertView the convert view
     * @return the gA banner view
     */
    protected abstract HolderRecycler getHolder(View convertView);

    /**
     * Gets layout resource.
     *
     * @return the layout resource
     */
    protected abstract int getLayoutResource();
}
