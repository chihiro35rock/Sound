package app.mita.chatamin.sound

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ドラムのサウンドファアイルを読み込んで、プレーヤーをつくる
        val drumSound = MediaPlayer.create(this, R.raw.drum_sound)

        // ドラムがタッチされたときに呼ばれる
        drumImage.setOnTouchListener { v, event ->

            // タッチが始まったときに
            if (event.action == MotionEvent.ACTION_DOWN) {

            // ドラムが鳴っている画像に切り替える
            drumImage.setImageResource(R.drawable.drum_playing_image)

            // ドラムの音を巻き戻す
            drumSound.seekTo(0)

            // ドラムの音を再生する
            drumSound.start()

            }
            else if (event.action == MotionEvent.ACTION_UP) {

                // ドラムが鳴っていない画像に切り替える
                drumImage.setImageResource(R.drawable.drum_image)
            }
            true
        }
    }
}