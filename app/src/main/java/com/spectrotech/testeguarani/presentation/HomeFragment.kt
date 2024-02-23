package com.spectrotech.testeguarani.presentation

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.children
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.spectrotech.testeguarani.R
import com.spectrotech.testeguarani.adapter.TabLayoutAdapter
import com.spectrotech.testeguarani.databinding.FragmentHomeBinding
import com.spectrotech.testeguarani.presentation.clients.ClientFragment
import com.spectrotech.testeguarani.presentation.products.ProductFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configTabLayout()
    }

    private fun configTabLayout() {
        val adapter = TabLayoutAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        binding.tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {}

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}

            }
        )
        adapter.addFragment(
            ClientFragment(),
            resources.getString(R.string.client_fragment_title_text)
        )
        adapter.addFragment(
            ProductFragment(),
            resources.getString(R.string.product_fragment_title_text)
        )
        binding.viewPager.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position ->
            tab.text = adapter.getTitle(
                position
            )
        }.attach()
    }

}