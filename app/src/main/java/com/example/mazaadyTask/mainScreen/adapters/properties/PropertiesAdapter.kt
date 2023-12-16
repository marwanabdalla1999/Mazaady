package com.example.mazaadyTask.mainScreen.adapters.properties

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.properties.Data
import com.example.domain.models.properties.properties
import com.example.mazaadyTask.R
import com.example.mazaadyTask.databinding.PropertiesItemBinding


class PropertiesAdapter(private val onItemClickListener: OnPropertyClickListener, private var properties : properties?) :
    RecyclerView.Adapter<PropertiesAdapter.ViewHolder>() {

     val data=properties


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: PropertiesItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.properties_item, parent, false
        )
        return ViewHolder(binding, onItemClickListener,data)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.hint= properties?.data?.get(position)?.slug


    }

    override fun getItemCount(): Int {
        return properties?.data?.size?:0
    }


    class ViewHolder(
        val binding: PropertiesItemBinding,

        private val onItemClickListener: OnPropertyClickListener,
        data: properties?,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClickListener.onPropertiesClickListener(data?.data?.get(adapterPosition),binding)
            }
        }
    }

    interface OnPropertyClickListener {

        fun onPropertiesClickListener(item: Data?, binding: PropertiesItemBinding)
    }
}