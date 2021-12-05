
package com.example.helloworld.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.helloworld.adapters.RewardsAdapter
import com.example.helloworld.data.ItemsData
import com.example.helloworld.databinding.FragmentRewardsBinding
import kotlin.properties.Delegates

class RewardsFragment : Fragment() {
    private var _binding: FragmentRewardsBinding? = null
    private val binding get() = _binding!!

    private val rewardsAdapter by lazy { RewardsAdapter() }
    
    private val coffeePrice = 120

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRewardsBinding.inflate(inflater, container, false)

        binding.itemsRecyclerView.adapter = rewardsAdapter
        rewardsAdapter.setData(ItemsData.rewardList)

        binding.pointsTextView.text = ItemsData.points.toString()

        binding.numberPicker.minValue = 0
        binding.numberPicker.maxValue = ItemsData.points / coffeePrice

        binding.numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            binding.pointsTextView2.text = "$newVal x $coffeePrice"
        }

        binding.getBtn.setOnClickListener {
            if (binding.numberPicker.maxValue == 0) {
                Toast.makeText(context, "You don't have enough points", Toast.LENGTH_SHORT).show()
            } else if (binding.numberPicker.value == 0) {
                Toast.makeText(context, "Please select a valid number", Toast.LENGTH_SHORT).show()
            } else {
                ItemsData.points -= binding.numberPicker.value * coffeePrice
                binding.pointsTextView.text = ItemsData.points.toString()
                Toast.makeText(context, "You receive ${binding.numberPicker.value} coffee", Toast.LENGTH_SHORT).show()

                binding.numberPicker.minValue = 0
                binding.numberPicker.maxValue = ItemsData.points / coffeePrice

                binding.pointsTextView2.text = "$coffeePrice"

            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}