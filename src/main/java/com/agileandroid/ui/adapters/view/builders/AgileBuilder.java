package com.agileandroid.ui.adapters.view.builders;

import android.content.Context;
import android.view.View;

/**
 * The type Populator builder.
 *
 * @param <T> the type parameter
 */
public class AgileBuilder<T> {

    private Context context;
    private T item;
    private View view;

    private AgileBuilder(Builder<T> builder) {
        this.context = builder.getContext();
        this.item = builder.item;
        this.view = builder.getView();
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
    public View getView() {
        return this.view;
    }

    /**
     * The type Builder.
     *
     * @param <T> the type parameter
     */
    public static class Builder<T> {
        private Context context;
        private T item;
        private View view;
        /**
         * Instantiates a new Builder.
         *
         * @param view the recycler holder
         */
        public Builder(View view) {
            this.view = view;
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

        private View getView() {
            return this.view;
        }

        /**
         * Build populator builder.
         *
         * @return the populator builder
         */
        public AgileBuilder<T> build() {
            return new AgileBuilder<T>(this);
        }
    }
}