package com.iniudin.githubuserapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udindev.bantulfood.Food
import com.udindev.bantulfood.R
import kotlinx.android.synthetic.main.item_food.view.*


class FoodAdapter (private val list: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder = FoodViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(list[position].image)
            .into(holder.itemView.image_food)
        holder.itemView.txtFoodName.text = list[position].name
        holder.itemView.txtFoofDescription.text = list[position].description
    }
}