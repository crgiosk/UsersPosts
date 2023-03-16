package com.pruebadeingreso.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pruebadeingreso.databinding.ItemPostLayoutBinding
import com.pruebadeingreso.ui.binds.PostUserBind
import com.pruebadeingreso.BR

class PostUserAdapter : RecyclerView.Adapter<PostUserAdapter.ViewHolder>() {

    private val items: MutableList<PostUserBind> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    fun setData(newItems: List<PostUserBind>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyItemChanged(0, items.lastIndex)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(
        private val binding: ItemPostLayoutBinding
    ) : BaseViewHolder<PostUserBind>(binding.root) {

        override fun bind(item: PostUserBind) {
            binding.setVariable(BR.userPost, item)
        }
    }

}