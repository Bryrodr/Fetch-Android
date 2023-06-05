package com.example.fetch_apprenticeship.data.local

import androidx.room.*
import com.example.fetch_apprenticeship.data.local.dao.ListDao
import com.example.fetch_apprenticeship.data.local.entity.ListItemEntity

/**
 * Database for [ListItemEntity]
 * used to persist data locally
 * */
@Database(entities = [ListItemEntity::class], version = 2)
abstract class ListDatabase: RoomDatabase() {
    abstract fun listDao(): ListDao

    companion object{
        const val DATABASE_NAME: String = "list_db"
    }
}