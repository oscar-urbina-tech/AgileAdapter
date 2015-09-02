package com.agileandroid.ui.listeners.adapters.recycler.builder;

import android.content.Context;

import com.agileandroid.ui.listeners.adapters.recycler.holder.HolderRecycler;

/**
 * The type Populator builder.
 *
 * @param <T> the type parameter
 */
public class AgileRecyclerBuilder<T> {

    private Context context;
    private T item;
    private HolderRecycler holderRecycler;

    private AgileRecyclerBuilder(Builder<T> builder) {
        this.context = builder.getContext();
        this.item = builder.item;
        this.holderRecycler = builder.getHolderRecycler();
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Gets item.
     *
     * @return the item
     */
    public T getItem() {
        return this.item;
    }

    /**
     * Gets recycler holder.
     *
     * @return the recycler holder
     */
    public HolderRecycler getHolderRecycler() {
        return holderRecycler;
    }

    /**
     * The type Builder.
     *
     * @param <T> the type parameter
     */
    public static class Builder<T> {
        private Context context;
        private T item;
        private HolderRecycler holderRecycler;
        /**
         * Instantiates a new Builder.
         *
         * @param holderRecycler the recycler holder
         */
        public Builder(HolderRecycler holderRecycler) {
            this.holderRecycler = holderRecycler;
        }

        /**
         * Gets item.
         *
         * @return the item
         */
        public T getItem() {
            return item;
        }

        /**
         * Sets item.
         *
         * @param item the item
         * @return the item
         */
        public Builder setItem(T item) {
            this.item = item;
            return this;
        }

        private Context getContext() {
            return context;
        }

        /**
         * Sets context.
         *
         * @param context the context
         * @return the context
         */
        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        private HolderRecycler getHolderRecycler() {
            return holderRecycler;
        }

        /**
         * Build populator builder.
         *
         * @return the populator builder
         */
        public AgileRecyclerBuilder<T> build() {
            return new AgileRecyclerBuilder<T>(this);
        }
    }
}