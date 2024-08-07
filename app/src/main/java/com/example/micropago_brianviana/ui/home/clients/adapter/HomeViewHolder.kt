package com.example.micropago_brianviana.ui.home.clients.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.micropago_brianviana.databinding.ItemsClientsBinding
import com.example.micropago_brianviana.domain.model.HomeDataModel

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemsClientsBinding.bind(view)

    fun render(homeDataModel: HomeDataModel) {
        binding.apply {

            tvNoAfiliacion.text = homeDataModel.noAfiliacion
            tvCliente.text = homeDataModel.descCliente
            tvServicio.text = homeDataModel.descServicio
            tvDescripcionCorta.text = homeDataModel.descCorta
            tvFechaAlta.text = homeDataModel.fecalta
            tvFechaCierre.text = homeDataModel.fecCierre
            tvDireccion.text = homeDataModel.direccion
            tvColonia.text = homeDataModel.colonia
            tvPoblacion.text = homeDataModel.poblacion
            tvEstado.text = homeDataModel.estado
            tvTelefono.text = homeDataModel.telefono
            tvNegocio.text = homeDataModel.descNegocio
        }
    }
}