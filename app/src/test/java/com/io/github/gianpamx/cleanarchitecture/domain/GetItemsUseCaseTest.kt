package com.io.github.gianpamx.cleanarchitecture.domain

import com.io.github.gianpamx.cleanarchitecture.domain.entity.Item
import org.junit.Assert.assertEquals
import org.junit.Test

class GetItemsUseCaseTest {
  private val mock = object : ApiGateway {
    override fun getItems(callback: (List<Item>) -> Unit) {
      callback.invoke(listOf(Item("any"), Item("Other"), Item("Carlos"), Item("Alan")))
    }
  }

  @Test
  fun `return three elements because x bussines rule`() {
    var result: List<Item> = emptyList()
    val callback: (List<Item>) -> Unit = {
      result = it
    }
    val getItemsUseCase = GetItemsUseCase(mock)

    getItemsUseCase.invoke(callback)

    assertEquals(3, result.size)
  }
}
