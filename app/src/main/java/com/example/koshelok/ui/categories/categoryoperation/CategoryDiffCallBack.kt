package com.example.koshelok.ui.categories.categoryoperation

import androidx.recyclerview.widget.DiffUtil
import com.example.koshelok.ui.util.entity.CategoryEntity

class CategoryDiffCallBack : DiffUtil.ItemCallback<CategoryEntity>() {

    override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem == newItem
    }
}
