package com.agileandroid.ui.adapters.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.ViewGroup;

import com.agileandroid.ui.adapters.TypableView;

import com.agileandroid.ui.adapters.recycler.populator.Populator;
import com.agileandroid.ui.adapters.recycler.builder.AgileRecyclerBuilder;

import com.agileandroid.ui.adapters.recycler.dto.AgileAdapterDTORecycler;

import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;
import com.agileandroid.ui.adapters.recycler.interactor.Interactor;

import com.agileandroid.ui.adapters.recycler.resolver.ViewResolverRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class AgileRecyclerAdapter<T extends TypableView> extends RecyclerView.Adapter<HolderRecycler>{

    /**
     * The log tag
     */
    private static final String LOG_TAG = AgileRecyclerAdapter.class.getSimpleName();

    /**
     * The Item list.
     */
    protected List<T> itemList;

    /**
     * The ViewGroup parent context
     */
    private Context context;

    /**
     * The agile adapter DTO Recycler list
     */
    private List<AgileAdapterDTORecycler> agileAdapterDTORecyclerList;

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList the item list
     * @param agileAdapterDTORecycler the agile adapter dTO
     */
    public AgileRecyclerAdapter(List<T> itemList, AgileAdapterDTORecycler agileAdapterDTORecycler) {
        this.itemList = itemList;
        this.agileAdapterDTORecyclerList = new ArrayList<>();
        this.agileAdapterDTORecyclerList.add(agileAdapterDTORecycler);
    }

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList the item list
     * @param agileAdapterDTORecyclerList the agile adapter dTO
     */
    public AgileRecyclerAdapter(List<T> itemList, List<AgileAdapterDTORecycler> agileAdapterDTORecyclerList) {
        this.itemList = itemList;
        this.agileAdapterDTORecyclerList = agileAdapterDTORecyclerList;
    }


    @Override
    public int getItemViewType(int position) {

        try{
            return this.itemList.get(position).getViewType();
        }
        catch(ClassCastException e){
            Log.e(LOG_TAG, "Your model object"
                    + this.itemList.get(position).getClass().getSimpleName()
                    + " must implement TypableView interface");
        }

        return 0;
    }

    @Override
    public HolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        for(AgileAdapterDTORecycler agileAdapterDTORecycler : this.agileAdapterDTORecyclerList){

            if(viewType == agileAdapterDTORecycler.getViewType()){

                final ViewResolverRecycler viewResolverRecycler = agileAdapterDTORecycler.getViewResolverRecycler();

                return viewResolverRecycler.resolve(parent);
            }
        }
        // TODO: 10/15/15 launch custom exception if viewType does not match agileAdapterDTORecycler.getViewType()
        throw new IllegalStateException();
    }

    @Override
    public void onBindViewHolder(HolderRecycler holder, final int position) {

        final T listItem = this.itemList.get(position);

        final AgileRecyclerBuilder<T> agileRecyclerBuilder = new AgileRecyclerBuilder.Builder<T>(holder)
                .setContext(this.context)
                .setItem(listItem)
                .build();

        for(AgileAdapterDTORecycler agileAdapterDTORecycler : this.agileAdapterDTORecyclerList){

            if(this.getItemViewType(position) == agileAdapterDTORecycler.getViewType()){

                final Populator populator = agileAdapterDTORecycler.getPopulator();
                populator.populate(agileRecyclerBuilder);
                break;
            }
        }

        this.handleCustomInteractions(agileRecyclerBuilder, position);
    }

    /**
     * Add listeners to several view interactable items in current view
     *
     * @param agileRecyclerBuilder agileRecyclerBuilder Current holder element
     */
    private void handleCustomInteractions(AgileRecyclerBuilder agileRecyclerBuilder, int position) {

        for(AgileAdapterDTORecycler agileAdapterDTORecycler : this.agileAdapterDTORecyclerList){

            Interactor interactor = agileAdapterDTORecycler.getInteractor();

            if(this.getItemViewType(position) == agileAdapterDTORecycler.getViewType()){
                interactor.setInteraction(agileRecyclerBuilder);
                return;
            }
        }
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
    public void addItem(T item) {
        this.itemList.add(item);
        super.notifyDataSetChanged();
    }

    /**
     * Update posts list.
     *
     * @param newItemList the new item list
     */
    public void appendNewItemList(List<T> newItemList){

        for(T item : newItemList){
            this.itemList.add(item);
        }
        super.notifyDataSetChanged();
    }

    /**
     * Removes an item from current list
     *
     * @param item the item to be removed
     */
    public void removeItemList(T item){

        if(this.itemList.contains(item)){
            this.itemList.remove(item);
            super.notifyDataSetChanged();
            return;
        }

        Log.i(LOG_TAG, "Object not present, couldn´t remove");
    }

    /**
     * Clear posts list.
     */
    public void clearItemList() {
        this.itemList.clear();
        super.notifyDataSetChanged();
    }
}
