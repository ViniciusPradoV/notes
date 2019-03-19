package course.intermediate.notes.notes

import course.intermediate.notes.application.NoteApplication
import course.intermediate.notes.database.RoomDatabaseClient
import course.intermediate.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel{

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Note> = retrieveNotes().toMutableList()

//        mutableListOf<Note>(
//        Note(description = "I'm test note 1"),
//        Note(description = "I'm test note 2")

    override fun addNote(note: Note, callback: SuccessCallback) {
       databaseClient.noteDAO().addNote(note)
        callback.invoke(true)
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().updateNote(note)
        callback.invoke(true)
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().deleteNote(note)
        callback.invoke(true)
    }

    override fun retrieveNotes(): List<Note> = databaseClient.noteDAO().retrieveNote()

}
