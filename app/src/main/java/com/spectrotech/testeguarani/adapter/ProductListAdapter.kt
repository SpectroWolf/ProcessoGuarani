package com.spectrotech.testeguarani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spectrotech.testeguarani.databinding.RvClientItemBinding
import com.spectrotech.testeguarani.databinding.RvProductItemBinding
import com.spectrotech.testeguarani.data.model.Client
import com.spectrotech.testeguarani.data.model.Product

class ProductListAdapter(private val getProductId: (Long) -> Unit) :
    RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    var productList = ArrayList<Product>()

    fun setList(data: List<Product>) {
        this.productList = data as ArrayList<Product>
    }

    class MyViewHolder(private val binding: RvProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindList(
            product: Product,
            getProductId: (Long) -> Unit
        ) {
            binding.tvProductItemCod.text = "Código: ${product.id}"
            binding.tvProductItemDescription.text = product.descricao
            binding.tvProductItemStock.text = "Estoque: ${product.estoque}"
            binding.tvProductItemMaxPrice.text = "Preço Máximo: R$${product.maxPrice}"
            binding.tvProductItemMinPrice.text = "Preço Mínimo: R$${product.minPrice}"

            binding.rvProductItem.setOnClickListener {
                getProductId(product.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MyViewHolder {
        val binding =
            RvProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindList(productList[position], getProductId)

    }

    override fun getItemCount() = productList.size
}