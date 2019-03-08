package course.intermediate.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.R
import course.intermediate.notes.foundations.BaseReclyclerAdapter
import course.intermediate.notes.models.Task
import course.intermediate.notes.navigation.NavigationActivity
import course.intermediate.notes.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf(),
    val touchActionDelegate: TasksListFragment.TouchActionDelegate,
    val dataActionDelegate: TaskListViewContract
): BaseReclyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if(viewType == TYPE_INFO){
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }else {
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    }

    inner class TaskViewHolder(view: View):BaseViewHolder<Task>(view){

        override fun onBind(data: Task, listIndex: Int) {

            (view as TaskView).initView(data){todoIndex, isChecked ->
                dataActionDelegate.onTodoUpdated(listIndex, todoIndex, isChecked)
            }
        }
    }

    inner class AddButtonViewHolder(view: View): BaseViewHolder<Unit>(view) {
        override fun onBind(data: Unit, listIndex: Int) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)

            view.setOnClickListener{
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_TASK)
            }
        }
    }

    override fun getItemCount(): Int = masterList.size+1

}