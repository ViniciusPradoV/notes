package course.intermediate.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Note

class NoteViewModel : ViewModel(), NoteListViewContract {

    private val model: NoteModel = NoteModel()

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    var noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {

        _noteListLiveData.postValue(model.getFakeData())

    }
}
