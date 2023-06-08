package com.example.fetch_apprenticeship.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.fetch_apprenticeship.data.local.dao.ListDao
import com.example.fetch_apprenticeship.data.local.entity.ListItemEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ListDaoTest {
    private lateinit var database: ListDatabase
    private lateinit var dao: ListDao

    @Before
    fun setup(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(
            appContext,
            ListDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.listDao()
    }


    @After
    fun teardown(){
        database.close()
    }


    /*
      typically would test inserting list items on its own as well, but it dosen't make sense to
      make a getAllItems query just for the testing a take home project
     */

    @Test
    fun FilterQuery() = runBlockingTest {

        //make a list of 3 list items
        val listItem = ListItemEntity(1,  5, "item 1")
        val listItem2 = ListItemEntity(2, 6, null)
        val listItem3 = ListItemEntity(3, 7, "")
        val listItems = listOf(listItem, listItem2, listItem3)
        dao.insertAllItems(listItems)

        val filteredItems = dao.getLocalListItems()
        assert(filteredItems.size == 1)
    }

}