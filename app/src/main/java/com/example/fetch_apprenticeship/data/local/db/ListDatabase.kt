package com.example.fetch_apprenticeship.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fetch_apprenticeship.data.local.dao.ListDao
import com.example.fetch_apprenticeship.data.model.ListItem

@Database(entities = [ListItem::class], version = 1)
abstract class ListDatabase: RoomDatabase() {
    abstract fun listDao(): ListDao

    companion object{
        const val DATABASE_NAME: String = "list_db"

        @Volatile
        private var INSTANCE: ListDatabase? = null

        fun getDatabase(context: Context): ListDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ListDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}