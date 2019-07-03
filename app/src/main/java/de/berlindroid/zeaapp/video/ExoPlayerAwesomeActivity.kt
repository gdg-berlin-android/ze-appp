package de.berlindroid.zeaapp.video

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.SingleSampleMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.util.MimeTypes
import kotlinx.android.synthetic.main.activity_exo_player.*

//TODO Should play video that will be provided to EditText
class ExoPlayerAwesomeActivity: Activity() {

//    private var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

//    private fun startVide() {
//        awesome_player
//
//
//        player = ExoPlayerFactory.newSimpleInstance(this);
//        // Attach player to the view.
//        awesome_player.setPlayer(player);
//        // Prepare the player with the dash media source.
//        player.prepare(createMediaSource())
//    }

//    private fun createMediaSource() {
//        val trackSelector = DefaultTrackSelector()
//        val loadControl = DefaultLoadControl()
//        val  videoSource : MediaSource = ProgressiveMediaSource.Factory(ExoPlayerFactory.newInstance(this, trackSelector, loadControl)).createMediaSource(et_video_url.text);
//
//        val mergedSource: MergingMediaSource = MergingMediaSource(videoSource);
//    }
}
