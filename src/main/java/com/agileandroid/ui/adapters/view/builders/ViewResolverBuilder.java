package com.agileandroid.ui.adapters.view.builders;

import android.view.View;
import android.view.ViewGroup;

import com.agileandroid.ui.adapters.view.dto.AgileAdapterDTO;

/**
 * Created by oscar.urbina on 7/17/15.
 *
 * @param <T> the type parameter
 */
public class ViewResolverBuilder<T> {

    private View convertView;
    private ViewGroup parent;
    private int itemViewType;
    private T item;
    private AgileAdapterDTO agileAdapterDTO;

    private ViewResolverBuilder(Builder<T> builder) {
        this.convertView = builder.getConvertView();
        this.parent = builder.getParent();
        this.itemViewType = builder.getItemViewType();
        this.item = builder.getItem();
        this.agileAdapterDTO = builder.getAgileAdapterDTO();
    }

    /**
     * Gets agile adapter dTO.
     *
     * @return the agile adapter dTO
     */
    public AgileAdapterDTO getAgileAdapterDTO() {
        return agileAdapterDTO;
    }

    /**
     * Gets convert view.
     *
     * @return the convert view
     */
    public View getConvertView() {
        return convertView;
    }

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public ViewGroup getParent() {
        return parent;
    }

    /**
     * Gets item view type.
     *
     * @return the item view type
     */
    public int getItemViewType() {
        return itemViewType;
    }

    /**
     * Gets item dTO.
     *
     * @return the item dTO
     */
    public T getItem() {
        return this.item;
    }

    /**
     * The type Builder.
     *
     * @param <T> the type parameter
     */
    public static class Builder<T> {

        private View convertView;
        private ViewGroup parent;

        private int itemViewType;
        private T item;
        private AgileAdapterDTO agileAdapterDTO;

        /**
         * Instantiates a new Builder.
         *
         * @param convertView     the convert view
         * @param parent          the parent
         * @param itemViewType    the item view type
         * @param agileAdapterDTO the agile adapter dTO
         */
        public Builder(View convertView, ViewGroup parent, int itemViewType, AgileAdapterDTO agileAdapterDTO) {
            this.convertView = convertView;
            this.parent = parent;
            this.itemViewType = itemViewType;
            this.agileAdapterDTO = agileAdapterDTO;
        }

        /**
         * Gets agile adapter dTO.
         *
         * @return the agile adapter dTO
         */
        public AgileAdapterDTO getAgileAdapterDTO() {
            return agileAdapterDTO;
        }

        /**
         * Build view resolver builder.
         *
         * @return the view resolver builder
         */
        public ViewResolverBuilder<T> build() {
            return new ViewResolverBuilder<>(this);
        }

        private View getConvertView() {
            return convertView;
        }

        private ViewGroup getParent() {
            return parent;
        }

        private int getItemViewType() {
            return itemViewType;
        }

        /**
         * Gets item dTO.
         *
         * @return the item dTO
         */
        public T getItem() {
            return item;
        }

        /**
         * Sets item dTO.
         *
         * @param item the item
         * @return the item dTO
         */
        public Builder<T> setItem(T item) {
            this.item = item;
            return this;
        }
    }
}
