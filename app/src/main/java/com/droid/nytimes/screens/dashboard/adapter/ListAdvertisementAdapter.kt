package com.droid.nytimes.screens.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.droid.nytimes.R
import com.droid.nytimes.common.models.dto.AdvertisementModel
import com.droid.nytimes.common.util.ImageUtil
import com.droid.nytimes.screens.dashboard.listener.OnAdvertisementSelected
import kotlinx.android.synthetic.main.cell_list_advertisment.view.*


class ListAdvertisementAdapter(
    private val context: Context,
    private val list: ArrayList<AdvertisementModel>,
    private val onAdvertisementSelected: OnAdvertisementSelected
) : RecyclerView.Adapter<ListAdvertisementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_list_advertisment, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list.get(position)

        model.title?.let {
            holder.tvTitle.text = it
        }
        model.writer?.let {
            holder.tvWriter.text = it
        }
        model.type?.let {
            holder.tvType.text = it
        }
        model.published_date?.let {
            holder.tvDate.text = it
        }
        model.media?.let {
            if (it.size > 0) {
                val image = it[0]
                ImageUtil.loadImage(holder.ivThumbnail.context, holder.ivThumbnail, image.imageUrls[0].url)
            }
        }

        holder.itemView.setOnClickListener(View.OnClickListener {
            onAdvertisementSelected.onClicked(model)
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.tvName
        val tvWriter: TextView = view.tvWriter
        val tvType: TextView = view.tvType
        val tvDate: TextView = view.tvDate
        val ivThumbnail: ImageView = view.ivThumbnail


    }
}