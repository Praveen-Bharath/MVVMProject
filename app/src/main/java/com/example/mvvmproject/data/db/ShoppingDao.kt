package com.example.mvvmproject.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmproject.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM SHOPPING_ITEMS")
    fun getShoppingItems(): LiveData<List<ShoppingItem>>
}