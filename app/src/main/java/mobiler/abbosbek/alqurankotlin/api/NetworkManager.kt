package mobiler.abbosbek.alqurankotlin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    var retrofit : Retrofit ?= null
    var api : Api ?= null

    fun getApiService() : Api{
        if (api == null){
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.alquran.cloud/v1/")
                .build()

            api = retrofit!!.create(Api::class.java)
        }
        return api!!
    }

    fun getApiAyaService() : Api{
        if (api != null){
            api = null
        }
        if (retrofit != null){
            retrofit = null
        }
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://quranenc.com/api/v1/translation/")
            .build()

        api = retrofit!!.create(Api::class.java)

        return api!!
    }

}