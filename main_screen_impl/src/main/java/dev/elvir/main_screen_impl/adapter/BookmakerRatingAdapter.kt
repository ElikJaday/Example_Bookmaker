package dev.elvir.main_screen_impl.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.bookmaker_provider_api.data.model.BookmakerRatingsModel
import dev.elvir.bookmaker_provider_api.data.model.BookmakerType
import dev.elvir.main_screen_impl.R

class BookmakerRatingAdapter(
    private val context: Context,
    private val bookmakerList: List<BookmakerRatingsModel>
) : RecyclerView.Adapter<BookmakerRatingAdapter.BookmakerRatingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmakerRatingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BookmakerRatingViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BookmakerRatingViewHolder, position: Int) {
        val model: BookmakerRatingsModel = bookmakerList[position]
        holder.bind(model, context)
    }

    override fun getItemCount(): Int = bookmakerList.size


    class BookmakerRatingViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                R.layout.list_item_bookmaker_rating,
                parent,
                false
            )
        ) {
        private var image: ImageView? = null
        private var percent: TextView? = null
        private var bonus: TextView? = null
        private var rootContainer: CardView? = null

        init {
            image = itemView.findViewById(R.id.book_maker_img)
            percent = itemView.findViewById(R.id.book_maker_percent)
            bonus = itemView.findViewById(R.id.book_maker_bonus)
            rootContainer = itemView.findViewById(R.id.forecast_feed_root_container)
        }

        fun bind(model: BookmakerRatingsModel, context: Context) {
            model.bookmakerPercent?.let {
                percent?.text = it.toString()
            }
            model.bookmakerBonus?.let {
                bonus?.text = context.resources.getString(R.string.book_maker_bonus_text, it)
            }

            when (model.bookmakerType) {
                BookmakerType.WINLINE -> {
                    image?.background = ContextCompat.getDrawable(context, R.drawable.logo_winline)
                    rootContainer?.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.background_for_winline
                        )
                    )
                }
                BookmakerType.STAVKA -> {
                    image?.background = ContextCompat.getDrawable(context, R.drawable.logo_1xstavka)
                    rootContainer?.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.background_for_stavka
                        )
                    )
                }
                BookmakerType.BETCITY -> {
                    image?.background = ContextCompat.getDrawable(context, R.drawable.logo_betcity)
                    rootContainer?.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.background_for_betcitry
                        )
                    )
                }
                BookmakerType.PARIMATCH -> {
                    image?.background =
                        ContextCompat.getDrawable(context, R.drawable.logo_parimatch)
                    rootContainer?.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.background_for_parimatch
                        )
                    )
                }
            }

        }

    }
}