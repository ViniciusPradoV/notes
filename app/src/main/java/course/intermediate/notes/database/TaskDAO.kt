package course.intermediate.notes.database

import androidx.room.*
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.TaskEntity

@Dao
interface TaskDAO {

    @Insert
    fun addTask(task: TaskEntity)

    @Update
    fun updateTask(task: TaskEntity)

    @Delete
    fun deleteTask(task: TaskEntity)

    @Query("SELECT * FROM tasks")
    fun retrieveTasks(): MutableList<Task>
}