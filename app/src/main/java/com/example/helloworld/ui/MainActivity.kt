package com.example.helloworld.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.room.Room
import com.example.helloworld.R
import com.example.helloworld.data.database.AccountDatabase
import com.example.helloworld.data.database.AccountEntity
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var activeFragment: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclingTextView.setOnClickListener {
            if (activeFragment != 0) {
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.mainFragment) as NavHostFragment
                val navController = navHostFragment.navController
                val action =
                    RewardsFragmentDirections.actionRewardsFragmentToRecyclingFragment()
                navController.navigate(action)

                binding.recyclingImageView.visibility = View.VISIBLE
                binding.rewardsImageView.visibility = View.INVISIBLE

                binding.recyclingTextView.setTextColor(Color.parseColor("#000000"))
                binding.rewardsTextView.setTextColor(Color.parseColor("#909196"))

                activeFragment = 0
            }
        }

        binding.rewardsTextView.setOnClickListener {
            if (activeFragment != 1) {
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.mainFragment) as NavHostFragment
                val navController = navHostFragment.navController
                val action =
                    RecyclingFragmentDirections.actionRecyclingFragmentToRewardsFragment()
                navController.navigate(action)

                binding.recyclingImageView.visibility = View.INVISIBLE
                binding.rewardsImageView.visibility = View.VISIBLE

                binding.recyclingTextView.setTextColor(Color.parseColor("#909196"))
                binding.rewardsTextView.setTextColor(Color.parseColor("#000000"))

                activeFragment = 1
            }
        }

//        val db = Room.databaseBuilder(
//            applicationContext,
//            AccountDatabase::class.java,
//            "account-database"
//        ).allowMainThreadQueries().build()
//        val userDao = db.accountDao()
//        var account = AccountEntity(0, "Mohamed", 0, 0, 0, 0, 0,0,0,0)
//        userDao.insertAccount(account)


    }

}