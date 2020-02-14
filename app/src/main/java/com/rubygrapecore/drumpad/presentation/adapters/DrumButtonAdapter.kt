package com.rubygrapecore.drumpad.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rubygrapecore.drumpad.R
import com.rubygrapecore.drumpad.entities.Button

class DrumButtonAdapter(var buttons: ArrayList<Button>) : RecyclerView.Adapter<DrumButtonAdapter.DrumButtonView>() {

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

    }

    inner class DrumButtonView(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {

            }
        }
    }


}