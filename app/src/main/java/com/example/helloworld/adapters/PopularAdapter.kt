package com.example.helloworld.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.data.ItemsData
import com.example.helloworld.databinding.PopularItemBinding
import com.example.helloworld.models.Item
import com.example.helloworld.ui.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.withContext

class PopularAdapter(
    val context: Context?
): RecyclerView.Adapter<PopularAdapter.MyViewHolder>() {

    var list = emptyList<Item>()

    class MyViewHolder(val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {

//        fun bind(favoritesEntity: FavoritesEntity) {
//            binding.favoritesEntity = favoritesEntity
//            binding.executePendingBindings()
//        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PopularItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.popularImageView.setImageResource(list[position].image)
        holder.binding.nameTextView.text = list[position].text
        holder.binding.priceTextView.text = list[position].price.toString()

        holder.itemView.setOnClickListener {
            ItemsData.points += list[position].price.toInt()
            Snackbar.make(
                it,
                "${list[position].text} added to the bin",
                Snackbar.LENGTH_SHORT
            ).setAction("Okay") {}
                .show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: ArrayList<Item>) {
        list = newList
        notifyDataSetChanged()
    }

}