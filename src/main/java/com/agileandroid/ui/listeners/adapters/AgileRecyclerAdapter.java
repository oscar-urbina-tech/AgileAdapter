package com.agileandroid.ui.listeners.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.agileandroid.ui.listeners.adapters.builders.PopulatorBuilder;
import com.agileandroid.ui.listeners.adapters.builders.RecyclerViewResolverBuilder;
import com.agileandroid.ui.listeners.adapters.dto.AgileAdapterDTO;
import com.agileandroid.ui.listeners.adapters.dto.InteractorDTO;
import com.agileandroid.ui.listeners.adapters.holders.RecyclerHolder;
import com.agileandroid.ui.listeners.adapters.interactors.Interactor;
import com.agileandroid.ui.listeners.adapters.populators.Populator;
import com.agileandroid.ui.listeners.adapters.resolvers.RecyclerViewResolver;

import java.util.List;

/**
 * Created by oscar.urbina on 8/28/15.
 */
public class AgileRecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder>{

    /**
     * The Posts list.
     */
    protected List itemList;
    private Context context;

    private AgileAdapterDTO agileAdapterDTO;

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList the item list
     * @param agileAdapterDTO the agile adapter dTO
     */
    public AgileRecyclerAdapter(List itemList, AgileAdapterDTO agileAdapterDTO) {
        this.itemList = itemList;
        this.agileAdapterDTO = agileAdapterDTO;
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
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        final RecyclerViewResolverBuilder recyclerViewResolverBuilder =
                new RecyclerViewResolverBuilder.Builder(parent, viewType)
                        .build();

        final RecyclerViewResolver recyclerViewResolver = this.agileAdapterDTO.getRecyclerViewResolver();
        recyclerViewResolver.setRecyclerViewResolverBuilder(recyclerViewResolverBuilder);

        return recyclerViewResolver.resolve();
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, final int position) {

        final Object currentPostItem = this.itemList.get(position);

        PopulatorBuilder populatorBuilder = new PopulatorBuilder.Builder(holder)
                .setContext(this.context)
                .setItem(currentPostItem)
                .build();

        Populator populator = this.agileAdapterDTO.getPopulator();
        populator.populate(populatorBuilder);

        if(this.agileAdapterDTO.getInteractor() != null){

            this.handleCustomInteractions(holder, currentPostItem);
        }
    }

    /**
     * Add listeners to several view interactable items in current view
     *
     * @param holder Current holder element
     * @param currentItem Current Post
     */
    private void handleCustomInteractions(final RecyclerHolder holder, final Object currentItem) {

        final InteractorDTO<Object> interactorDTO = new InteractorDTO<>(currentItem, holder, this.context);

        Interactor interactor = this.agileAdapterDTO.getInteractor();
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
