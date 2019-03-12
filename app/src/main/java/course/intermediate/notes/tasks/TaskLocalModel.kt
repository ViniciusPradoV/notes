package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor(): ITaskModel{

    override fun getFakeData(): MutableList<Task> = mutableListOf<Task>(
        Task(
            " Testing One", mutableListOf(
                Todo(
                    "Test one!",
                    true
                ),
                Todo(
                    "Test Two"
                )
            )
        ),
        Task(
            " Testing Two"
        ),
        Task(
            "Testing Three",
            mutableListOf(
                Todo("Test A!"),
                Todo("Test B!")
            )
        )
    )

    override fun addTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveTasks(): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}