package com.example.api_korea

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.api_korea.data.ItemX
import com.example.api_korea.databinding.ItemNoticeBinding


class KoreaAdapter : ListAdapter<ItemX, KoreaAdapter.KoreaViewHolder>(KoreaCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KoreaViewHolder {
        val binding = ItemNoticeBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return KoreaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KoreaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class KoreaViewHolder(private val binding: ItemNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:ItemX) {
            with(binding) {
                binding.sdate.text = item.sDATE
                binding.startcode.text = item.sTATIONCODE.toString()
                binding.itemcode.text = item.iTEMCODE
                binding.timecode.text = item.tIMECODE
//                binding.value.text = item.vALUE.toString()

            }
        }
    }
    companion object {
        private val KoreaCallback = object : DiffUtil.ItemCallback<ItemX>() {
            override fun areItemsTheSame(oldItem: ItemX, newItem: ItemX): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ItemX, newItem: ItemX): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

        }
    }




}