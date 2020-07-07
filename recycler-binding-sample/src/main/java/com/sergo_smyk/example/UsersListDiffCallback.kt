package com.sergo_smyk.example

import com.sergo_smyk.recycler_binding.diif_utils.DiffCallback

class UsersListDiffCallback : DiffCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userFullName == newItem.userFullName
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}