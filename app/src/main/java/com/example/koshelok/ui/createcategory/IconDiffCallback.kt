package com.example.koshelok.ui.createcategory

import androidx.recyclerview.widget.DiffUtil
import com.example.koshelok.ui.entity.IconEntity

class IconDiffCallback : DiffUtil.ItemCallback<IconEntity>() {

    override fun areItemsTheSame(oldItem: IconEntity, newItem: IconEntity): Boolean {
        return oldItem.isEnable == newItem.isEnable
    }

    override fun areContentsTheSame(oldItem: IconEntity, newItem: IconEntity): Boolean {
        return oldItem == newItem
    }
}
