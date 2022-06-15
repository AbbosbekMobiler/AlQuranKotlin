package mobiler.abbosbek.alqurankotlin.repository

import androidx.lifecycle.MutableLiveData
import mobiler.abbosbek.alqurankotlin.api.NetworkManager
import mobiler.abbosbek.alqurankotlin.model.SurahDetailModel
import mobiler.abbosbek.alqurankotlin.model.SurahModel
import mobiler.abbosbek.alqurankotlin.response.BaseResponse
import mobiler.abbosbek.alqurankotlin.response.ResponseSurahDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranRepository {

    fun getSurah(error : MutableLiveData<String>,success : MutableLiveData<List<SurahModel>>){

        NetworkManager.getApiService().getSurah().enqueue(object : Callback<BaseResponse<List<SurahModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<SurahModel>>>,
                response: Response<BaseResponse<List<SurahModel>>>
            ) {
                if (response.body()!!.code == 200){
                    success.value = response.body()!!.data
                }else{
                    error.value = "Failed"
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<SurahModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }
        })
    }


    fun getSurahDetail(id : Int, error: MutableLiveData<String>, success: MutableLiveData<List<SurahDetailModel>>){

        NetworkManager.getApiAyaService().getAya(id).enqueue(object : Callback<ResponseSurahDetail<List<SurahDetailModel>>>{
            override fun onResponse(
                call: Call<ResponseSurahDetail<List<SurahDetailModel>>>,
                response: Response<ResponseSurahDetail<List<SurahDetailModel>>>
            ) {
                success.value = response.body()!!.result
            }

            override fun onFailure(
                call: Call<ResponseSurahDetail<List<SurahDetailModel>>>,
                t: Throwable
            ) {
                error.value = t.localizedMessage
            }
        })
    }
}