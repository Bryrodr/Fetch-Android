package com.example.fetch_apprenticeship

import com.example.fetch_apprenticeship.data.local.entity.ListItemEntity
import com.example.fetch_apprenticeship.data.local.entity.toListItem
import com.example.fetch_apprenticeship.data.remote.dto.ListItemDto
import com.example.fetch_apprenticeship.data.remote.dto.toListItemEntity
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertEquals
import org.junit.Test

/*
 While In this project there really isn't a need for mappers,
  it's good practice to test them
 */
@HiltAndroidTest
class MapperTest {
    @Test
    fun mapDtoToEntity() {
        val dtoItem = ListItemDto(1, 2, "test")
        val entityItem = dtoItem.toListItemEntity()
        assertEquals(entityItem.id, dtoItem.id)
    }

    @Test
    fun mapEntityToListItem(){
        val entityItem = ListItemEntity(1, 2, "test")
        val domainItem = entityItem.toListItem()
        assertEquals(entityItem.id, domainItem.id)
    }
}