package com.sergo_smyk.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergo_smyk.example.databinding.ActivityMainBinding
import com.sergo_smyk.example.databinding.ItemUserBinding
import com.sergo_smyk.recycler_binding.recycler_adapters.BindAdapter

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerParams()
    }

    private fun initRecyclerParams() {
        with(binding) {
            items = User.listOfUsers
            adapter = BindAdapter<ItemUserBinding, User>(R.layout.item_user).apply {
                itemBinder = UserBinder()
                diffCallback = UsersListDiffCallback()
            }
        }
    }
}