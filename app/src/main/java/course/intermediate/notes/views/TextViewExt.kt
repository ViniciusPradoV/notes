package course.intermediate.notes.views

import android.graphics.Paint
import android.widget.TextView

fun TextView.setStrikeThrough(){

    this.apply {
        paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

}

fun TextView.removeStrikeThrough(){

    this.apply {
        paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }

}