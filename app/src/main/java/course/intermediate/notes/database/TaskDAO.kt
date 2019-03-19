package course.intermediate.notes.database

import androidx.room.*
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.TaskEntity
import course.intermediate.notes.models.Todo

@Dao
interface TaskDAO {

    @Insert
    fun addTask(task: TaskEntity)

    @Insert
    fun addTodo(todo: Todo)

    @Update
    fun updateTask(task: TaskEntity)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTask(task: TaskEntity)

    @Query("SELECT * FROM tasks")
    fun retrieveTasks(): MutableList<Task>
}