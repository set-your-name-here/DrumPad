package self.blackvoidwalker.drumpad.presentation.fragments

import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import self.blackvoidwalker.drumpad.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var splashHandler = Handler()
    private var splashRunnable = Runnable {
        findNavController().navigate(R.id.action_splashFragment_to_drumFragment)
    }

    override fun onStart() {
        super.onStart()
        splashHandler.postDelayed(splashRunnable, SPLASH_DELAY)
    }

    override fun onStop() {
        super.onStop()
        splashHandler.removeCallbacks(splashRunnable)
    }

    companion object {
        private const val SPLASH_DELAY = 1500L
    }

}