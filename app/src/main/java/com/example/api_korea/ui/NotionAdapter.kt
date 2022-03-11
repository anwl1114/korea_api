package com.example.api_korea.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_korea.data.ItemList
import com.example.api_korea.databinding.ItemNoticeBinding

class NotionAdapter: RecyclerView.Adapter<NotionAdapter.NotionViewHolder>() {
    private var items = ArrayList<ItemList>()

    inner class NotionViewHolder(private val binding: ItemNoticeBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(notion: ItemList){
            binding.tvTitle.text = notion.sdate.toString()
            binding.tvCode.text = notion.stationcode.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotionAdapter.NotionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNoticeBinding.inflate(layoutInflater, parent, false)
        return NotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotionAdapter.NotionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(notion : ArrayList<ItemList>) {
        items = notion
    }

}