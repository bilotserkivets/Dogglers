package com.example.mydogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydogglers.R
import com.example.mydogglers.const.Layout
import com.example.mydogglers.data.DataSource

class DogCardAdapter(private val context: Context, val layout: Int) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>(){

    class DogCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.dog_image)
        val nameView: TextView = view.findViewById(R.id.dog_name)
        val ageView: TextView = view.findViewById(R.id.dog_age)
        val hobbiesView: TextView = view.findViewById(R.id.dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val layout = when (layout) {
            Layout.GRID -> LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }
        return DogCardViewHolder(layout)
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {

        val resources = context.resources

        val item = DataSource.dogs[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.nameView.text = item.name
        holder.ageView.text = resources.getString(R.string.age, item.age)
        holder.hobbiesView.text = resources.getString(R.string.hobbies, item.hobbies)
    }

    override fun getItemCount(): Int {
        return DataSource.dogs.size
    }
}