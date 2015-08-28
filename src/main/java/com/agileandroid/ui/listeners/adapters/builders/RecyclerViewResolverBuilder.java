package com.agileandroid.ui.listeners.adapters.builders;

import android.view.ViewGroup;

/**
 * The type Recycler view resolver builder.
 */
public class RecyclerViewResolverBuilder{

    private ViewGroup parent;
    private int itemViewType;
    private Class item;

    private RecyclerViewResolverBuilder(Builder builder) {
        this.parent = builder.getParent();
        this.itemViewType = builder.getItemViewType();
        this.item = builder.getItem();
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
     * Gets item.
     *
     * @return the item
     */
    public Class getItem() {
        return this.item;
    }

    /**
     * The type Builder.
     */
    public static class Builder {

        private ViewGroup parent;

        private int itemViewType;
        private Class item;

        /**
         * Instantiates a new Builder.
         *
         * @param parent the parent
         * @param itemViewType the item view type
         */
        public Builder(ViewGroup parent, int itemViewType) {
            this.parent = parent;
            this.itemViewType = itemViewType;
        }

        /**
         * Build recycler view resolver builder.
         *
         * @return the recycler view resolver builder
         */
        public RecyclerViewResolverBuilder build() {
            return new RecyclerViewResolverBuilder(this);
        }

        private ViewGroup getParent() {
            return parent;
        }

        private int getItemViewType() {
            return itemViewType;
        }

        /**
         * Gets item.
         *
         * @return the item
         */
        public Class getItem() {
            return this.item;
        }

        /**
         * Sets item.
         *
         * @param item the item
         * @return the item
         */
        public Builder setItem(Class item) {
            this.item = item;
            return this;
        }
    }

}
