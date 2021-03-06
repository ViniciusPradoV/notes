package course.intermediate.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.R
import course.intermediate.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1


) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit, deleteTaskCallback: ()->Unit) {
        resetChildViews()
        this.task = task
        initTaskLine(deleteTaskCallback)
        addChildViews(todoCheckedCallback)


    }

    private fun resetChildViews(){
        todoContainer.removeAllViewsInLayout()
    }

    private fun initTaskLine(deleteTaskCallback: () -> Unit){
        titleView.text = task.title
        imageButton.setOnClickListener{
            deleteTaskCallback.invoke()
        }
    }

    private fun addChildViews(todoCheckedCallback: (Int, Boolean) -> Unit){

        task.todos.forEachIndexed { todoIndex, todo ->
            val todoView =
                (LayoutInflater.from(context).inflate(R.layout.view_todo, todoContainer, false) as TodoView).apply {
                    initView(todo) { isChecked ->

                        todoCheckedCallback.invoke(todoIndex, isChecked)

                        if (task.isComplete()) {
                            this@TaskView.titleView.setStrikeThrough()
                        } else {
                            this@TaskView.titleView.removeStrikeThrough()
                        }
                    }
                }
            todoContainer.addView(todoView)
        }
    }
}
