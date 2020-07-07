package com.sergo_smyk.recycler_binding.binder;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public interface ItemPostBinder<VB extends ViewDataBinding, I> {

    void onPostBind(@NonNull VB binding, @NonNull I item, int position);
}
