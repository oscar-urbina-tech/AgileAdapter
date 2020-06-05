package com.agileandroid.ui.adapters.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.agileandroid.ui.adapters.view.dto.AgileAdapterDTO;
import com.agileandroid.ui.adapters.view.resolver.ViewResolver;
import com.agileandroid.ui.adapters.view.resolver.ViewResolverBuilder;

import java.util.List;

/**
 * The type Agile adapter.
 *
 * @param <T> the type parameter
 */
public class AgileAdapter<T> extends BaseAdapter {

    /**
     * The constant LOG_TAG.
     */
    private static final String LOG_TAG = AgileAdapter.class.getSimpleName();

    /**
     * The Item list.
     */
    protected List<T> itemList;

    /**
     * The Agile adapter dto.
     */
    private AgileAdapterDTO agileAdapterDTO;

    /**
     * Instantiates a new Agile adapter.
     *
     * @param itemList        the item list
     * @param agileAdapterDTO the agile adapter dto
     */
    public AgileAdapter(List<T> itemList, AgileAdapterDTO agileAdapterDTO) {
        this.itemList = itemList;
        this.agileAdapterDTO = agileAdapterDTO;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    @Override
    public int getCount() {
        return this.itemList.size();
    }

    /**
     * Gets item.
     *
     * @param position the position
     * @return the item
     */
    @Override
    public T getItem(int position) {
        return this.itemList.get(position);
    }

    /**
     * Gets item id.
     *
     * @param position the position
     * @return the item id
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * Gets item view type.
     *
     * @param position the position
     * @return the item view type
     */
    @Override
    public int getItemViewType(int position) {
        return 0;
        //return this.itemList.get(position).getPostTypeEnum().getValue();
    }

    /*
    @Override
    public int getViewTypeCount() {
        return PostTypeEnum.values().length;
    }
    */

    /**
     * Gets view.
     *
     * @param position    the position
     * @param convertView the convert view
     * @param parent      the parent
     * @return the view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int itemViewType = this.getItemViewType(position);

        final T item = this.itemList.get(position);

        final ViewResolverBuilder<T> viewResolverBuilder =
                new ViewResolverBuilder.Builder<T>(convertView, parent, itemViewType, this.agileAdapterDTO)
                        .setItem(item)
                        .build();

        final ViewResolver viewResolver = this.agileAdapterDTO.getViewResolver();

        return viewResolver.resolve(viewResolverBuilder);
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(T item) {
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    /**
     * Clear items list.
     */
    public void clearItemsList() {
        this.itemList.clear();
        notifyDataSetChanged();
    }

    /**
     * Append new item list.
     *
     * @param newItemList the new item list
     */
    public void appendNewItemList(List<T> newItemList){

        for(T item : newItemList){
            this.itemList.add(item);
        }
        notifyDataSetChanged();
    }
}
