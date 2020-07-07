package com.sergo_smyk.recycler_binding.diif_utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Collections;
import java.util.List;

public abstract class DiffCallback<I> extends DiffUtil.Callback {

    protected @NonNull List<I> oldList = Collections.emptyList();
    protected @NonNull List<I> newList = Collections.emptyList();

    public void setNewList(@NonNull List<I> list) {
        this.newList = list;
    }

    public void setOldList(@NonNull List<I> list) {
        this.oldList = list;
    }

    @Override
    final public int getOldListSize() {
        return oldList.size();
    }

    @Override
    final public int getNewListSize() {
        return newList.size();
    }

    public abstract boolean areItemsTheSame(@NonNull I oldItem, @NonNull I newItem);

    @Override
    final public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return areItemsTheSame(oldList.get(oldItemPosition), newList.get(newItemPosition));
    }

    public abstract boolean areContentsTheSame(@NonNull I oldItem, @NonNull I newItem);

    @Override
    final public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return areContentsTheSame(oldList.get(oldItemPosition), newList.get(newItemPosition));
    }
}
