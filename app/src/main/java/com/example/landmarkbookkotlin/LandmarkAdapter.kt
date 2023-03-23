package com.example.landmarkbookkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.landmarkbookkotlin.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        //recyclerView hissesinde ancaq ad gornecek deye bele .name yaziriq
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name

        //tiklanma
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)

            //secilen landmarki diger terefe yollamaq
            //intent.putExtra("landmark", landmarkList.get(position))
            MySingleton.chosenLandmark = landmarkList.get(position)
            holder.itemView.context.startActivity(intent)
        }
    }
}