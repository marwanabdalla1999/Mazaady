package com.example.mazaadyTask.mainScreen.adapters.options

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.properties.Option
import com.example.mazaadyTask.R
import com.example.mazaadyTask.databinding.ItemListBinding


class OptionsAdapter(private val onItemClickListener: OnOptionClickListener, private var options : ArrayList<Option>?) :
    RecyclerView.Adapter<OptionsAdapter.ViewHolder>() {

     val data=options

    private var filteredItems: ArrayList<Option> = ArrayList()

    init {
        options?.let { filteredItems.addAll(it) }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list, parent, false
        )
        return ViewHolder(binding, onItemClickListener,filteredItems)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.name= filteredItems.get(position).slug

    }

    override fun getItemCount(): Int {

        return filteredItems.size

    }

     fun getItem(position:Int) : Option{
       return filteredItems[position]
    }

    fun filter(query: String) {
        filteredItems.clear()
        if (TextUtils.isEmpty(query)) {
            options?.let { filteredItems.addAll(it) }
        } else {
            for (item in options!!) {
                if (item.slug.lowercase().contains(query.lowercase())) {
                    filteredItems.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }


    class ViewHolder(
        val binding: ItemListBinding,

        private val onItemClickListener: OnOptionClickListener,filteredItems:ArrayList<Option>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClickListener.onOptionClickListener(filteredItems[adapterPosition])

            }
        }
    }

    interface OnOptionClickListener {

        fun onOptionClickListener(item: Option)
    }


}