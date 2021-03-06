package mobiler.abbosbek.alqurankotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mobiler.abbosbek.alqurankotlin.db.AppDatabase
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

    fun insertAllProducts2DB(items : List<SurahModel>){
        CoroutineScope(Dispatchers.IO).launch{
            AppDatabase.getDatabase().getSurahDao().insertAll(items)
            CoroutineScope(Dispatchers.Main).launch {
                error.value = "Ma'lumotlar bazaga yuklandi!"
            }
        }
    }

    fun getAllDBSurah(){
        CoroutineScope(Dispatchers.Main).launch {
            surahData.value = with(Dispatchers.IO){AppDatabase.getDatabase().getSurahDao().getAllSurah()}
        }
    }
}