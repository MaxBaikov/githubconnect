package com.androidpoplib.githubconnect

import com.androidpoplib.githubconnect.mvp.model.api.IDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiHolder internal constructor() {

    private val api: IDataSource

    fun getDataSource(): IDataSource {
        return api
    }

    init {
        val gson =
            GsonBuilder().setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        api = retrofit.create(IDataSource::class.java)
    }
}