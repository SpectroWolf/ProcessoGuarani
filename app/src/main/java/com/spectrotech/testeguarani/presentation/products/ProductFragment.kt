package com.spectrotech.testeguarani.presentation.products

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.spectrotech.testeguarani.R
import com.spectrotech.testeguarani.adapter.ClientListAdapter
import com.spectrotech.testeguarani.adapter.ProductListAdapter
import com.spectrotech.testeguarani.databinding.FragmentClientBinding
import com.spectrotech.testeguarani.databinding.FragmentProductBinding
import com.spectrotech.testeguarani.data.model.Client
import com.spectrotech.testeguarani.data.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private lateinit var productListAdapter: ProductListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setFakeList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductBinding.inflate(inflater, container, false)

        return binding.root

    }

    private fun initRecyclerView() {
        binding.recyclerProductFragment.layoutManager = LinearLayoutManager(context)
        binding.recyclerProductFragment.setHasFixedSize(true)
        productListAdapter = ProductListAdapter(::getProductId)

        binding.recyclerProductFragment.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )
        binding.recyclerProductFragment.adapter = productListAdapter
    }

    private fun getProductId(id: Long) {
        val builder = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Listagem de Preços")
            .setMessage("Aqui vai ser exibido os preços em ordem crescente do produto $id")
            .setPositiveButton("Fechar", null)

        val alertDialog = builder.create()

        alertDialog.setCancelable(false)
        alertDialog.show()

        val dialogPositiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        dialogPositiveButton.setOnClickListener {
            alertDialog.cancel()
        }
    }

    private fun setFakeList() {

        val productList: MutableList<Product> = mutableListOf(
            Product(1, "N", "Bom", 23, 40f, 20f),
            Product(2, "N", "Médio", 24, 40f, 20f),
            Product(3, "N", "Ok", 3, 40f, 20f),
            Product(4, "N", "Banaca demais", 29, 90f, 50f),
            Product(5, "N", "Joia", 200, 42f, 3f),
            Product(6, "N", "Coxa e sobrecoxa incrivel", 19, 50f, 19f)
        )

        productListAdapter.setList(productList)
        productListAdapter.notifyDataSetChanged()
    }
}