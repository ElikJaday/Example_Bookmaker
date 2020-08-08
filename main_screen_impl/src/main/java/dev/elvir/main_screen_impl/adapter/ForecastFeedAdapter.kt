package dev.elvir.main_screen_impl.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.bookmaker_provider_api.data.model.ForecastModel
import dev.elvir.bookmaker_provider_api.data.model.ForecastType
import dev.elvir.main_screen_impl.R
import dev.elvir.main_screen_impl.adapter.holders.ExpressViewHolder
import dev.elvir.main_screen_impl.adapter.holders.PastViewHolder

class ForecastFeedAdapter(
    private val context: Context,
    private val forecastList: List<ForecastModel>,
    private var listener: (Unit) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_EVENT_PROMOTION = 0
        const val TYPE_EVENT_PAST = 1
        const val TYPE_EVENT_EXPRESS = 2
        const val TYPE_EVENT_NEW = 3

    }

    override fun getItemViewType(position: Int): Int =
        when (forecastList[position].forecastType) {
            ForecastType.TYPE_EVENT_PROMOTION -> {
                TYPE_EVENT_PROMOTION
            }
            ForecastType.TYPE_EVENT_PAST -> {
                TYPE_EVENT_PAST
            }
            ForecastType.TYPE_EVENT_EXPRESS -> {
                TYPE_EVENT_EXPRESS
            }
            else -> 0
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_EVENT_PROMOTION -> PromotionViewHolder(
                LayoutInflater.from(parent.context),
                parent
            )
            TYPE_EVENT_PAST -> PastViewHolder(
                LayoutInflater.from(parent.context),
                parent
            )
            TYPE_EVENT_EXPRESS -> ExpressViewHolder(
                LayoutInflater.from(parent.context),
                parent
            )
            else -> PromotionViewHolder(LayoutInflater.from(parent.context), parent)
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PromotionViewHolder -> {

            }
            is PastViewHolder -> {
                holder.bind(context)
                holder.btnRootView?.setOnClickListener {
                    listener.invoke(Unit)
                }
            }
            is ExpressViewHolder -> {
                holder.bind(context)
                holder.btnRootView?.setOnClickListener {
                    listener.invoke(Unit)
                }
            }
            else -> {
            }
        }
    }

    override fun getItemCount(): Int = forecastList.size


    class PromotionViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                R.layout.list_item_forecast_promotion,
                parent,
                false
            )
        )


}