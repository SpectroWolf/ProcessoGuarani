package com.spectrotech.testeguarani.presentation.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.spectrotech.testeguarani.adapter.ClientListAdapter
import com.spectrotech.testeguarani.databinding.FragmentClientBinding
import com.spectrotech.testeguarani.data.model.Client
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ClientFragment : Fragment() {

    private var _binding: FragmentClientBinding? = null
    private val binding get() = _binding!!

    private lateinit var clientListAdapter: ClientListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setFakeList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentClientBinding.inflate(inflater, container, false)

        return binding.root

    }

    private fun initRecyclerView(){
        binding.recyclerClientFragment.layoutManager = LinearLayoutManager(context)
        binding.recyclerClientFragment.setHasFixedSize(true)
        clientListAdapter = ClientListAdapter(::editClient, ::deleteClient)

        binding.recyclerClientFragment.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )
        binding.recyclerClientFragment.adapter = clientListAdapter
    }

    private fun editClient(clientId: Long){}

    private fun deleteClient(clientId: Long){}

    private fun setFakeList(){

        val clientList: MutableList<Client> = mutableListOf(
            Client(
                id = 1,
                razaoSocial = "teste1",
                cnpjCPF = "123456789",
                emailPrincipal = "teste1",
                emailSecundario = "teste1",
                endereco = "teste1",
                enderecoBairro = "teste1",
                enderecoCodMunicipio = 1,
                enderecoComplemento = "teste1",
                enderecoNumero = 1,
                inscrestadual = "teste1"
            ),
            Client(
                id = 2,
                razaoSocial = "teste2",
                cnpjCPF = "123456789",
                emailPrincipal = "teste2",
                emailSecundario = "teste2",
                endereco = "teste2",
                enderecoBairro = "teste2",
                enderecoCodMunicipio = 1,
                enderecoComplemento = "teste2",
                enderecoNumero = 1,
                inscrestadual = "teste2"
            ),
            Client(
                id = 3,
                razaoSocial = "teste3",
                cnpjCPF = "123456789",
                emailPrincipal = "teste3",
                emailSecundario = "teste3",
                endereco = "teste3",
                enderecoBairro = "teste3",
                enderecoCodMunicipio = 1,
                enderecoComplemento = "teste3",
                enderecoNumero = 1,
                inscrestadual = "teste3"
            )
        )

        clientListAdapter.setList(clientList)
        clientListAdapter.notifyDataSetChanged()

    }
}