package com.agileandroid.ui.adapters;

import android.content.Context;

import com.agileandroid.ui.adapters.holder.HolderRecycler;

/**
 * The type Populator builder.
 *
 * @param <T> the type parameter
 * @param <H> the type parameter
 */
public class AgileAdapterBuilder<T, H extends HolderRecycler> {

    /**
     * The Context.
     */
    private Context context;
    /**
     * The Item.
     */
    private T item;
    /**
     * The Holder.
     */
    private H holder;

    /**
     * Private AgileRecyclerBuilder
     *
     * @param builder the builder
     */
    private AgileAdapterBuilder(Builder<T, H> builder) {
        this.context = builder.getContext();
        this.item = builder.getItem();
        this.holder = builder.getHolderRecycler();
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
    public H getHolder() {
        return holder;
    }

    /**
     * The type Builder.
     *
     * @param <T> the type parameter
     * @param <H> the type parameter
     */
    public static class Builder<T, H extends HolderRecycler> {
        /**
         * The Context.
         */
        private Context context;
        /**
         * The Item.
         */
        private T item;
        /**
         * The Holder recycler.
         */
        private H holderRecycler;

        /**
         * Instantiates a new Builder.
         *
         * @param holderRecycler the recycler holder
         */
        public Builder(H holderRecycler) {
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
        public Builder<T, H> setItem(T item) {
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
        public Builder<T, H> setContext(Context context) {
            this.context = context;
            return this;
        }

        /**
         * Gets recycler holder.
         *
         * @return the recycler holder
         */
        private H getHolderRecycler() {
            return holderRecycler;
        }

        /**
         * Build populator builder.
         *
         * @return the populator builder
         */
        public AgileAdapterBuilder<T, H> build() {
            return new AgileAdapterBuilder<>(this);
        }
    }
}