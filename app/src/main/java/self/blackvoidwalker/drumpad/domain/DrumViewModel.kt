package self.blackvoidwalker.drumpad.domain

import androidx.lifecycle.ViewModel
import self.blackvoidwalker.drumpad.entities.DrumButton
import self.blackvoidwalker.drumpad.entities.DrumButtonClass
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class DrumViewModel : ViewModel(){

    val drumBehaviorSubject: BehaviorSubject<DrumButtonClass> = BehaviorSubject.create()
    lateinit var drumSoundPool : DrumSound

    fun getDrums(): Observable<List<DrumButton>> = drumBehaviorSubject
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map {classification -> getDrumsByClass(classification) }
            .observeOn(AndroidSchedulers.mainThread())

    private fun getDrumsByClass(classification: DrumButtonClass) : List<DrumButton> =
        enumValues<DrumButton>()
            .filter { b -> b.classification == classification}
            .sortedBy { b -> b.id }

}