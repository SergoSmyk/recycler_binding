package com.sergo_smyk.recycler_binding.binder;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public interface ListenersBinder<VB extends ViewDataBinding> {
    void onBindListeners(@NonNull VB binding);
}
