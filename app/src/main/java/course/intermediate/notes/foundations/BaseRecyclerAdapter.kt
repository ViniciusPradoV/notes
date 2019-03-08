package course.intermediate.notes.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.notes.NoteAdapter
import course.intermediate.notes.tasks.TaskAdapter

abstract class BaseReclyclerAdapter<T>(
    protected val masterList: MutableList<T>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(list: List<T>){
        masterList.clear()
        masterList.addAll(list)
        notifyDataSetChanged()

    }

    abstract class BaseViewHolder<T>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: T, listIndex: Int)
    }


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun getItemViewType(position: Int): Int = if(position == 0){
        TYPE_ADD_BUTTON
    }else{
        TYPE_INFO
    }

    override fun getItemCount(): Int = masterList.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is NoteAdapter.AddButtonViewHolder) {
            holder.onBind(Unit, position-1)
        } else if (holder is TaskAdapter.AddButtonViewHolder) {
            holder.onBind(Unit, position-1)
        } else {
            (holder as BaseViewHolder<T>).onBind(masterList[position - 1], position-1)
        }
    }

    companion object {

        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

}

