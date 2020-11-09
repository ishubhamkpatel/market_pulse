package com.shubham.marketpulse.features.home.scancriteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shubham.marketpulse.R
import com.shubham.marketpulse.features.home.scanslisting.adapter.ScansListingRecyclerAdapter
import com.shubham.marketpulse.model.CriteriaData
import com.shubham.marketpulse.model.ScansData
import kotlinx.android.synthetic.main.item_criteria_details.view.*

/**
 * Created by shubhampatel on 09 Nov, 2020.
 */
class ScanCriteriaRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_DETAILS = 1
        const val TYPE_JOIN = 2
    }

    private val list = mutableListOf<CriteriaData>()

    fun setData(list: List<CriteriaData>) {
        this.list.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DETAILS -> DetailsViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_criteria_details, parent, false)
            )
            TYPE_JOIN -> JoinViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_criteria_joins, parent, false)
            )
            else -> DummyViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_dummy, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].viewType ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        list[position].let {
            when (it.viewType) {
                TYPE_DETAILS -> {
                    (holder as DetailsViewHolder).bind(it)
                }
                TYPE_JOIN -> {
                    (holder as JoinViewHolder).bind(it)
                }
                else -> {
                    (holder as DummyViewHolder).bind(it)
                }
            }
        }
    }

    private abstract class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        abstract fun bind(item: CriteriaData)
    }

    private class DetailsViewHolder(view: View): ViewHolder(view) {

        override fun bind(item: CriteriaData) {
            itemView.tv_criteria?.text = item.text
        }
    }

    private class JoinViewHolder(view: View): ViewHolder(view) {

        override fun bind(item: CriteriaData) {}
    }

    private class DummyViewHolder(view: View): ViewHolder(view) {

        override fun bind(item: CriteriaData) {}
    }
}