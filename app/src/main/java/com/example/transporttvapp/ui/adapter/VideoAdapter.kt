package com.example.transporttvapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.transporttvapp.databinding.HomeScreenVideoViewBinding

import com.example.transporttvapp.model.GetVideo
import com.example.transporttvapp.ui.PlayVideoActivity
import androidx.core.content.ContextCompat.startActivity





class VideoAdapter(val context: Context, val list:List<GetVideo.VideoData>) :
    RecyclerView.Adapter<VideoAdapter.ViewHolderClass>() {

    class ViewHolderClass(val binding: HomeScreenVideoViewBinding) : RecyclerView.ViewHolder(binding.root) {
        var list= mutableListOf<String>()

        fun videodetail(data: GetVideo.VideoData,context: Context){
            binding.videoDetails=data
            binding.dialogVideoView.setOnClickListener {
              /* val intent=Intent(context,PlayVideoActivity::class.java)
                intent.putExtra("videoData", data.vimeoLink)
                context.startActivity(intent)
*/
             /*   val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.vimeoLink))
                context.startActivity(intent)*/

                  var intent=Intent(context,PlayVideoActivity::class.java)
                  intent.putExtra("videoData",data)
                  context.startActivity(intent)


}
}


}

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
val binding=HomeScreenVideoViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
return ViewHolderClass(binding)
}

override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
holder.videodetail(list.get(position),context)

}

override fun getItemCount(): Int {
return list.size
}


}



