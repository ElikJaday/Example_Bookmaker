package dev.elvir.main_screen_impl.adapter.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.main_screen_impl.R

class PromotionViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(
            R.layout.list_item_forecast_promotion,
            parent,
            false
        )
    )