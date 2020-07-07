package com.sergo_smyk.recycler_binding.binder;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import java.util.List;

public interface PayloadBinder<VB extends ViewDataBinding, I, P> {

    void onBindPayload(@NonNull VB binding, @NonNull List<P> payload, I item, int position);
}
