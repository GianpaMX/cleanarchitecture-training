package com.io.github.gianpamx.cleanarchitecture.domain

import com.io.github.gianpamx.cleanarchitecture.domain.entity.Item

interface ApiGateway {
  fun getItems(callback: (List<Item>) -> Unit)
}
