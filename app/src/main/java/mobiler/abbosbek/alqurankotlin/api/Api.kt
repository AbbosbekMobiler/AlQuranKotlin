package mobiler.abbosbek.alqurankotlin.api

import mobiler.abbosbek.alqurankotlin.model.SurahDetailModel
import mobiler.abbosbek.alqurankotlin.model.SurahModel
import mobiler.abbosbek.alqurankotlin.response.BaseResponse
import mobiler.abbosbek.alqurankotlin.response.ResponseSurahDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("surah")
    fun getSurah() : Call<BaseResponse<List<SurahModel>>>

    @GET("sura/uzbek_mansour/{surah_Id}")
    fun getAya(@Path("surah_Id") surahId : Int) : Call<ResponseSurahDetail<List<SurahDetailModel>>>
}