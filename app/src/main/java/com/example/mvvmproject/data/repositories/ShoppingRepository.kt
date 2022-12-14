package com.example.mvvmproject.data.repositories

import com.example.mvvmproject.data.db.ShoppingDatabase
import com.example.mvvmproject.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getShoppingItems()
}