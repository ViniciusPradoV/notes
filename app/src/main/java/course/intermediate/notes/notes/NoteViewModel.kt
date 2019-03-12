package course.intermediate.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.foundations.ApplicationScope
import course.intermediate.notes.models.Note
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel : ViewModel(), NoteListViewContract {

    @Inject
    lateinit var model: INoteModel

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    var noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        Toothpick.inject(this, ApplicationScope.scope)
        _noteListLiveData.postValue(model.getFakeData())

    }
}
