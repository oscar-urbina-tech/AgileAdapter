package com.agileandroid.ui.adapters.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.agileandroid.ui.adapters.TypableView;
import com.agileandroid.ui.adapters.recycler.populator.Populator;
import com.agileandroid.ui.adapters.recycler.builder.AgileRecyclerBuilder;
import com.agileandroid.ui.adapters.recycler.builder.ViewResolverRecyclerBuilder;
import com.agileandroid.ui.adapters.recycler.dto.AgileAdapterDTORecycler;

import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;
import com.agileandroid.ui.adapters.recycler.interactor.Interactor;

import com.agileandroid.ui.adapters.recycler.resolver.ViewResolverRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class AgileRecyclerAdapter extends RecyclerView.Adapter<HolderRecycler>{

    /**
     * The Item list.
     */
    protected List<Object> itemList;
    private Context context;
    private static final String LOG_TAG = AgileRecyclerAdapter.class.getSimpleName();

    private List<AgileAdapterDTORecycler> agileAdapterDTORecyclerList;

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList the item list
     * @param agileAdapterDTORecycler the agile adapter dTO
     */
    public AgileRecyclerAdapter(List itemList, AgileAdapterDTORecycler agileAdapterDTORecycler) {
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
    public AgileRecyclerAdapter(List itemList, List<AgileAdapterDTORecycler> agileAdapterDTORecyclerList) {
        this.itemList = itemList;
        this.agileAdapterDTORecyclerList = agileAdapterDTORecyclerList;
    }


    @Override
    public int getItemViewType(int position) {
        return ((TypableView)this.itemList.get(position)).getViewType();
    }

    @Override
    public HolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        final ViewResolverRecyclerBuilder viewResolverRecyclerBuilder =
                new ViewResolverRecyclerBuilder.Builder(parent, viewType)
                        .build();

        for(AgileAdapterDTORecycler agileAdapterDTORecycler : this.agileAdapterDTORecyclerList){

            if(viewType == agileAdapterDTORecycler.getViewType()){

                final ViewResolverRecycler viewResolverRecycler = agileAdapterDTORecycler.getViewResolverRecycler();
                viewResolverRecycler.setViewResolverRecyclerBuilder(viewResolverRecyclerBuilder);

                return viewResolverRecycler.resolve();
            }
        }

        throw new IllegalStateException();
    }

    @Override
    public void onBindViewHolder(HolderRecycler holder, final int position) {

        final Object currentPostItem = this.itemList.get(position);

        AgileRecyclerBuilder agileRecyclerBuilder = new AgileRecyclerBuilder.Builder(holder)
                .setContext(this.context)
                .setItem(currentPostItem)
                .build();

        for(AgileAdapterDTORecycler agileAdapterDTORecycler : this.agileAdapterDTORecyclerList){

            if(this.getItemViewType(position) == agileAdapterDTORecycler.getViewType()){

                Populator populator = agileAdapterDTORecycler.getPopulator();
                populator.populate(agileRecyclerBuilder);
                break;
            }
        }

        for(AgileAdapterDTORecycler agileAdapterDTORecycler : this.agileAdapterDTORecyclerList){

            if(agileAdapterDTORecycler.getInteractor() != null){

                Interactor interactor = agileAdapterDTORecycler.getInteractor();

                if(this.getItemViewType(position) == agileAdapterDTORecycler.getViewType()){
                    interactor.setInteraction(agileRecyclerBuilder);
                    return;
                }
            }
        }

        throw new IllegalStateException();
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

        throw new IllegalStateException();
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
        super.notifyDataSetChanged();
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
        super.notifyDataSetChanged();
    }

    public void removeItemList(Object item){

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
