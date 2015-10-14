package com.agileandroid.ui.adapters.view.resolver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.agileandroid.ui.adapters.recycler.builder.AgileRecyclerBuilder;
import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;
import com.agileandroid.ui.adapters.view.builders.ViewResolverBuilder;
import com.agileandroid.ui.adapters.view.interactor.Interactor;
import com.agileandroid.ui.adapters.view.populator.Populator;

/**
 * Created by oscar.urbina on 7/17/15.
 */
public abstract class ViewResolver {

    /**
     * Sets view resolver builder.
     *
     * @param viewResolverBuilder the view resolver builder
     */
    public void setViewResolverBuilder(ViewResolverBuilder viewResolverBuilder) {
        this.viewResolverBuilder = viewResolverBuilder;
    }

    /**
     * The View resolver builder.
     */
    protected ViewResolverBuilder viewResolverBuilder;

    /**
     * Invoke banner gA view resolver.
     *
     * @return the banner gA view resolver
     */
    public View resolve() {

        HolderRecycler recyclerHolder;

        View convertView = viewResolverBuilder.getConvertView();

        if (convertView == null) {

            final LayoutInflater layoutInflater = (LayoutInflater)
                    viewResolverBuilder.getParent().getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(this.getLayoutResource(), viewResolverBuilder.getParent(), false);

            recyclerHolder = this.getHolder(convertView);

            convertView.setTag(recyclerHolder);

        } else {
            recyclerHolder = (HolderRecycler)convertView.getTag();
        }

        Populator populator = viewResolverBuilder.getAgileAdapterDTO().getPopulator();

        AgileRecyclerBuilder agileRecyclerBuilder
                = new AgileRecyclerBuilder.Builder<>(recyclerHolder)
                .setContext(viewResolverBuilder.getParent().getContext())
                .setItem(viewResolverBuilder.getItem()).build();

        populator.populate(agileRecyclerBuilder);

        if(viewResolverBuilder.getAgileAdapterDTO().getInteractor() != null){
            Interactor interactor = viewResolverBuilder.getAgileAdapterDTO().getInteractor();
            interactor.setInteraction(agileRecyclerBuilder);
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
