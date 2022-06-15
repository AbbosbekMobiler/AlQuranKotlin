package mobiler.abbosbek.alqurankotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.surah_detail_layout.view.*
import mobiler.abbosbek.alqurankotlin.R
import mobiler.abbosbek.alqurankotlin.model.SurahDetailModel

class SurahDetailAdapter(val items : List<SurahDetailModel>) : RecyclerView.Adapter<SurahDetailAdapter.ItemHolder>() {
    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.surah_detail_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.itemView.arabic_text.text = item.arabic_text
        holder.itemView.translation.text = item.translation
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}