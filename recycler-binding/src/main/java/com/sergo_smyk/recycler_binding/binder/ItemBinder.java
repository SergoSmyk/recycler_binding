package com.sergo_smyk.recycler_binding.binder;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public interface ItemBinder<VB extends ViewDataBinding, I> {
    void onBind(@NonNull VB binding, @NonNull I item, int position);
}
