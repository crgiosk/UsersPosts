package com.pruebadeingreso.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.pruebadeingreso.databinding.ItemUserLayoutBinding
import com.pruebadeingreso.ui.binds.UserBind
import com.pruebadeingreso.BR
import com.pruebadeingreso.core.Extensions.setSingleClickListener

class UserAdapter(
    val onClickItem: (UserBind) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val items: MutableList<UserBind> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun setData(newItems: List<UserBind>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyItemChanged(0, items.lastIndex)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(
        private val binding: ItemUserLayoutBinding
    ) : BaseViewHolder<UserBind>(binding.root) {

        override fun bind(item: UserBind) {

            binding.viewPostButton.setSingleClickListener({
                onClickItem.invoke(item)
            })

            binding.setVariable(BR.user, item)
        }
    }

}