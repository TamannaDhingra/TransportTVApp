package com.example.transporttvapp.ui

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.transporttvapp.R
import com.example.transporttvapp.builderobjects.RetroBuilder
import com.example.transporttvapp.databinding.ActivityPlayVideoBinding

import com.example.transporttvapp.model.GetVideo
import com.example.transporttvapp.repository.Repostries
import com.example.transporttvapp.retroApi.RetroApi
import com.example.transporttvapp.ui.fragments.Comments_Bottom_Sheet
import com.example.transporttvapp.viewmodel.GetCurrentLocation
import com.example.transporttvapp.viewmodel.GetCurrentLocationFactory
import com.example.transporttvapp.viewmodel.VideoConvertorViewModel
import com.example.transporttvapp.viewmodel.VideoConvertorViewModelFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

class PlayVideoActivity : AppCompatActivity() {

    lateinit var getVimeolink: GetVideo.VideoData

    // creating a variable for exoplayerview.
    //  lateinit var exoPlayerView: SimpleExoPlayerView
    var mediaController: MediaController? = null
    val vimeo_id = 490089483

    var videoURL = "https://player.vimeo.com/video/490089483%22" + "/config"

    var demovideoURL =
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4"

    // creating a variable for exoplayer
    lateinit var exoPlayer: SimpleExoPlayer
    lateinit var context: Context
    lateinit var binding: ActivityPlayVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_video)

        mediaController = MediaController(this)
        val intent = getIntent()
        getVimeolink = intent.getSerializableExtra("videoData") as GetVideo.VideoData
        val getvideo = getVimeolink.vimeoLink


        /*  if (getvideo?.isNotEmpty() == true) {
            val uri = Uri.parse(getvideo)
            binding.videov.setVideoURI(uri)

            mediaController?.setAnchorView(binding.videov)
            binding.videov.setMediaController(mediaController)

            mediaController?.requestFocus()
            mediaController?.show(0)
            binding.videov.start()
        }*/

        Toast.makeText(this, getVimeolink.vimeoLink + "/config", Toast.LENGTH_LONG).show()

        binding.exopl.setOnClickListener {
            binding.commentstv.visibility = View.VISIBLE


        }
        context = this
        binding.commentstv.setOnClickListener {
            val dialog = Comments_Bottom_Sheet(context)
            dialog.show()

        }


        /* val retro = RetroBuilder.baseUrlForVideo().create(RetroApi::class.java)
        val repo = Repostries(retro, this)
        val viewmodel = ViewModelProvider(
            this,
            VideoConvertorViewModelFactory()
        ).get(VideoConvertorViewModel::class.java)
     viewmodel.getVideoLink(vimeo_id.toString())

        viewmodel.getVideoLink(vimeo_id.toString())
        viewmodel.datavideo.observe(this, Observer {


        })*/


        /* mediaController.setAnchorView(binding.videov)
               binding.videov.visibility=(View.VISIBLE)
               binding.videov.setVideoURI(Uri.parse(getVimeolink.vimeoLink))
               binding.videov.setMediaController(null)
               binding.videov.requestFocus()
               binding.videov.start()
              */

        /*  val uri=Uri.parse("https://player.vimeo.com/video/490089483%22")
        binding.videov.setVideoURI(uri)
        binding.videov.start()*/



       // exoplayer(getVimeolink.vimeoLink.toString())
        exoplayer(demovideoURL)

    }





 fun exoplayer(url:String){
      // bandwisthmeter is used for
      // getting default bandwidth
      val bandwidthMeter: BandwidthMeter = DefaultBandwidthMeter()


      // track selector is used to navigate between
      // video using a default seekbar.
      val trackSelector: TrackSelector =
          DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))

      // we are adding our track selector to exoplayer.

         // exoPlayer = ExoPlayerFactory.newSimpleInstance(requireActivity(), trackSelector);
          exoPlayer = ExoPlayerFactory.newSimpleInstance(applicationContext, trackSelector);
      // we are adding our track selector to exoplayer.


      // we are parsing a video url
      // and parsing its video uri.

     var videouri: Uri = Uri.parse(url)


      // we are creating a variable for datasource factory
      // and setting its user agent as 'exoplayer_view'
      var dataSourceFactory: DefaultHttpDataSourceFactory =
          DefaultHttpDataSourceFactory("exoplayer_video");


      // we are creating a variable for extractor factory
      // and setting it to default extractor factory.
      var extractorsFactory: ExtractorsFactory = DefaultExtractorsFactory();


      // we are creating a media source with above variables
      // and passing our event handler as null,
      var mediaSource: MediaSource =
          ExtractorMediaSource(videouri, dataSourceFactory, extractorsFactory, null, null);

      // inside our exoplayer view
      // we are setting our player
      binding.exopl.setPlayer(exoPlayer);


      // we are preparing our exoplayer
      // with media source.
      exoPlayer.prepare(mediaSource);


      // we are setting our exoplayer
      // when it is ready.
      exoPlayer.setPlayWhenReady(true);

  }
}
