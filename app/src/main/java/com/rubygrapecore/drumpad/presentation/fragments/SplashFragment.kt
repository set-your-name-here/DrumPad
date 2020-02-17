package com.rubygrapecore.drumpad.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rubygrapecore.drumpad.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var splashHandler = Handler()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashHandler.postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_drumFragment)
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY = 1500L
    }

}