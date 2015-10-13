package com.agileandroid.ui.adapters.recycler.builder;

import android.view.ViewGroup;

/**
 * The type Recycler view resolver builder.
 */
public class ViewResolverRecyclerBuilder {

    private ViewGroup parent;
    private int itemViewType;
    private Class item;

    private ViewResolverRecyclerBuilder(Builder builder) {
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
        public ViewResolverRecyclerBuilder build() {
            return new ViewResolverRecyclerBuilder(this);
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
