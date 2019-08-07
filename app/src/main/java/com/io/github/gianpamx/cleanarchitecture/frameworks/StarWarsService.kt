package com.io.github.gianpamx.cleanarchitecture.frameworks

import retrofit2.Call
import retrofit2.http.GET

interface StarWarsService {
  @GET("people")
  fun getPeople(): Call<PeopleResponse>
}
