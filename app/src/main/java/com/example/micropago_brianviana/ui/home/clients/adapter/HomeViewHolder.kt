package com.example.micropago_brianviana.ui.home.clients.adapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.micropago_brianviana.databinding.ItemsClientsBinding
import com.example.micropago_brianviana.domain.model.HomeDataModel

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemsClientsBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(homeDataModel: HomeDataModel) {
        binding.apply {
            setTextOrDefault(tvNoAfiliacion, homeDataModel.noAfiliacion)
            setTextOrDefault(tvCliente, homeDataModel.descCliente)
            setTextOrDefault(tvServicio, homeDataModel.descServicio)
            setTextOrDefault(tvDescripcionCorta, homeDataModel.descCorta)
            setTextOrDefault(tvFechaAlta, homeDataModel.fecalta)
            setTextOrDefault(tvFechaCierre, homeDataModel.fecCierre)
            setTextOrDefault(tvDireccion, homeDataModel.direccion)
            setTextOrDefault(tvColonia, homeDataModel.colonia)
            setTextOrDefault(tvPoblacion, homeDataModel.poblacion)
            setTextOrDefault(tvEstado, homeDataModel.estado)
            setTextOrDefault(tvTelefono, homeDataModel.telefono)
            setTextOrDefault(tvNegocio, homeDataModel.descNegocio)
        }
    }

    private fun setTextOrDefault(view: TextView, text: String?, defaultText: String = "__________________________________") {
        view.text = if (!text.isNullOrEmpty()) text else defaultText
    }
}