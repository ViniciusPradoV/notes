package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo

class TaskModel {

    fun getFakeData(): MutableList<Task> = mutableListOf<Task>(
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
}
