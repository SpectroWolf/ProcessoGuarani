package com.spectrotech.testeguarani.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "GUA_CLIENTES")
data class Client(

    @PrimaryKey(autoGenerate = true)
    val CLI_CODIGOCLIENTE: Int,
    val CLI_RAZAOSOCIAL: String? = "",
    val CLI_CGCCPF: String? = "",
    val CLI_INSCRESTADUAL: String? = "",
    val CLI_ENDERECO: String? = "",
    val CLI_NUMERO: String? = "",
    val CLI_COMPLEMENTO: String? = "",
    val CLI_BAIRRO: String? = "",
    val CLI_CODIGOMUNICIPIO: String? = "",
    val CLI_NOMEFANTASIA: String? = "",
    val CLI_EMAIL: String? = "",
    val CLI_EMAILSECUNDARIO: String? = "",
)
