package dev.elvir.main_screen_impl.widgets


import android.content.Context
import android.util.AttributeSet
import android.view.View
import dev.elvir.main_screen_impl.R


class ExpandableTextView : androidx.appcompat.widget.AppCompatTextView, View.OnClickListener {

    var myMaxLines = Int.MAX_VALUE

    constructor(context: Context?) : super(context) {
        setOnClickListener(this)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        setOnClickListener(this)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setOnClickListener(this)
    }

    override fun onTextChanged(
        text: CharSequence,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        /* If text longer than MAX_LINES set DrawableBottom - I'm using '...' icon */
        post {
            if (lineCount > MAX_LINES) setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.ic_more,
                0
            ) else setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            maxLines = MAX_LINES
        }
    }

    override fun setMaxLines(maxLines: Int) {
        myMaxLines = maxLines
        super.setMaxLines(maxLines)
    }

    override fun onClick(v: View?) {
        /* Toggle between expanded collapsed states */
        maxLines = if (myMaxLines == Int.MAX_VALUE) MAX_LINES else Int.MAX_VALUE
    }

    companion object {
        private const val MAX_LINES = 2
    }
}