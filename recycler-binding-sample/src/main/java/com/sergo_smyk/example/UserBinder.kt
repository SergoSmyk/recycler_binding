package com.sergo_smyk.example

import com.sergo_smyk.example.databinding.ItemUserBinding
import com.sergo_smyk.recycler_binding.binder.ItemBinder

class UserBinder : ItemBinder<ItemUserBinding, User> {
    override fun onBind(binding: ItemUserBinding, item: User, position: Int) {
        binding.user = item
    }
}