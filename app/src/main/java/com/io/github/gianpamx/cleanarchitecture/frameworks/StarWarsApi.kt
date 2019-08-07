package com.io.github.gianpamx.cleanarchitecture.frameworks

import android.util.Log
import com.io.github.gianpamx.cleanarchitecture.domain.ApiGateway
import com.io.github.gianpamx.cleanarchitecture.domain.entity.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarWarsApi(private val service: StarWarsService) : ApiGateway {
  override fun getItems(callback: (List<Item>) -> Unit) {
    service.getPeople()
        .enqueue(object : Callback<PeopleResponse?> {
          override fun onResponse(
            call: Call<PeopleResponse?>,
            response: Response<PeopleResponse?>
          ) {
            callback.invoke(
                response.body()?.results?.map { Item(it.name) } ?: emptyList()
            )
          }

          override fun onFailure(
            call: Call<PeopleResponse?>,
            t: Throwable
          ) {
            Log.e(StarWarsApi::class.java.simpleName, "onFailure", t)
          }
        })
  }
}
