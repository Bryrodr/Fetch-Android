package com.example.fetch_apprenticeship.data.api

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.fetch_apprenticeship.data.remote.api.FetchApi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith
import javax.inject.Inject




@RunWith(AndroidJUnit4::class)
@SmallTest
@HiltAndroidTest
class FetchApiTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fetchApi: FetchApi


    @Test
    fun testGetRemoteItems() = runBlocking {
        val response = fetchApi.getRemoteItems()

        assertEquals(true, response?.isSuccessful)

        val listItemDtoList = response.body()

        assertNotNull(listItemDtoList)

        assertEquals("Item 0", listItemDtoList!![0].name)
    }

}

