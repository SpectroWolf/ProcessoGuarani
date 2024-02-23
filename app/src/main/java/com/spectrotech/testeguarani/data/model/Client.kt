package com.spectrotech.testeguarani.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GUA_CLIENTES")
data class Client(

    @PrimaryKey(autoGenerate = false)
    val CLI_CODIGOCLIENTE: Long,
    val CLI_RAZAOSOCIAL: String,
    val CLI_CGCCPF: String,
    val CLI_EMAIL: String,
    val CLI_EMAILSECUNDARIO: String,
    val CLI_INSCRESTADUAL: String,
    val CLI_ENDERECO: String,
    val CLI_NUMERO: Long,
    val CLI_COMPLEMENTO: String,
    val CLI_BAIRRO: String,
    val CLI_CODIGOMUNICIPIO: Long,
    val CLI_NOMEFANTASIA: String? = ""
)
