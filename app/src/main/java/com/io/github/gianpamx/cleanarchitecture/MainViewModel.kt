package com.io.github.gianpamx.cleanarchitecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.io.github.gianpamx.cleanarchitecture.domain.GetItemsUseCase

class MainViewModel(getItemsUseCase: GetItemsUseCase) : ViewModel() {
  val items = MutableLiveData<List<ItemData>>()

  init {
    getItemsUseCase.invoke {
      val result = it.map { item ->
        ItemData(item.name)
      }
      items.value = result
    }
  }
}
