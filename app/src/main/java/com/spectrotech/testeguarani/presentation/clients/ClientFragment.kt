package com.spectrotech.testeguarani.presentation.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.spectrotech.testeguarani.adapter.ClientListAdapter
import com.spectrotech.testeguarani.databinding.FragmentClientBinding
import com.spectrotech.testeguarani.data.model.Client
import com.spectrotech.testeguarani.presentation.MainViewModel
import com.spectrotech.testeguarani.presentation.UIState
import com.spectrotech.testeguarani.util.gone
import com.spectrotech.testeguarani.util.visible
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ClientFragment : Fragment() {

    private var _binding: FragmentClientBinding? = null
    private val binding get() = _binding!!

    private lateinit var clientListAdapter: ClientListAdapter

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getAllClients()
        initObservables()
    }

    private fun getAllClients() {
        viewModel.getAllClients()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentClientBinding.inflate(inflater, container, false)

        return binding.root

    }

    private fun initRecyclerView() {
        binding.recyclerClientFragment.layoutManager = LinearLayoutManager(context)
        binding.recyclerClientFragment.setHasFixedSize(true)
        clientListAdapter = ClientListAdapter(::editClient, ::deleteClient)

        binding.recyclerClientFragment.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )
        binding.recyclerClientFragment.adapter = clientListAdapter
    }

    private fun editClient(client: Client) {}

    private fun deleteClient(client: Client) {
        viewModel.deleteClient(client)
    }

    private fun initObservables() {
        viewModel.clientList.observe(viewLifecycleOwner) {
            clientListAdapter.setList(it)
            clientListAdapter.notifyDataSetChanged()
        }

        viewModel.uiStateClientList.observe(requireActivity()) { uiStateClientList ->
            uiStateManager(uiStateClientList)
        }

    }

    private fun uiStateManager(uiState: UIState) {
        when (uiState) {
            is UIState.Success -> dismissLoading()
            is UIState.Loading -> setLoading()
            is UIState.UpdatedDB -> updatedDB()
            else -> {}
        }
    }

    private fun updatedDB(){
        viewModel.getAllClients()
    }
    private fun setLoading() {
        binding.loading.visible()
    }

    private fun dismissLoading() {
        binding.loading.gone()
    }
}