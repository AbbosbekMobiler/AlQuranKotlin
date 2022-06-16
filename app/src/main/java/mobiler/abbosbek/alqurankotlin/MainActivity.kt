package mobiler.abbosbek.alqurankotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mobiler.abbosbek.alqurankotlin.adapter.SurahAdapter
import mobiler.abbosbek.alqurankotlin.checkingNetwork.ConnectionLiveData
import mobiler.abbosbek.alqurankotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var cld : ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cld = ConnectionLiveData(application)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerSurah.layoutManager = LinearLayoutManager(this)


        viewModel.error.observe(this,Observer{
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.surahData.observe(this,Observer{
            recyclerSurah.adapter = SurahAdapter(it)
        })

        viewModel.surahData.observe(this,Observer{
            viewModel.insertAllProducts2DB(it)
        })
        loadData()
    }

    fun loadData(){
        viewModel.getSurah()
    }

    fun loadDatabase(){
        viewModel.getAllDBSurah()
    }

    fun checkNetworkConnection(){
        cld = ConnectionLiveData(application)
        cld.observe(this,{isConnected->

        })
    }
}