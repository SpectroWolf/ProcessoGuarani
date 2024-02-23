package com.spectrotech.testeguarani.presentation.clients

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.spectrotech.testeguarani.R
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

    private fun editClient(client: Client) {

        val customDialogLayout: View =
            LayoutInflater.from(requireContext()).inflate(R.layout.add_client_dialog, null)

        val edtRazaoSocial: TextView = customDialogLayout.findViewById(R.id.edt_razao_social)
        val edtCPFeCNPJ: TextView = customDialogLayout.findViewById(R.id.edt_cpf)
        val edtEndereco: TextView = customDialogLayout.findViewById(R.id.edt_endereco)
        val edtNumEndereco: TextView = customDialogLayout.findViewById(R.id.edt_num_endereco)
        val edtComplemento: TextView = customDialogLayout.findViewById(R.id.edt_complemento)
        val edtBairro: TextView = customDialogLayout.findViewById(R.id.edt_bairro)
        val edtCodMunicipio: TextView = customDialogLayout.findViewById(R.id.edt_cod_municipio)
        val edtNomeFantasia: TextView = customDialogLayout.findViewById(R.id.edt_nome_fantasia)
        val edtEmail: TextView = customDialogLayout.findViewById(R.id.edt_email)
        val edtEmail2: TextView = customDialogLayout.findViewById(R.id.edt_email_secundario)

        val addClientDialogBuilder = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Editando Cliente")
            .setView(customDialogLayout)

        edtRazaoSocial.text = client.CLI_RAZAOSOCIAL
        edtCPFeCNPJ.text = client.CLI_CGCCPF
        edtEndereco.text = client.CLI_ENDERECO
        edtNumEndereco.text = client.CLI_NUMERO
        edtComplemento.text = client.CLI_COMPLEMENTO
        edtBairro.text = client.CLI_BAIRRO
        edtCodMunicipio.text = client.CLI_CODIGOMUNICIPIO
        edtNomeFantasia.text = client.CLI_NOMEFANTASIA
        edtEmail.text = client.CLI_EMAIL
        edtEmail2.text = client.CLI_EMAILSECUNDARIO

        addClientDialogBuilder.setNegativeButton("Fechar", null)
        addClientDialogBuilder.setPositiveButton("Editar") { _, _ ->

            val editedClient = Client(
                client.CLI_CODIGOCLIENTE,
                edtRazaoSocial.text.toString(),
                edtCPFeCNPJ.text.toString(),
                edtEndereco.text.toString(),
                edtNumEndereco.text.toString(),
                edtComplemento.text.toString(),
                edtBairro.text.toString(),
                edtCodMunicipio.text.toString(),
                edtNomeFantasia.text.toString(),
                edtEmail.text.toString(),
                edtEmail2.text.toString()
            )
            viewModel.upsertClient(editedClient)
        }

        val addClientDialog = addClientDialogBuilder.create()

        addClientDialog.setCancelable(false)
        addClientDialog.show()

        val dialogNegativeButton = addClientDialog.getButton(AlertDialog.BUTTON_NEGATIVE)
        dialogNegativeButton.setOnClickListener {
            addClientDialog.dismiss()
        }

    }

    private fun addClient() {

        val customDialogLayout: View =
            LayoutInflater.from(requireContext()).inflate(R.layout.add_client_dialog, null)

        val edtRazaoSocial: TextView = customDialogLayout.findViewById(R.id.edt_razao_social)
        val edtCPFeCNPJ: TextView = customDialogLayout.findViewById(R.id.edt_cpf)
        val edtEndereco: TextView = customDialogLayout.findViewById(R.id.edt_endereco)
        val edtNumEndereco: TextView = customDialogLayout.findViewById(R.id.edt_num_endereco)
        val edtComplemento: TextView = customDialogLayout.findViewById(R.id.edt_complemento)
        val edtBairro: TextView = customDialogLayout.findViewById(R.id.edt_bairro)
        val edtCodMunicipio: TextView = customDialogLayout.findViewById(R.id.edt_cod_municipio)
        val edtNomeFantasia: TextView = customDialogLayout.findViewById(R.id.edt_nome_fantasia)
        val edtEmail: TextView = customDialogLayout.findViewById(R.id.edt_email)
        val edtEmail2: TextView = customDialogLayout.findViewById(R.id.edt_email_secundario)

        val addClientDialogBuilder = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Adicionando um Cliente")
            .setView(customDialogLayout)

        addClientDialogBuilder.setNegativeButton("Fechar", null)
        addClientDialogBuilder.setPositiveButton("Adicionar") { _, _ ->

            if (edtRazaoSocial.text.isNullOrEmpty() || edtCPFeCNPJ.text.isNullOrEmpty()
                || edtEndereco.text.isNullOrEmpty() || edtNumEndereco.text.isNullOrEmpty()
                || edtBairro.text.isNullOrEmpty() || edtCodMunicipio.text.isNullOrEmpty()
                || edtEmail.text.isNullOrEmpty()
            ) {
                Toast.makeText(
                    requireContext(),
                    "Preencha todos os campos para continuar.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                val newClient = Client(
                    0,
                    edtRazaoSocial.text.toString(),
                    edtCPFeCNPJ.text.toString(),
                    edtEndereco.text.toString(),
                    edtNumEndereco.text.toString(),
                    edtComplemento.text.toString(),
                    edtBairro.text.toString(),
                    edtCodMunicipio.text.toString(),
                    edtNomeFantasia.text.toString(),
                    edtEmail.text.toString(),
                    edtEmail2.text.toString()
                )
                viewModel.upsertClient(newClient)
            }
        }

        val addClientDialog = addClientDialogBuilder.create()

        addClientDialog.setCancelable(false)
        addClientDialog.show()

        val dialogNegativeButton = addClientDialog.getButton(AlertDialog.BUTTON_NEGATIVE)
        dialogNegativeButton.setOnClickListener {
            addClientDialog.dismiss()
        }
    }

    private fun deleteClient(client: Client) {
        viewModel.deleteClient(client)
    }

    private fun initObservables() {

        binding.FABAddClient.setOnClickListener {
            addClient()
        }

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

    private fun updatedDB() {

        val builder = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Atualização")
            .setMessage("O banco de dados foi atualizado!")
            .setPositiveButton("Fechar", null)

        val alertDialog = builder.create()

        alertDialog.setCancelable(false)
        alertDialog.show()

        val dialogPositiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        dialogPositiveButton.setOnClickListener {
            alertDialog.cancel()
            viewModel.getAllClients()
        }
    }

    private fun setLoading() {
        binding.loading.visible()
    }

    private fun dismissLoading() {
        binding.loading.gone()
    }
}