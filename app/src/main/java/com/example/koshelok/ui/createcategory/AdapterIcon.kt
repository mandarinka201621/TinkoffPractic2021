package com.example.koshelok.ui.createcategory

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.ItemIconBinding
import com.example.koshelok.ui.entity.IconEntity

class AdapterIcon(private val onIconItemClick: (position: Int, item: IconEntity) -> Unit) :
    ListAdapter<IconEntity, AdapterIcon.IconViewHolder>(IconDiffCallback()) {

    private var enableColor = Color.parseColor(DEFAULT_COLOR)

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): IconViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_icon, parent, false)
        val viewHolder = IconViewHolder(rootView)
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.adapterPosition != RecyclerView.NO_POSITION)
                onClicked(viewHolder.adapterPosition, currentList[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    fun setEnableColor(color: Int) {
        enableColor = color
    }

    private fun onClicked(position: Int, item: IconEntity) {
        onIconItemClick(position, item)
    }

    companion object {
        private const val DEFAULT_COLOR = "#333333"
    }

    inner class IconViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val binding by viewBinding(ItemIconBinding::bind)

        fun onBind(data: IconEntity) {
            with(binding) {
                iconImageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        root.context,
                        data.resIcon
                    )
                )
                if (data.isEnable) {
                    iconImageView.backgroundTintList =
                        ColorStateList.valueOf(enableColor)
                } else {
                    iconImageView.backgroundTintList = ColorStateList.valueOf(data.color)
                }
            }
        }
    }
}
