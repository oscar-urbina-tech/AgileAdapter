package com.agileandroid.ui.adapters.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.ViewGroup;

import com.agileandroid.ui.adapters.TypableView;

import com.agileandroid.ui.adapters.recycler.populator.Populator;
import com.agileandroid.ui.adapters.recycler.builder.AgileRecyclerBuilder;

import com.agileandroid.ui.adapters.recycler.dto.AgileAdapterDTO;

import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;
import com.agileandroid.ui.adapters.recycler.interactor.Interactor;

import com.agileandroid.ui.adapters.recycler.resolver.ViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar.urbina on 8/28/15.
 *
 * @param <T> the type parameter
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
    private List<AgileAdapterDTO> agileAdapterDTOList;

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList        the item list
     * @param agileAdapterDTO the agile adapter dTO
     */
    public AgileRecyclerAdapter(List<T> itemList, AgileAdapterDTO agileAdapterDTO) {
        this.itemList = itemList;
        this.agileAdapterDTOList = new ArrayList<>();
        this.agileAdapterDTOList.add(agileAdapterDTO);
    }

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList            the item list
     * @param agileAdapterDTOList the agile adapter dTO
     */
    public AgileRecyclerAdapter(List<T> itemList, List<AgileAdapterDTO> agileAdapterDTOList) {
        this.itemList = itemList;
        this.agileAdapterDTOList = agileAdapterDTOList;
    }


    /**
     * Gets item view type.
     *
     * @param position the position
     * @return the item view type
     */
    @Override
    public int getItemViewType(int position) {

        try{
            return this.itemList.get(position).getViewType();
        }
        catch(ClassCastException e){
            Log.e(LOG_TAG, "Your model object"
                    + this.itemList.get(position).getClass().getSimpleName()
                    + " must implement TypableView interface. \n Try: "
                    + this.itemList.get(position).getClass().getSimpleName()
                    + " implements TypableView");
        }

        return 0;
    }

    /**
     * On create view holder holder recycler.
     *
     * @param parent   the parent
     * @param viewType the view type
     * @return the holder recycler
     */
    @Override
    public HolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        for(AgileAdapterDTO agileAdapterDTO : this.agileAdapterDTOList){

            if(viewType == agileAdapterDTO.getViewType()){

                final ViewResolver viewResolver = agileAdapterDTO.getViewResolver();
                return viewResolver.resolve(parent);
            }
        }

        return new HolderRecycler(parent);
    }

    /**
     * On bind view holder.
     *
     * @param holder   the holder
     * @param position the position
     */
    @Override
    public void onBindViewHolder(HolderRecycler holder, final int position) {

        final T listItem = this.itemList.get(position);

        final AgileRecyclerBuilder<T> agileRecyclerBuilder = new AgileRecyclerBuilder.Builder<T>(holder)
                .setContext(this.context)
                .setItem(listItem)
                .build();

        for(AgileAdapterDTO agileAdapterDTO : this.agileAdapterDTOList){

            if(this.getItemViewType(position) == agileAdapterDTO.getViewType()){

                final Populator populator = agileAdapterDTO.getPopulator();
                populator.populate(agileRecyclerBuilder);
            }
        }

        this.handleCustomInteractions(agileRecyclerBuilder, position);
    }

    /**
     * Add listeners to several view interactable items in current view
     *
     * @param agileRecyclerBuilder agileRecyclerBuilder Current holder element
     * @param position             the position
     */
    private void handleCustomInteractions(AgileRecyclerBuilder agileRecyclerBuilder, int position) {

        for(AgileAdapterDTO agileAdapterDTO : this.agileAdapterDTOList){

            Interactor interactor = agileAdapterDTO.getInteractor();

            if(this.getItemViewType(position) == agileAdapterDTO.getViewType()){
                interactor.setInteraction(agileRecyclerBuilder);
            }
        }
    }

    /**
     * Gets item count.
     *
     * @return the item count
     */
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
