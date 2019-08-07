package com.io.github.gianpamx.cleanarchitecture.domain

import com.io.github.gianpamx.cleanarchitecture.domain.entity.Item

class GetItemsUseCase(private val apiGateway: ApiGateway) {
  fun invoke(callback: (List<Item>) -> Unit) {
    apiGateway.getItems {
      callback.invoke(it.take(3))
    }
  }
}
