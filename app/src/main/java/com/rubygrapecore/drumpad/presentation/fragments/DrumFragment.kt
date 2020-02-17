package com.rubygrapecore.drumpad.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rubygrapecore.drumpad.R
import com.rubygrapecore.drumpad.domain.DrumViewModel
import com.rubygrapecore.drumpad.entities.DrumButton
import com.rubygrapecore.drumpad.entities.DrumButtonClass
import com.rubygrapecore.drumpad.presentation.adapters.DrumButtonAdapter
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_drum.*

class DrumFragment : Fragment(R.layout.fragment_drum) {


    private lateinit var drumViewModel: DrumViewModel

    private val drumCompositeDisposable = CompositeDisposable()

    private val drumButtonAdapter = DrumButtonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drumViewModel = ViewModelProvider(this)[DrumViewModel::class.java]
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
        with(drumButtonsLayout) {
            adapter = drumButtonAdapter
            layoutManager =
                GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        }

        drumViewModel.drumBehaviorSubject.onNext(DrumButtonClass.ACOUSTIC)
    }

    private fun setButtons(buttons: List<DrumButton>) {
        drumButtonAdapter.buttons.addAll(buttons)
        drumButtonAdapter.notifyDataSetChanged()
    }

}