package com.example.koshelok.ui.categoryoperation

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.ItemCategoryBinding
import com.example.koshelok.ui.entity.CategoryEntity

class AdapterCategory(private val onCategoryItemClick: CategoryItemClickListener) :
    ListAdapter<CategoryEntity, AdapterCategory.CategoryViewHolder>(CategoryDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        val viewHolder = CategoryViewHolder(rootView)
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.adapterPosition != RecyclerView.NO_POSITION)
                onClicked(viewHolder.adapterPosition, currentList[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    private fun onClicked(position: Int, item: CategoryEntity) {
        onCategoryItemClick.onClickItem(position, item)
    }
    inner class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val binding by viewBinding(ItemCategoryBinding::bind)

        fun onBind(data: CategoryEntity) {
            with(binding) {
                iconImageView.setImageDrawable(ContextCompat.getDrawable(root.context, data.icon))
                iconImageView.backgroundTintList = ColorStateList.valueOf(data.color)
                titleTextView.text = data.typeOperation
                if (data.isEnable) checkImageView.visibility =
                    View.VISIBLE else checkImageView.visibility = View.INVISIBLE
            }
        }
    }

}

interface CategoryItemClickListener {
    fun onClickItem(position: Int, item: CategoryEntity)
}
