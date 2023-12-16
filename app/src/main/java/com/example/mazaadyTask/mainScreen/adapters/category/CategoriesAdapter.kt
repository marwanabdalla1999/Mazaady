package com.example.mazaadyTask.mainScreen.adapters.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.categories.Category
import com.example.mazaadyTask.R
import com.example.mazaadyTask.databinding.ItemListBinding


class CategoriesAdapter(private val onItemClickListener: OnCategoryClickListener, private var cat : List<Category>?) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

     val data=cat






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list, parent, false
        )
        return ViewHolder(binding, onItemClickListener)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.name= cat?.get(position)?.slug

    }

    override fun getItemCount(): Int {
        return cat?.size?:0
    }




    class ViewHolder(
        val binding: ItemListBinding,

        private val onItemClickListener: OnCategoryClickListener,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClickListener.onCategoryClicked(adapterPosition)
            }
        }
    }

    interface OnCategoryClickListener {

        fun onCategoryClicked(item: Int)
    }


}