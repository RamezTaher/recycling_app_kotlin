package com.example.helloworld.data

import com.example.helloworld.R
import com.example.helloworld.models.Category

object CategoryData {
    val categoryList = arrayListOf(
        Category(0, "All"),
        Category(R.drawable.ic_plastic_bottle, "Plastic"),
        Category(R.drawable.ic_glass_bottle, "Glass"),
        Category(R.drawable.ic_paper, "Papers"),
        Category(R.drawable.ic_battery, "Batteries"),
    )
}