package com.agileandroid.ui.listeners.adapters.builders;

import android.content.Context;

import com.agileandroid.ui.listeners.adapters.holders.RecyclerHolder;

/**
 * The type Populator builder.
 *
 * @param <T> the type parameter
 */
public class PopulatorBuilder<T> {

    private Context context;
    private T item;
    private RecyclerHolder recyclerHolder;

    private PopulatorBuilder(Builder<T> builder) {
        this.context = builder.getContext();
        this.item = builder.item;
        this.recyclerHolder = builder.getRecyclerHolder();
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
    public RecyclerHolder getRecyclerHolder() {
        return recyclerHolder;
    }

    /**
     * The type Builder.
     *
     * @param <T> the type parameter
     */
    public static class Builder<T> {
        private Context context;
        private T item;
        private RecyclerHolder recyclerHolder;
        /**
         * Instantiates a new Builder.
         *
         * @param recyclerHolder the recycler holder
         */
        public Builder(RecyclerHolder recyclerHolder) {
            this.recyclerHolder = recyclerHolder;
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

        private RecyclerHolder getRecyclerHolder() {
            return recyclerHolder;
        }

        /**
         * Build populator builder.
         *
         * @return the populator builder
         */
        public PopulatorBuilder<T> build() {
            return new PopulatorBuilder<T>(this);
        }
    }
}