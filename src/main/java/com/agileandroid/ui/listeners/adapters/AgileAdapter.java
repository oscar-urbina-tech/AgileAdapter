package com.agileandroid.ui.listeners.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.agileandroid.ui.listeners.adapters.recycler.builder.AgileRecyclerBuilder;
import com.agileandroid.ui.listeners.adapters.recycler.holder.HolderRecycler;
import com.agileandroid.ui.listeners.adapters.view.interactor.Interactor;
import com.agileandroid.ui.listeners.adapters.view.populator.Populator;
import com.agileandroid.ui.listeners.adapters.view.builders.AgileBuilder;
import com.agileandroid.ui.listeners.adapters.view.builders.ViewResolverBuilder;
import com.agileandroid.ui.listeners.adapters.view.dto.AgileAdapterDTO;
import com.agileandroid.ui.listeners.adapters.view.resolver.ViewResolver;

import java.util.List;

/**
 * Created by oscar.urbina on 7/9/15.
 */
public class AgileAdapter extends BaseAdapter {

    private static final String LOG_TAG = AgileAdapter.class.getSimpleName();
    /**
     * The Item list.
     */
    protected List<Object> itemList;
    private Context context;

    private AgileAdapterDTO agileAdapterDTO;

    /**
     * Instantiates a new Agile recycler adapter.
     *
     * @param itemList the item list
     * @param agileAdapterDTO the agile adapter dTO
     */
    public AgileAdapter(List itemList, AgileAdapterDTO agileAdapterDTO) {
        this.itemList = itemList;
        this.agileAdapterDTO = agileAdapterDTO;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return this.itemList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return this.itemList.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


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
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int itemViewType = this.getItemViewType(position);

        final Object item = this.itemList.get(position);

        ViewResolverBuilder viewResolverBuilder =
                new ViewResolverBuilder.Builder(convertView, parent, itemViewType, this.agileAdapterDTO)
                        .setItem(item)
                        .build();

        ViewResolver viewResolver = this.agileAdapterDTO.getViewResolver();
        viewResolver.setViewResolverBuilder(viewResolverBuilder);

        return viewResolver.resolve();
    }

    /**
     * Add new article to current list and notify adapter.
     *
     * @param item the item
     */
    public void addItem(Object item) {
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    /**
     * Clean current article list.
     */
    public void clearItemsList() {
        this.itemList.clear();
        notifyDataSetChanged();
    }

    /**
     * Update posts list.
     *
     * @param newItemList the new item list
     */
    public void appendNewItemList(List<Object> newItemList){

        for(Object item : newItemList){
            this.itemList.add(item);
        }
        notifyDataSetChanged();
    }
}
