package com.udindev.bantulfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.iniudin.githubuserapp.adapter.FoodAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allFood: ArrayList<Food> = arrayListOf()

        addData(allFood)

        adapter = FoodAdapter(allFood)
        foodRecView.adapter = adapter
        initRecView()

    }

    private fun addData(allFood: ArrayList<Food>) {
        for (item in 0..DataFood.foodName.size - 1) {
            val image = DataFood.foodImage[item]
            val name = DataFood.foodName[item]
            val description = DataFood.foodDescription[item]
            val food = Food(image, name, description)
            allFood.add(food)
        }
    }

    private fun initRecView() {
        foodRecView.layoutManager = LinearLayoutManager(this)
        foodRecView.setHasFixedSize(true)
        adapter.notifyDataSetChanged()
    }
}