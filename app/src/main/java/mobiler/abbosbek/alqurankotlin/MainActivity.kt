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
import mobiler.abbosbek.alqurankotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerSurah.layoutManager = LinearLayoutManager(this)

        viewModel.error.observe(this,Observer{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        })
        viewModel.surahData.observe(this,Observer{
            recyclerSurah.adapter = SurahAdapter(it)
        })
        loadData()
    }

    fun loadData(){
        viewModel.getSurah()
    }
}