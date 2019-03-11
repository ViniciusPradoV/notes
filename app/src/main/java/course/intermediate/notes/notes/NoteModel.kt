package course.intermediate.notes.notes

import course.intermediate.notes.models.Note

class NoteModel {

    fun getFakeData() = mutableListOf<Note>(
        Note("I'm test note 1"),
        Note("I'm test note 2")
    )
}
