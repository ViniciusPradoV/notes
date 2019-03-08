package course.intermediate.notes.notes


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import course.intermediate.notes.R
import course.intermediate.notes.models.Note
import kotlinx.android.synthetic.main.fragment_tasks_list.*


class NotesListFragment : Fragment() {

    lateinit var viewModel: NoteViewModel
    lateinit var contextView: NoteListView
    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let{
            if (it is TouchActionDelegate){
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false).apply {
           contextView = (this as NoteListView)

        }
    }

    private fun setContetView(){

        contextView.initView(touchActionDelegate, viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setContetView()
    }

    private fun bindViewModel (){
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        viewModel.noteListLiveData.observe(this, Observer{noteList ->
            contextView.updateList(noteList)

        })

    }

    companion object {

        fun newInstance(): NotesListFragment {
            return NotesListFragment()
        }
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}
