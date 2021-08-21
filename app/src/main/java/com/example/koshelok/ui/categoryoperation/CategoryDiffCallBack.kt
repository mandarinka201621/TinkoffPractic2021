package com.example.koshelok.ui.categoryoperation

import androidx.recyclerview.widget.DiffUtil
import com.example.koshelok.ui.model.CategoryModel

class CategoryDiffCallBack : DiffUtil.ItemCallback<CategoryModel>() {

    override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem == newItem
    }
}
