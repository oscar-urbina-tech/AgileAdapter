package com.agileandroid.ui.listeners.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.agileandroid.ui.listeners.adapters.builders.AgileRecyclerBuilder;
import com.agileandroid.ui.listeners.adapters.builders.ViewResolverRecyclerBuilder;
import com.agileandroid.ui.listeners.adapters.dto.AgileAdapterDTORecycler;
import com.agileandroid.ui.listeners.adapters.dto.InteractorDTO;
import com.agileandroid.ui.listeners.adapters.holders.HolderRecycler;
import com.agileandroid.ui.listeners.adapters.interactors.Interactor;
import com.agileandroid.ui.listeners.adapters.populators.Populator;
import com.agileandroid.ui.listeners.adapters.resolvers.ViewResolverRecycler;

import java.util.List;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class AgileRecyclerAdapter extends RecyclerView.Adapter<HolderRecycler>{

    /**
     * The Posts list.
     */
    protected List itemList;
    private Context context;

    private AgileAdapterDTORecycler agileAdapterDTORecycler;

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList the item list
     * @param agileAdapterDTORecycler the agile adapter dTO
     */
    public AgileRecyclerAdapter(List itemList, AgileAdapterDTORecycler agileAdapterDTORecycler) {
        this.itemList = itemList;
        this.agileAdapterDTORecycler = agileAdapterDTORecycler;
    }

    /**
     * Sets posts list.
     *
     * @param itemList the posts list
     */
    public void setItemList(List itemList) {
        this.itemList = itemList;
    }


    /*
    @Override
    public int getItemViewType(int position) {
        return this.itemList.get(position).getItemType();
    }*/


    @Override
    public HolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        final ViewResolverRecyclerBuilder viewResolverRecyclerBuilder =
                new ViewResolverRecyclerBuilder.Builder(parent, viewType)
                        .build();

        final ViewResolverRecycler viewResolverRecycler = this.agileAdapterDTORecycler.getViewResolverRecycler();
        viewResolverRecycler.setViewResolverRecyclerBuilder(viewResolverRecyclerBuilder);

        return viewResolverRecycler.resolve();
    }

    @Override
    public void onBindViewHolder(HolderRecycler holder, final int position) {

        final Object currentPostItem = this.itemList.get(position);

        AgileRecyclerBuilder agileRecyclerBuilder = new AgileRecyclerBuilder.Builder(holder)
                .setContext(this.context)
                .setItem(currentPostItem)
                .build();

        Populator populator = this.agileAdapterDTORecycler.getPopulator();
        populator.populate(agileRecyclerBuilder);

        if(this.agileAdapterDTORecycler.getInteractor() != null){

            this.handleCustomInteractions(holder, currentPostItem);
        }
    }

    /**
     * Add listeners to several view interactable items in current view
     *
     * @param holder Current holder element
     * @param currentItem Current Post
     */
    private void handleCustomInteractions(final HolderRecycler holder, final Object currentItem) {

        final InteractorDTO<Object> interactorDTO = new InteractorDTO<>(currentItem, holder, this.context);

        Interactor interactor = this.agileAdapterDTORecycler.getInteractor();
        interactor.setInteraction(interactorDTO);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    /**
     * Add post.
     *
     * @param item the item
     */
    public void addItem(Object item) {
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    /**
     * Update posts list.
     *
     * @param newItemList the new item list
     */
    public void appendNewItemList(List<?> newItemList){

        for(Object item : newItemList){
            this.itemList.add(item);
        }
        notifyDataSetChanged();
    }

    /**
     * Clear posts list.
     */
    public void clearItemList() {
        this.itemList.clear();
        notifyDataSetChanged();
    }
}
