package com.example.helloworld.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.databinding.RewardsItemBinding
import com.example.helloworld.models.Reward

class RewardsAdapter: RecyclerView.Adapter<RewardsAdapter.MyViewHolder>() {

    var list = emptyList<Reward>()

    class MyViewHolder(val binding: RewardsItemBinding) : RecyclerView.ViewHolder(binding.root) {

//        fun bind(favoritesEntity: FavoritesEntity) {
//            binding.favoritesEntity = favoritesEntity
//            binding.executePendingBindings()
//        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RewardsItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.imageView.setImageResource(list[position].image)
        holder.binding.textView.text = "x ${list[position].amount}"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: ArrayList<Reward>) {
        list = newList
        notifyDataSetChanged()
    }

}