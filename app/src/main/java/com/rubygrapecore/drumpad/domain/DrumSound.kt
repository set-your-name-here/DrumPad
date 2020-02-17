package com.rubygrapecore.drumpad.domain

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.util.SparseArray
import com.rubygrapecore.drumpad.entities.DrumButton

class DrumSound(private var context: Context) {

    private var soundPool: SoundPool? = null
    private var soundPoolMap: SparseArray<Int> = SparseArray()
    private var audioManager: AudioManager =
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    private fun buildSoundPool() {
        audioManager.mode = AudioManager.MODE_NORMAL

        soundPool?.release()
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setFlags(AudioAttributes.FLAG_AUDIBILITY_ENFORCED)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(SOUND_POOL_STREAMS_COUNT)
            .setAudioAttributes(audioAttributes)
            .build()

        soundPool?.autoResume()
        soundPool?.autoPause()
    }

    fun playSound(keyId: Int) {
        val streamVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()

        soundPool?.let { pool ->
            val sound = soundPoolMap.get(keyId)
            pool.play(
                sound,
                streamVolume,
                streamVolume,
                0,
                SOUND_POOL_LOOP,
                SOUND_POOL_RATE
            )
        }

    }

    fun changeSound(drumButtons: List<DrumButton>) {
        buildSoundPool()
        soundPoolMap.clear()
        soundPool?.let { pool ->
            drumButtons.forEach { button ->
                val poolId = pool.load(context, button.res, SOUND_POOL_PRIORITY)
                soundPoolMap.put(button.id, poolId)
            }
        }

    }

    companion object {
        private const val SOUND_POOL_STREAMS_COUNT = 8
        private const val SOUND_POOL_PRIORITY = 1
        private const val SOUND_POOL_LOOP = 0
        private const val SOUND_POOL_RATE = 2f
    }
}