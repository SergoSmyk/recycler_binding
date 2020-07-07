package com.sergo_smyk.recycler_binding.recycler_adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.sergo_smyk.recycler_binding.binder.AbstractItemBinder;
import com.sergo_smyk.recycler_binding.binder.PayloadBinder;
import com.sergo_smyk.recycler_binding.binder.PayloadPostBinder;

import java.util.LinkedList;
import java.util.List;

public class PayloadBindAdapter<VB extends ViewDataBinding, I, P>
        extends BindAdapter<VB, I> {

    private PayloadBinder<VB, I, P> payloadBinder;
    private PayloadPostBinder<VB, I, P> payloadPostBinder;

    public PayloadBindAdapter(int itemLayout) {
        super(itemLayout);
    }

    public PayloadBinder<VB, I, P> getItemPayloadBinder() {
        return this.payloadBinder;
    }

    public void setItemPayloadBinder(@NonNull PayloadBinder<VB, I, P> payloadBinder) {
        this.payloadBinder = payloadBinder;
    }

    @SuppressWarnings("unchecked")
    public void setItemBinder(@NonNull AbstractItemBinder<VB, I, ?> itemBinder) {
        super.setItemBinder(itemBinder);
        this.payloadBinder = (AbstractItemBinder<VB, I, P>) itemBinder;
        this.payloadPostBinder = (AbstractItemBinder<VB, I, P>) itemBinder;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected boolean bindViewHolder(@NonNull VB binding,
                                     @NonNull I item,
                                     @NonNull List<Object> payloads,
                                     int position) {
        List<P> typedPayloads = new LinkedList<>();
        for (Object payload : payloads) {
            typedPayloads.add((P) payload);
        }
        if (payloadBinder != null) {
            payloadBinder.onBindPayload(binding, typedPayloads, item, position);
        } else {
            Log.w(TAG, "Recycler item tries bind payload to viewHolder but payloadBinder is NULL");
        }
        binding.getRoot().post(() -> {
                    if (payloadPostBinder != null) {
                        payloadBinder.onBindPayload(binding, typedPayloads, item, position);
                    }
                }
        );
        return true;
    }

    private static final String TAG = "PayloadBindAdapter";
}
