package course.intermediate.notes.notes

import android.util.Log
import course.intermediate.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel{

    override fun getFakeData() = mutableListOf<Note>(
        Note("I'm test note 1"),
        Note("I'm test note 2")
    )

    override fun addNote(note: Note, callback: SuccessCallback) {
        Log.d("UdemyCourse", note.toString())
        callback.invoke(true)
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveNotes(): List<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
