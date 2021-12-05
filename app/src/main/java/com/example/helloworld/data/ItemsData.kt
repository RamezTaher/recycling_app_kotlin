package com.example.helloworld.data

import com.example.helloworld.R
import com.example.helloworld.models.Item
import com.example.helloworld.models.Reward

object ItemsData {
    val popularList = arrayListOf(
        Item(R.drawable.ic_plastic_bottle, "Plastic", 5.00f),
        Item(R.drawable.ic_glass_bottle, "Glass", 10.00f),
        Item(R.drawable.ic_paper, "Paper", 3.00f),
        Item(R.drawable.ic_battery, "Battery", 20.00f)
    )
    val otherList = arrayListOf(
        Item(R.drawable.ic_metal, "Metal pieces", 1.00f),
        Item(R.drawable.ic_clothes, "Clothes", 2.00f),
        Item(R.drawable.ic_food, "Food waste", 5.00f)
    )
    val rewardList = arrayListOf(
        Reward(R.drawable.ic_plastic_bottle, 0),
        Reward(R.drawable.ic_glass_bottle, 0),
        Reward(R.drawable.ic_paper, 0),
        Reward(R.drawable.ic_battery, 0),
        Reward(R.drawable.ic_metal, 0),
        Reward(R.drawable.ic_clothes, 0),
        Reward(R.drawable.ic_food, 0)
    )

    var points = 0
}