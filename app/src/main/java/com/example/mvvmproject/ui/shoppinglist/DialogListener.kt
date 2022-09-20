package com.example.mvvmproject.ui.shoppinglist

import com.example.mvvmproject.data.db.entities.ShoppingItem

interface DialogListener {
    fun addButtonClick(item: ShoppingItem)
}