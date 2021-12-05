package com.example.helloworld.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.databinding.CategoryItemBinding
import com.example.helloworld.models.Category

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    var list = emptyList<Category>()

    class MyViewHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

//        fun bind(favoritesEntity: FavoritesEntity) {
//            binding.favoritesEntity = favoritesEntity
//            binding.executePendingBindings()
//        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CategoryItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleTextView.text = list[position].text

        if (list[position].image == 0) {
            holder.binding.iconImageView.visibility = View.GONE
            holder.binding.catergoryItem.setBackgroundColor(Color.parseColor("#cee88e"))
        } else {
            holder.binding.iconImageView.setImageResource(list[position].image)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: ArrayList<Category>) {
        list = newList
        notifyDataSetChanged()
    }
}