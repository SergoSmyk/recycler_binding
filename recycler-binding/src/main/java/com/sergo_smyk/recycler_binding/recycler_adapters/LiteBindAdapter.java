package com.sergo_smyk.recycler_binding.recycler_adapters;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.sergo_smyk.recycler_binding.binder.AbstractItemBinder;
import com.sergo_smyk.recycler_binding.binder.ItemBinder;
import com.sergo_smyk.recycler_binding.binder.ItemPostBinder;
import com.sergo_smyk.recycler_binding.binder.ListenersBinder;
import com.sergo_smyk.recycler_binding.recycler_adapters.view_holder.BindViewHolder;

public class LiteBindAdapter<VB extends ViewDataBinding, I> extends AbstractBindAdapter<VB, I> {

    private ItemBinder<VB, I> itemBinder;
    private ItemPostBinder<VB, I> itemPostBinder;
    private ListenersBinder<VB> listenersBinder;

    public LiteBindAdapter(@LayoutRes int itemLayout) {
        super(itemLayout);
    }

    public LiteBindAdapter(@LayoutRes int itemLayout,
                           final ItemBinder<VB, I> itemBinder) {
        super(itemLayout);
        this.itemBinder = itemBinder;
    }

    @NonNull
    @Override
    final public BindViewHolder<VB> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BindViewHolder<VB> vh = super.onCreateViewHolder(parent, viewType);
        if (listenersBinder != null) {
            listenersBinder.onBindListeners(vh.getViewBinding());
        }
        return vh;
    }

    @Override
    final void bindViewHolder(@NonNull VB binding, @NonNull I item, int position) {
        if (itemBinder != null) {
            itemBinder.onBind(binding, item, position);
        } else {
            Log.w(TAG, "Recycler item tries bind item to viewHolder but itemBinder is NULL");
        }
        binding.getRoot().post(() -> {
            if (itemPostBinder != null) {
                itemPostBinder.onPostBind(binding, item, position);
            }
        });
    }

    public ItemBinder<VB, I> getItemBinder() {
        return itemBinder;
    }

    public ListenersBinder<VB> getListenersBinder() {
        return listenersBinder;
    }

    public ItemPostBinder<VB, I> getItemPostBinder() {
        return itemPostBinder;
    }

    public void setItemBinder(@NonNull AbstractItemBinder<VB, I, ?> itemBinder) {
        this.itemBinder = itemBinder;
        this.itemPostBinder = itemBinder;
        this.listenersBinder = itemBinder;
    }

    public void setItemBinder(@NonNull ItemBinder<VB, I> itemBinder) {
        this.itemBinder = itemBinder;
    }

    public void setItemPostBinder(@NonNull ItemPostBinder<VB, I> itemPostBinder) {
        this.itemPostBinder = itemPostBinder;
    }

    public void setListenersBinder(@NonNull ListenersBinder<VB> listenersBinder) {
        this.listenersBinder = listenersBinder;
    }


    private static final String TAG = "LiteBindAdapter";
}
