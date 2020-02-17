package com.rubygrapecore.drumpad.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rubygrapecore.drumpad.R
import com.rubygrapecore.drumpad.domain.DrumSound
import com.rubygrapecore.drumpad.domain.DrumViewModel
import com.rubygrapecore.drumpad.entities.DrumButton
import com.rubygrapecore.drumpad.entities.DrumButtonClass
import com.rubygrapecore.drumpad.presentation.adapters.DrumButtonAdapter
import com.rubygrapecore.drumpad.presentation.listeners.OnDrumClickListener
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_drum.*

class DrumFragment : Fragment(R.layout.fragment_drum), OnDrumClickListener, View.OnClickListener {

    private lateinit var drumViewModel: DrumViewModel

    private val drumCompositeDisposable = CompositeDisposable()
    private val drumButtonAdapter = DrumButtonAdapter(clickListener = this)

    private var drumCurrentClass: DrumButtonClass = DrumButtonClass.ACOUSTIC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drumViewModel = ViewModelProvider(this)[DrumViewModel::class.java]

        drumViewModel.drumSoundPool = DrumSound(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        drumCompositeDisposable.add(
            drumViewModel.getDrums().subscribe(::setButtons)
        )
    }

    override fun onStop() {
        super.onStop()
        drumCompositeDisposable.clear()
    }

    private fun initView() {
        drumTypeButtonLeft.setOnClickListener(this)
        drumTypeButtonRight.setOnClickListener(this)

        with(drumButtonsLayout) {
            adapter = drumButtonAdapter
            layoutManager =
                GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        }

        drumViewModel
            .drumBehaviorSubject
            .onNext(drumCurrentClass)
    }

    private fun setButtons(buttons: List<DrumButton>) {
        drumButtonAdapter.buttons.clear()
        drumButtonAdapter.buttons.addAll(buttons)
        drumButtonAdapter.notifyDataSetChanged()
        drumViewModel.drumSoundPool.changeSound(buttons)
    }

    override fun onDrumClick(id: Int) {
        drumViewModel.drumSoundPool.playSound(id)
    }

    override fun onClick(view: View) {
        when (view) {
            drumTypeButtonLeft -> {
                drumCurrentClass = when (drumCurrentClass) {
                    DrumButtonClass.ELECTRONIC -> {
                        DrumButtonClass.ACOUSTIC
                    }
                    DrumButtonClass.SOUNDSCAPE -> {
                        DrumButtonClass.ELECTRONIC
                    }
                    else -> {
                        DrumButtonClass.SOUNDSCAPE
                    }
                }
            }
            drumTypeButtonRight -> {
                drumCurrentClass = when (drumCurrentClass) {
                    DrumButtonClass.ACOUSTIC -> {
                        DrumButtonClass.ELECTRONIC
                    }
                    DrumButtonClass.ELECTRONIC -> {
                        DrumButtonClass.SOUNDSCAPE
                    }
                    else -> {
                        DrumButtonClass.ACOUSTIC
                    }
                }
            }
        }
        setDrumClass(drumCurrentClass)
    }

    private fun setDrumClass(drumButtonClass: DrumButtonClass) {
        val typeTitle = when (drumButtonClass) {
            DrumButtonClass.ACOUSTIC -> {
                getString(R.string.drum_type_acoustic)
            }
            DrumButtonClass.ELECTRONIC -> {
                getString(R.string.drum_type_electronic)
            }
            DrumButtonClass.SOUNDSCAPE -> {
                getString(R.string.drum_type_soundscape)
            }
        }
        drumTypeTitle.text = typeTitle
        drumViewModel
            .drumBehaviorSubject
            .onNext(drumCurrentClass)
    }

}