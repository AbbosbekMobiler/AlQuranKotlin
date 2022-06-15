package mobiler.abbosbek.alqurankotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.surah_item_layout.view.*
import mobiler.abbosbek.alqurankotlin.R
import mobiler.abbosbek.alqurankotlin.SurahDetailActivity
import mobiler.abbosbek.alqurankotlin.model.SurahModel
import mobiler.abbosbek.alqurankotlin.utils.Constants

class SurahAdapter(val items : List<SurahModel>) : RecyclerView.Adapter<SurahAdapter.ItemHolder>() {
    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.surah_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]


        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, SurahDetailActivity::class.java)
            intent.putExtra(Constants.EXTRA_DATA,item)
            it.context.startActivity(intent)
        }

        holder.itemView.surahNumber.text = item.number.toString()
        holder.itemView.english_name.text = item.englishName
        holder.itemView.total_aya.text = "Aya : ${item.numberOfAyahs}"
        holder.itemView.arabic_name.text = item.name
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}