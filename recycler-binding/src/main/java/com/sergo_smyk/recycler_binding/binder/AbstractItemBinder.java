package com.sergo_smyk.recycler_binding.binder;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import java.util.List;

public abstract class AbstractItemBinder<VB extends ViewDataBinding, I, P>
        implements ItemBinder<VB, I>, ItemPostBinder<VB, I>, ListenersBinder<VB>,
        PayloadBinder<VB, I, P>, PayloadPostBinder<VB, I, P>{
    @Override
    public void onBind(@NonNull VB binding, @NonNull I item, int position) {
    }

    @Override
    public void onPostBind(@NonNull VB binding, @NonNull I item, int position) {
    }

    @Override
    public void onBindListeners(@NonNull VB binding) {
    }

    @Override
    public void onBindPayload(@NonNull VB binding, @NonNull List<P> payload, I item, int position) {
    }

    @Override
    public void onPostBindPayload(@NonNull VB binding, @NonNull List<P> payload, I item, int position) {
    }
}
