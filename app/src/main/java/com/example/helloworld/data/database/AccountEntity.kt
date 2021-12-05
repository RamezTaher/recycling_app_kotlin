package com.example.helloworld.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.helloworld.models.Reward

@Entity(tableName = "account_table")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String = "John Doe",
    var points: Int = 0,
    var plasticRewards: Int = 0,
    var glassRewards: Int = 0,
    var paperRewards: Int = 0,
    var batteriesRewards: Int = 0,
    var metalRewards: Int = 0,
    var clothesRewards: Int = 0,
    var foodRewards: Int = 0
)