package com.io.github.gianpamx.cleanarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.io.github.gianpamx.cleanarchitecture.domain.GetItemsUseCase
import com.io.github.gianpamx.cleanarchitecture.frameworks.StarWarsApi
import com.io.github.gianpamx.cleanarchitecture.frameworks.StarWarsService
import kotlinx.android.synthetic.main.activity_main.recyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val adapter = PeopleAdapter()
    recyclerView.adapter = adapter

    val viewModel = ViewModelProviders.of(this, factory)
        .get(MainViewModel::class.java)

    viewModel.items.observe(this, Observer { items ->
      adapter.submitItems(items)
    })
  }

  // Dependency Injection code
  @Suppress("UNCHECKED_CAST")
  private val factory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      val retrofit = Retrofit.Builder()
          .baseUrl("https://swapi.co/api/")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
      val service = retrofit.create(StarWarsService::class.java)
      val apiGateway = StarWarsApi(service)
      val getItemsUseCase = GetItemsUseCase(apiGateway)
      return MainViewModel(getItemsUseCase) as T
    }
  }
}
