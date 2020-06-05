package com.agileandroid.ui.adapters.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.agileandroid.ui.adapters.AgileAdapterBuilder;
import com.agileandroid.ui.adapters.TypableView;
import com.agileandroid.ui.adapters.holder.BaseHolder;
import com.agileandroid.ui.adapters.recycler.dto.AgileAdapterDTO;
import com.agileandroid.ui.adapters.recycler.interactor.Interactor;
import com.agileandroid.ui.adapters.recycler.populator.Populator;
import com.agileandroid.ui.adapters.recycler.resolver.ViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Agile adapter.
 *
 * @param <T> the type parameter
 */
public class AgileAdapter<T extends TypableView> extends RecyclerView.Adapter<BaseHolder>{

    /**
     * The constant LOG_TAG.
     */
    private static final String LOG_TAG = AgileAdapter.class.getSimpleName();

    /**
     * The Item list.
     */
    protected List<T> itemList;

    /**
     * The Context.
     */
    private Context context;

    /**
     * The Agile adapter dto list.
     */
    private List<AgileAdapterDTO> agileAdapterDTOList;

    /**
     * Instantiates a new Agile adapter.
     *
     * @param itemList        the item list
     * @param agileAdapterDTO the agile adapter dto
     */
    public AgileAdapter(List<T> itemList, AgileAdapterDTO agileAdapterDTO) {

        if(itemList == null || agileAdapterDTO == null){
            throw new IllegalArgumentException("Your item list or your agileAdapterDTO can not be null.");
        }

        this.itemList = itemList;
        this.agileAdapterDTOList = new ArrayList<>();
        this.agileAdapterDTOList.add(agileAdapterDTO);
    }

    /**
     * Instantiates a new Agile adapter.
     *
     * @param itemList            the item list
     * @param agileAdapterDTOList the agile adapter dto list
     */
    public AgileAdapter(List<T> itemList, List<AgileAdapterDTO> agileAdapterDTOList) {

        if(itemList == null || agileAdapterDTOList == null){
            throw new IllegalArgumentException("Your item list or your agileAdapterDTOList can not be null.");
        }

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
     * On create view holder base holder.
     *
     * @param parent   the parent
     * @param viewType the view type
     * @return the base holder
     */
    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        for(AgileAdapterDTO agileAdapterDTO : this.agileAdapterDTOList){

            if(viewType == agileAdapterDTO.getViewType()){

                final ViewResolver viewResolver = agileAdapterDTO.getViewResolver();
                return viewResolver.resolve(parent);
            }
        }

        return new BaseHolder(parent);
    }

    /**
     * On bind view holder.
     *
     * @param holder   the holder
     * @param position the position
     */
    @Override
    public void onBindViewHolder(BaseHolder holder, final int position) {

        final T listItem = this.itemList.get(position);

        final AgileAdapterBuilder agileAdapterBuilder = new AgileAdapterBuilder.Builder<>(holder)
                .setContext(this.context)
                .setItem(listItem)
                .build();

        for(AgileAdapterDTO agileAdapterDTO : this.agileAdapterDTOList){

            if(this.getItemViewType(position) == agileAdapterDTO.getViewType()){

                final Populator populator = agileAdapterDTO.getPopulator();
                populator.populate(agileAdapterBuilder);
            }
        }

        this.handleCustomInteractions(agileAdapterBuilder, position);
    }

    /**
     * Handle custom interactions.
     *
     * @param agileAdapterBuilder the agile adapter builder
     * @param position            the position
     */
    private void handleCustomInteractions(AgileAdapterBuilder agileAdapterBuilder, int position) {

        for(AgileAdapterDTO agileAdapterDTO : this.agileAdapterDTOList){

            if(agileAdapterDTO.getInteractor() != null){

                final Interactor interactor = agileAdapterDTO.getInteractor();

                if(this.getItemViewType(position) == agileAdapterDTO.getViewType()){
                    interactor.setInteraction(agileAdapterBuilder);
                }
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
     * Add item.
     *
     * @param item the item
     */
    public void addItem(T item) {

        if(item == null){
            throw new IllegalArgumentException("item to be added can not be null.");
        }

        this.itemList.add(item);
        super.notifyDataSetChanged();
    }

    /**
     * Append item list.
     *
     * @param itemList the item list
     */
    public void appendItemList(List<T> itemList){

        if(itemList == null){
            throw new IllegalArgumentException("item to be removed can not be null.");
        }

        for(T item : itemList){
            this.itemList.add(item);
        }

        super.notifyDataSetChanged();
    }

    /**
     * Remove item list.
     *
     * @param item the item
     */
    public void removeItem(T item){

        if(item == null){
            throw new IllegalArgumentException("item to be removed can not be null.");
        }

        if(this.itemList.contains(item)){
            this.itemList.remove(item);
            super.notifyDataSetChanged();
            return;
        }

        Log.i(LOG_TAG, "Object not present, couldn´t remove");
    }

    /**
     * Clear item list.
     */
    public void clearItemList() {
        this.itemList.clear();
        super.notifyDataSetChanged();
    }

    /**
     * Get item list list.
     *
     * @return the list
     */
    public List<T> getItemList(){
        return this.itemList;
    }
}
