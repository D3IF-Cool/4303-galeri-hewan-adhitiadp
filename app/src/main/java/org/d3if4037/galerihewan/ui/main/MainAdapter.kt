package org.d3if4037.galerihewan.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import org.d3if4037.galerihewan.model.Hewan
import org.d3if4037.galerihewan.databinding.ListItemBinding


class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>()
    {
        private val data = mutableListOf<Hewan>()

        fun updateData(newData: List<Hewan>){
            data.clear()
            data.addAll(newData)
            notifyDataSetChanged()
        }
        class ViewHolder(private val binding: ListItemBinding) :

            RecyclerView.ViewHolder(binding.root) {

            fun bind(hewan: Hewan) = with(binding) {
                namaTV.text = hewan.nama
                latinTV.text = hewan.namaLatin
                imageView.setImageResource(hewan.imaageResId)
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemBinding.inflate(inflater, parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(data[position])
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }
