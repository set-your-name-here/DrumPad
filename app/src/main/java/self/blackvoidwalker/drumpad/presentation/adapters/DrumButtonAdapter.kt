package self.blackvoidwalker.drumpad.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import self.blackvoidwalker.drumpad.R
import self.blackvoidwalker.drumpad.entities.DrumButton
import self.blackvoidwalker.drumpad.presentation.listeners.OnDrumClickListener
import kotlinx.android.synthetic.main.fragment_drum_button.view.*

class DrumButtonAdapter(private var clickListener: OnDrumClickListener) :
    RecyclerView.Adapter<DrumButtonAdapter.DrumButtonView>() {

    var buttons: ArrayList<DrumButton> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrumButtonView =
        DrumButtonView(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_drum_button,
                parent,
                false
            )
        )


    override fun getItemCount(): Int = buttons.size

    override fun onBindViewHolder(holder: DrumButtonView, position: Int) {
        val button = buttons[position]
        holder.title.text = button.type.value
    }

    inner class DrumButtonView(view: View) : RecyclerView.ViewHolder(view) {

        var title: AppCompatTextView = view.buttonTitle

        init {
            view.setOnClickListener {
                clickListener.onDrumClick(
                    buttons[adapterPosition].id
                )
            }
        }
    }


}