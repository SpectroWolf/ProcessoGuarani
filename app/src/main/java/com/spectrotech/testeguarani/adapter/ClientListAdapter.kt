package com.spectrotech.testeguarani.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spectrotech.testeguarani.databinding.RvClientItemBinding
import com.spectrotech.testeguarani.data.model.Client

class ClientListAdapter(
    private val editClient: (Client) -> Unit,
    private val deleteClient: (Client) -> Unit
) : RecyclerView.Adapter<ClientListAdapter.MyViewHolder>() {

    var clientList = ArrayList<Client>()

    fun setList(data: List<Client>) {
        this.clientList = data as ArrayList<Client>
    }

    class MyViewHolder(private val binding: RvClientItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindList(
            client: Client,
            editClient: (Client) -> Unit,
            deleteClient: (Client) -> Unit
        ) {
            binding.tvClientItemName.text = client.CLI_RAZAOSOCIAL
            binding.tvClientItemCpf.text = client.CLI_CGCCPF
            binding.tvClientItemEmail.text = client.CLI_EMAIL

            binding.iconClientItemEdit.setOnClickListener {
                editClient(client)
            }

            binding.iconClientItemDelete.setOnClickListener {
                deleteClient(client)
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