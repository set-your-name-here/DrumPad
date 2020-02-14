package com.rubygrapecore.drumpad.entities

enum class Button(id: Int, classification: ButtonClass, type: ButtonType, res: Int) {

    //Live classes
    LIVE_OPEN_HI_HAT(0, ButtonClass.LIVE, ButtonType.OPEN_HI_HAT, 0),
    LIVE_CLOSE_HI_HAT(1, ButtonClass.LIVE, ButtonType.CLOSE_HI_HAT, 0),
    LIVE_TOM1(2, ButtonClass.LIVE, ButtonType.TOM1, 0),
    LIVE_TOM2(3, ButtonClass.LIVE, ButtonType.TOM2, 0),
    LIVE_CRASH(4, ButtonClass.LIVE, ButtonType.CRASH, 0),
    LIVE_CLAP(5, ButtonClass.LIVE, ButtonType.CLAP, 0),
    LIVE_SNARE(6, ButtonClass.LIVE, ButtonType.SNARE, 0),
    LIVE_BASS(7, ButtonClass.LIVE, ButtonType.BASS, 0),

    //Electronic classes
    E_OPEN_HI_HAT(0, ButtonClass.ELECTRONIC, ButtonType.OPEN_HI_HAT, 0),
    E_CLOSE_HI_HAT(1, ButtonClass.ELECTRONIC, ButtonType.CLOSE_HI_HAT, 0),
    E_TOM1(2, ButtonClass.ELECTRONIC, ButtonType.TOM1, 0),
    E_TOM2(3, ButtonClass.ELECTRONIC, ButtonType.TOM2, 0),
    E_CRASH(4, ButtonClass.ELECTRONIC, ButtonType.CRASH, 0),
    E_CLAP(5, ButtonClass.ELECTRONIC, ButtonType.CLAP, 0),
    E_SNARE(6, ButtonClass.ELECTRONIC, ButtonType.SNARE, 0),
    E_BASS(7, ButtonClass.ELECTRONIC, ButtonType.BASS, 0),

    //Soundscape
    SCAPE_OPEN_HI_HAT(0, ButtonClass.SOUNDSCAPE, ButtonType.OPEN_HI_HAT, 0),
    SCAPE_CLOSE_HI_HAT(1, ButtonClass.SOUNDSCAPE, ButtonType.CLOSE_HI_HAT, 0),
    SCAPE_TOM1(2, ButtonClass.SOUNDSCAPE, ButtonType.TOM1, 0),
    SCAPE_TOM2(3, ButtonClass.SOUNDSCAPE, ButtonType.TOM2, 0),
    SCAPE_CRASH(4, ButtonClass.SOUNDSCAPE, ButtonType.CRASH, 0),
    SCAPE_CLAP(5, ButtonClass.SOUNDSCAPE, ButtonType.CLAP, 0),
    SCAPE_SNARE(6, ButtonClass.SOUNDSCAPE, ButtonType.SNARE, 0),
    SCAPE_BASS(7, ButtonClass.SOUNDSCAPE, ButtonType.BASS, 0)


}