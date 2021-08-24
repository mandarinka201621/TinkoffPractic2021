package com.example.koshelok.ui.categories.createcategory

import androidx.recyclerview.widget.DiffUtil
import com.example.koshelok.ui.util.entity.IconEntity

class IconDiffCallback : DiffUtil.ItemCallback<IconEntity>() {

    override fun areItemsTheSame(oldItem: IconEntity, newItem: IconEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: IconEntity, newItem: IconEntity): Boolean {
        return oldItem == newItem
    }
}
