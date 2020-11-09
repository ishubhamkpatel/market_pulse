package com.shubham.marketpulse.features.home.scanslisting.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shubham.marketpulse.R
import com.shubham.marketpulse.features.home.scanslisting.communicator.ScansListingRecyclerAdapterCallback
import com.shubham.marketpulse.model.ScansData
import kotlinx.android.synthetic.main.item_scan.view.*

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class ScansListingRecyclerAdapter(
    private val callback: ScansListingRecyclerAdapterCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<ScansData>()

    fun setData(list: List<ScansData>) {
        this.list.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_scan, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(list[position])
    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ScansData) {
            itemView.tv_scan_title?.text = item.scanTitle
            itemView.tv_scan_subtitle?.apply {
                text = item.scanSubtitle
                setTextColor(Color.parseColor(item.colorCode))
            }
            item.scanId?.let { id ->
                itemView.setOnClickListener {
                    callback.onScanClicked(id)
                }
            }
        }
    }
}