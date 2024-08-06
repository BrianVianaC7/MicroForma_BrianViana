package com.example.micropago_brianviana.ui.home.clients.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.micropago_brianviana.R
import com.example.micropago_brianviana.domain.model.HomeDataModel

class HomeAdapter(
    private var clientList: List<HomeDataModel> = emptyList()
) : RecyclerView.Adapter<HomeViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(usersList: List<HomeDataModel>) {
        this.clientList = usersList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_clients, parent, false)
        )
    }

    override fun getItemCount(): Int = clientList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.render(clientList[position])
    }
}