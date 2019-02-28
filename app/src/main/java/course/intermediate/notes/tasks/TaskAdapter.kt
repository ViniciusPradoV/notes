package course.intermediate.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.R
import course.intermediate.notes.foundations.BaseReclyclerAdapter
import course.intermediate.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

class TaskAdapter(taskList: MutableList<Task> = mutableListOf()
): BaseReclyclerAdapter<Task>(taskList) {

    class ViewHolder(view: View):BaseViewHolder<Task>(view){

        override fun onBind(data: Task) {
            view.titleView.text = data.title
            data.todos.forEach {todo ->

                val todoView = LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todoContainer, false)
                todoView.descriptionView.text = todo.description
                view.todoContainer.addView(todoView)

            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
}