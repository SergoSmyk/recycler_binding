package com.sergo_smyk.recycler_binding.recycler_adapters;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;

import com.sergo_smyk.recycler_binding.binder.ItemBinder;
import com.sergo_smyk.recycler_binding.diif_utils.DiffCallback;

import java.util.List;


public class BindAdapter<VB extends ViewDataBinding, I>
        extends LiteBindAdapter<VB, I> {

    private DiffCallback<I> diffCallback;

    public BindAdapter(int itemLayout) {
        super(itemLayout);
    }

    public BindAdapter(int itemLayout, @NonNull ItemBinder<VB, I> itemBinding) {
        super(itemLayout, itemBinding);
    }

    public BindAdapter(int itemLayout, @NonNull ItemBinder<VB, I> itemBinder, @NonNull DiffCallback<I> diffCallback) {
        super(itemLayout, itemBinder);
        this.diffCallback = diffCallback;
    }

    @Override
    @CallSuper
    public void setItems(@NonNull List<I> items) {
        if (diffCallback != null) {
            diffCallback.setOldList(super.items);
            diffCallback.setNewList(items);
        }
        super.setItems(items);
    }

    @Override
    @CallSuper
    public void notifyInfoChanged() {
        if (diffCallback != null) {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(diffCallback);
            result.dispatchUpdatesTo(this);
        } else {
            super.notifyInfoChanged();
        }
    }

    final public DiffCallback<I> getDiffCallback() {
        return diffCallback;
    }

    final public void setDiffCallback(@NonNull DiffCallback<I> diffCallback) {
        this.diffCallback = diffCallback;
    }
}
