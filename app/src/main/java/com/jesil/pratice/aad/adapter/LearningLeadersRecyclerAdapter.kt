package com.jesil.pratice.aad.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jesil.pratice.aad.R
import com.jesil.pratice.aad.data.LearningLeadersData
import kotlinx.android.synthetic.main.item_learning_leaders.view.*

class LearningLeadersRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var learningLeadersItems: List<LearningLeadersData> = ArrayList<LearningLeadersData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LearningLeadersViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_learning_leaders, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LearningLeadersViewHolder -> {
                holder.bind(learningLeadersItems[position])
            }
        }
    }

    override fun getItemCount(): Int = learningLeadersItems.size

    fun setLearningLeadersData(learningLeadersList: List<LearningLeadersData>) {
        learningLeadersItems = learningLeadersList
    }

    class LearningLeadersViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val learning_Leaders_badge: ImageView = itemView.imageViewLearningLeaders
        val learning_Leaders_name: TextView = itemView.textViewLearningLeadersName
        val learning_Leaders_hours: TextView = itemView.textViewLearningLeadersHours
        val learning_Leaders_country: TextView = itemView.textViewLearningLeadersCountry

        fun bind(learningLeadersData: LearningLeadersData) {

            learning_Leaders_name.text = learningLeadersData.learningLeadersName
            learning_Leaders_hours.text =
                "Learning Hours ${learningLeadersData.learningLeadersHours}"
            learning_Leaders_country.text = learningLeadersData.learningLeadersCountry

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_error)

            Glide.with(itemView.context)
                .setDefaultRequestOptions(requestOptions)
                .load(learningLeadersData.learningLeadersBadgeUrl)
                .into(learning_Leaders_badge)

        }
    }
}