package com.example.fetch_apprenticeship.domain.use_case

import com.example.fetch_apprenticeship.data.repository.FakeListItemRepository
import com.example.fetch_apprenticeship.util.Result
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class GetListItemsTest{
    private lateinit var fakeListItemRepository: FakeListItemRepository
    @Before
    fun setUp() {
        fakeListItemRepository = FakeListItemRepository()
    }

    @Test
    fun testGetListItems() = runBlocking {
        val getListItems = GetListItems(fakeListItemRepository)
        val result = getListItems.invoke()

        result.onEach { result ->
            when (result) {
                is Result.Success -> {
                    val list = result.data
                    assertEquals(3, list?.size)
                }
                is Result.Error -> {
                    assertEquals("Error", result.message)
                }
                is Result.Loading -> {
                    assertEquals("Loading", result.message)
                }
            }
        }
    }
}
