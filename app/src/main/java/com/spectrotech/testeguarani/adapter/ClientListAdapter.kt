package com.spectrotech.testeguarani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spectrotech.testeguarani.databinding.RvClientItemBinding
import com.spectrotech.testeguarani.data.model.Client

class ClientListAdapter(
    private val editClient: (Long) -> Unit,
    private val deleteClient: (Long) -> Unit
) : RecyclerView.Adapter<ClientListAdapter.MyViewHolder>() {

    var clientList = ArrayList<Client>()

    fun setList(data: List<Client>) {
        this.clientList = data as ArrayList<Client>
    }

    class MyViewHolder(private val binding: RvClientItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindList(
            client: Client,
            editClient: (Long) -> Unit,
            deleteClient: (Long) -> Unit
        ) {
            binding.tvClientItemName.text = client.razaoSocial
            binding.tvClientItemCpf.text = client.cnpjCPF
            binding.tvClientItemEmail.text = client.emailPrincipal

            binding.iconClientItemEdit.setOnClickListener {
                editClient(client.id)
            }

            binding.iconClientItemDelete.setOnClickListener {
                deleteClient(client.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MyViewHolder {
        val binding =
            RvClientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindList(clientList[position], editClient, deleteClient)

    }

    override fun getItemCount() = clientList.size
}