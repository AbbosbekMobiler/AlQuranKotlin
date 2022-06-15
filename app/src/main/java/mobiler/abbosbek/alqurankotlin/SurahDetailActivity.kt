package mobiler.abbosbek.alqurankotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_surah_detail.*
import mobiler.abbosbek.alqurankotlin.adapter.SurahDetailAdapter
import mobiler.abbosbek.alqurankotlin.model.SurahModel
import mobiler.abbosbek.alqurankotlin.utils.Constants
import mobiler.abbosbek.alqurankotlin.viewmodel.MainViewModel

class SurahDetailActivity : AppCompatActivity() {

    lateinit var item : SurahModel
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_detail)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as SurahModel

        surah_detail_rv.layoutManager = LinearLayoutManager(this)

        surah_name.text = item.name
        translation.text = item.englishName
        type.text = "${item.revelationType}  ${item.numberOfAyahs} : AYA"

        viewModel.surahDetailData.observe(this,Observer{
            surah_detail_rv.adapter = SurahDetailAdapter(it)
        })
        viewModel.error.observe(this,Observer{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        })

        loadData()
    }
    fun loadData(){
        viewModel.getSurahDetail(item.number)
    }
}