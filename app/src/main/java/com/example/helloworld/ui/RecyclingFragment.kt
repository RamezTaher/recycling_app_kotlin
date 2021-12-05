package com.example.helloworld.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helloworld.adapters.CategoriesAdapter
import com.example.helloworld.adapters.OtherAdapter
import com.example.helloworld.adapters.PopularAdapter
import com.example.helloworld.data.CategoryData
import com.example.helloworld.data.ItemsData
import com.example.helloworld.databinding.FragmentRecyclingBinding

class RecyclingFragment : Fragment() {
    private var _binding: FragmentRecyclingBinding? = null
    private val binding get() = _binding!!

    private val categoriesAdapter by lazy { CategoriesAdapter() }
    private val popularAdapter by lazy { PopularAdapter(context) }
    private val otherAdapter by lazy { OtherAdapter(context) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclingBinding.inflate(inflater, container, false)

        binding.categoriesRecyclerView.adapter = categoriesAdapter
        categoriesAdapter.setData(CategoryData.categoryList)

        binding.popularRecyclerView.adapter = popularAdapter
        popularAdapter.setData(ItemsData.popularList)

        binding.otherRecyclerView.adapter = otherAdapter
        otherAdapter.setData(ItemsData.otherList)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}