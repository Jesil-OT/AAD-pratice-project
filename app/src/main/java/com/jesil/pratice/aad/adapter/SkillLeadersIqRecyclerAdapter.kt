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
import com.jesil.pratice.aad.data.SkillIqData
import kotlinx.android.synthetic.main.item_skill_iq.view.*

class SkillLeadersIqRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var skillIqItem : List<SkillIqData> = ArrayList<SkillIqData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SkillLeadersIqRecyclerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_skill_iq, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        when(holder){
            is SkillLeadersIqRecyclerViewHolder ->{
                holder.bind(skillIqItem[position])
            }
        }
    }

    override fun getItemCount(): Int = skillIqItem.size

    fun setSkillIqData(skillIqList : List<SkillIqData>){
        skillIqItem = skillIqList
    }

    class SkillLeadersIqRecyclerViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){

        val skillIq_badge : ImageView = itemView.imageViewSkillIq
        val skillIq_name : TextView = itemView.textViewSkillIqName
        val skillIq_score : TextView = itemView.textViewSkillIqScore
        val skillIq_country : TextView = itemView.textViewSkillIqCountry

        fun bind(skillData : SkillIqData){
            skillIq_name.text = skillData.skillIqName
            skillIq_score.text = "${skillData.skillIqScore} Skill IQ Score,"
            skillIq_country.text = skillData.skillIqCountry

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_error)

            Glide.with(itemView.context)
                .setDefaultRequestOptions(requestOptions)
                .load(skillData.SkillIqBadgeUrl)
                .into(skillIq_badge)
        }
    }
}