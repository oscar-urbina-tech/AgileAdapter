package com.agileandroid.ui.adapters.recycler.builder;

import android.content.Context;

import com.agileandroid.ui.adapters.recycler.holder.HolderRecycler;

/**
 * The type Populator builder.
 *
 * @param <T> the type parameter
 */
public class AgileAdapterBuilder<T> {

    private Context context;
    private T item;
    private HolderRecycler holderRecycler;

    /**
     * Private AgileRecyclerBuilder
     *
     * @param builder
     */
    private AgileAdapterBuilder(Builder<T> builder) {
        this.context = builder.getContext();
        this.item = builder.getItem();
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
        public Builder<T> setItem(T item) {
            this.item = item;
            return this;
        }

        /**
         * Gets context.
         *
         * @return the context
         */
        private Context getContext() {
            return context;
        }

        /**
         * Sets context.
         *
         * @param context the context
         * @return the context
         */
        public Builder<T> setContext(Context context) {
            this.context = context;
            return this;
        }

        /**
         * Gets recycler holder.
         *
         * @return the recycler holder
         */
        private HolderRecycler getHolderRecycler() {
            return holderRecycler;
        }

        /**
         * Build populator builder.
         *
         * @return the populator builder
         */
        public AgileAdapterBuilder<T> build() {
            return new AgileAdapterBuilder<>(this);
        }
    }
}