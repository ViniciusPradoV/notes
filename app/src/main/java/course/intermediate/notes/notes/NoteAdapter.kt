package course.intermediate.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.R
import course.intermediate.notes.foundations.BaseReclyclerAdapter
import course.intermediate.notes.models.Note
import course.intermediate.notes.navigation.NavigationActivity
import course.intermediate.notes.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
) : BaseReclyclerAdapter<Note>(noteList) {

    class NoteViewHolder(view: View) : BaseReclyclerAdapter.BaseViewHolder<Note>(view) {

        override fun onBind(data: Note) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View): BaseReclyclerAdapter.BaseViewHolder<Unit>(view){

        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener{
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =  if(viewType == TYPE_INFO){
        NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }else{

        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    }

}

