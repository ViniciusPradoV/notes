package course.intermediate.notes.create

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import course.intermediate.notes.R
import course.intermediate.notes.foundations.StateChangeTextWatcher
import course.intermediate.notes.views.CreateTodoView
import kotlinx.android.synthetic.main.fragment_create_task.*
import kotlinx.android.synthetic.main.view_create_task.*
import kotlinx.android.synthetic.main.view_create_task.view.*
import kotlinx.android.synthetic.main.view_create_todo.view.*

private const val MAX_TODO_COUNT = 5

class CreateTaskFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createTaskView.taskEditText.addTextChangedListener(object : StateChangeTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrEmpty() && previousValue.isNullOrEmpty()) {
                    addTodoView()
                } else if (s.isNullOrEmpty() && !previousValue.isNullOrEmpty()) {
                    for (todoView in 1..(containerView.childCount-1)) removeTodoView(containerView.getChildAt(containerView.childCount - 1))
                }

                super.afterTextChanged(s)
            }
        })
    }

    private fun addTodoView() {
        if (canAddTodos()) {
            val view = (LayoutInflater.from(context).inflate(
                R.layout.view_create_todo,
                containerView,
                false
            ) as CreateTodoView).apply {
                todoEditText.addTextChangedListener(object : StateChangeTextWatcher() {
                    override fun afterTextChanged(s: Editable?) {


                        if (!s.isNullOrEmpty() && previousValue.isNullOrEmpty()) {
                            addTodoView()
                        } else if (s.isNullOrEmpty() && !previousValue.isNullOrEmpty()) {
                            removeTodoView(this@apply)
                        }

                        super.afterTextChanged(s)
                    }
                })

            }

            containerView.addView(view)
        }
    }

    private fun removeTodoView(view: View) {
        containerView.removeView(view)

    }

    private fun canAddTodos(): Boolean = containerView.childCount <= MAX_TODO_COUNT

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    companion object {
        fun newInstance() = CreateTaskFragment()
    }
}
