package mobiler.abbosbek.alqurankotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mobiler.abbosbek.alqurankotlin.model.SurahDetailModel
import mobiler.abbosbek.alqurankotlin.model.SurahModel
import mobiler.abbosbek.alqurankotlin.repository.QuranRepository

class MainViewModel : ViewModel() {

    val repository = QuranRepository()
    val error = MutableLiveData<String>()
    val surahData = MutableLiveData<List<SurahModel>>()
    val surahDetailData = MutableLiveData<List<SurahDetailModel>>()

    fun getSurah(){
        repository.getSurah(error,surahData)
    }

    fun getSurahDetail(id : Int){
        repository.getSurahDetail(id,error, surahDetailData)
    }
}