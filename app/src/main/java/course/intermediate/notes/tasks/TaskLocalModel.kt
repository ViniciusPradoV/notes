package course.intermediate.notes.tasks

import course.intermediate.notes.application.NoteApplication
import course.intermediate.notes.database.RoomDatabaseClient
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Task> = retrieveTasks().toMutableList()

//        mutableListOf<Task>(
//        Task(
//            " Testing One", mutableListOf(
//                Todo(
//                    description = "Test one!",
//                    isComplete = true
//                ),
//                Todo(
//                    description = "Test Two"
//                )
//            )
//        ),
//        Task(
//            "Testing Two"
//        ),
//        Task(
//            "Testing Three",
//            mutableListOf(
//                Todo(description = "Test A!"),
//                Todo(description = "Test B!")
//            )
//        )
//    )

    override fun addTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().addTask(task)
        addTodosInTask(task)
        callback.invoke(true)
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().updateTask((task))
        callback.invoke(true)

    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().deleteTask(task)
        callback.invoke(true)

    }

    private fun addTodosInTask(task: Task){

        task.todos.forEach{todo->
            databaseClient.taskDAO().addTodo(todo)
        }


    }

    override fun updateTodo(todo: Todo, callback: SuccessCallback) {
        databaseClient.taskDAO().updateTodo(todo)
        callback.invoke(true)
    }

    override fun retrieveTasks(): List<Task> = databaseClient.taskDAO().retrieveTasks()

}
