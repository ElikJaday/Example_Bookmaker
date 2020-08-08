package dev.elvir.main_screen_impl.adapter.holders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.main_screen_impl.R

class PastViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.list_item_forecast_past,
        parent,
        false
    )
) {
    var btnRootView: ConstraintLayout? = null

    init {
        btnRootView = itemView.findViewById(R.id.btn_repeat)
    }

    fun bind(context: Context) {
        btnRootView?.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
    }
}