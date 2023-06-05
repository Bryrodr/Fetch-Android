package com.example.fetch_apprenticeship.data.local.dao

import androidx.room.*
import com.example.fetch_apprenticeship.data.model.ListItem

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListItem(ListItem: ListItem)

    @Delete
    suspend fun deleteListItem(ListItem: ListItem)

    @Query("SELECT * FROM list l where l.name is not null group by l.list_id order by l.list_id asc, l.name desc")
    suspend fun getListItems()


}