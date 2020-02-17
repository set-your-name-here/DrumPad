package com.rubygrapecore.drumpad.entities

import com.rubygrapecore.drumpad.R

enum class DrumButton(val id: Int, val classification: DrumButtonClass, val type: DrumButtonType, val res: Int) {

    //Acoustic classes
    ACOUSTIC_OPEN_HI_HAT(0, DrumButtonClass.ACOUSTIC, DrumButtonType.OPEN_HI_HAT, R.raw.a_open_hat),
    ACOUSTIC_TOM1(1, DrumButtonClass.ACOUSTIC, DrumButtonType.TOM1, R.raw.a_tom_1),
    ACOUSTIC_TOM2(2, DrumButtonClass.ACOUSTIC, DrumButtonType.TOM2, R.raw.a_tom_2),
    ACOUSTIC_CRASH(3, DrumButtonClass.ACOUSTIC, DrumButtonType.CRASH, R.raw.a_crash),
    ACOUSTIC_CLOSE_HI_HAT(4, DrumButtonClass.ACOUSTIC, DrumButtonType.CLOSE_HI_HAT, R.raw.a_closed_hat),
    ACOUSTIC_SNARE(5, DrumButtonClass.ACOUSTIC, DrumButtonType.SNARE, R.raw.a_snare),
    ACOUSTIC_BASS(6, DrumButtonClass.ACOUSTIC, DrumButtonType.BASS, R.raw.a_bass),
    ACOUSTIC_CLAP(7, DrumButtonClass.ACOUSTIC, DrumButtonType.CLAP, R.raw.a_clap),

    //Electronic classes
    E_OPEN_HI_HAT(0, DrumButtonClass.ELECTRONIC, DrumButtonType.OPEN_HI_HAT, R.raw.e_open_hat),
    E_TOM1(1, DrumButtonClass.ELECTRONIC, DrumButtonType.TOM1, R.raw.e_tom_1),
    E_TOM2(2, DrumButtonClass.ELECTRONIC, DrumButtonType.TOM2, R.raw.e_tom_2),
    E_CRASH(3, DrumButtonClass.ELECTRONIC, DrumButtonType.CRASH, R.raw.e_crash),
    E_CLOSE_HI_HAT(4, DrumButtonClass.ELECTRONIC, DrumButtonType.CLOSE_HI_HAT, R.raw.e_closed_hat),
    E_SNARE(5, DrumButtonClass.ELECTRONIC, DrumButtonType.SNARE, R.raw.e_snare),
    E_BASS(6, DrumButtonClass.ELECTRONIC, DrumButtonType.BASS, R.raw.e_bass),
    E_CLAP(7, DrumButtonClass.ELECTRONIC, DrumButtonType.CLAP, R.raw.e_clap),

    //Soundscape
    SCAPE_OPEN_HI_HAT(0, DrumButtonClass.SOUNDSCAPE, DrumButtonType.OPEN_HI_HAT, R.raw.s_open_hat),
    SCAPE_TOM1(1, DrumButtonClass.SOUNDSCAPE, DrumButtonType.TOM1, R.raw.s_tom_1),
    SCAPE_TOM2(2, DrumButtonClass.SOUNDSCAPE, DrumButtonType.TOM2, R.raw.s_tom_2),
    SCAPE_CRASH(3, DrumButtonClass.SOUNDSCAPE, DrumButtonType.CRASH, R.raw.s_crash),
    SCAPE_CLOSE_HI_HAT(4, DrumButtonClass.SOUNDSCAPE, DrumButtonType.CLOSE_HI_HAT, R.raw.s_closed_hat),
    SCAPE_SNARE(5, DrumButtonClass.SOUNDSCAPE, DrumButtonType.SNARE, R.raw.s_snare),
    SCAPE_BASS(6, DrumButtonClass.SOUNDSCAPE, DrumButtonType.BASS, R.raw.s_bass),
    SCAPE_CLAP(7, DrumButtonClass.SOUNDSCAPE, DrumButtonType.CLAP, R.raw.s_clap),

}