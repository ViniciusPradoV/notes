package course.intermediate.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.R
import course.intermediate.notes.foundations.BaseReclyclerAdapter
import course.intermediate.notes.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf()
) : BaseReclyclerAdapter<Note>(noteList) {

    class ViewHolder(view: View) : BaseReclyclerAdapter.BaseViewHolder<Note>(view) {

        override fun onBind(data: Note) {
            view.titleView.text = data.description
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
}