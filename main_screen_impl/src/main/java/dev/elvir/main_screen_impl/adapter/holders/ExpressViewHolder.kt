package dev.elvir.main_screen_impl.adapter.holders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.main_screen_impl.R

class ExpressViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(
            R.layout.list_item_forecast_express,
            parent,
            false
        )
    ) {
    var btnText: TextView? = null
    var btnRootView: ConstraintLayout? = null


    init {
        btnText = itemView.findViewById(R.id.btn_repeat_text)
        btnRootView = itemView.findViewById(R.id.btn_repeat)

    }

    fun bind(context: Context) {
        btnText?.setTextColor(ContextCompat.getColor(context, R.color.white))
    }
}