package com.example.mvvmproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmproject.R
import com.example.mvvmproject.data.db.ShoppingDatabase
import com.example.mvvmproject.data.db.entities.ShoppingItem
import com.example.mvvmproject.data.repositories.ShoppingRepository
import com.example.mvvmproject.other.ShoppingItemAdapter
import com.example.mvvmproject.ui.shoppinglist.DialogListener
import com.example.mvvmproject.ui.shoppinglist.DialogShoppingItemAdd
import com.example.mvvmproject.ui.shoppinglist.ShoppingViewModel
import com.example.mvvmproject.ui.shoppinglist.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel, this)

        rv_ShoppingList.layoutManager = LinearLayoutManager(this)
        rv_ShoppingList.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        floating_button.setOnClickListener {
            DialogShoppingItemAdd(this, object : DialogListener {
                override fun addButtonClick(item: ShoppingItem) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}