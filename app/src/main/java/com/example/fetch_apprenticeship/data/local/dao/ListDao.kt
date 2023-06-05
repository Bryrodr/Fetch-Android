package com.example.fetch_apprenticeship.data.local.dao

import androidx.room.*
import com.example.fetch_apprenticeship.data.local.entity.ListItemEntity

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllItems(listItems: List<ListItemEntity>)

    @Query("SELECT * " +
            "FROM list l " +
            "WHERE l.name IS NOT NULL AND l.name <> '' " +
            "ORDER BY l.listId ASC, l.name;")
    suspend fun getListItems(): List<ListItemEntity>


}