package course.intermediate.notes.foundations

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseReclyclerAdapter<T>(
    protected val masterList: MutableList<T>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract class BaseViewHolder<T>(val view: View): RecyclerView.ViewHolder(view){
        abstract fun onBind(data: T)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int = masterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as BaseViewHolder<T>).onBind(masterList[position])

    }
}