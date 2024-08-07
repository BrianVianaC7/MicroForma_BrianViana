package com.example.micropago_brianviana.ui.home.clients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.micropago_brianviana.R
import com.example.micropago_brianviana.databinding.FragmentClientsBinding
import com.example.micropago_brianviana.ui.home.clients.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ClientsFragment : Fragment() {

    private lateinit var clientAdapter: HomeAdapter
    private val clientViewModel: ClientViewModel by viewModels()
    private var _binding: FragmentClientsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clientViewModel.getData()
        initUI()
    }

    private fun initUI() {
        initUIState()
        initLoader()
        initRecyclerView()
        initFilter()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                clientViewModel.data.collect {
                    clientAdapter.updateList(it)
                }
            }
        }
    }

    private fun initLoader() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                clientViewModel.isLoading.collect { loading ->
                    binding.pbar.isVisible = loading
                }
            }
        }
    }

    private fun initRecyclerView() {
        clientAdapter = HomeAdapter(emptyList())
        binding.rvClients.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = clientAdapter
        }
    }

    private fun initFilter() {
        binding.etFilterEt.addTextChangedListener { clientFilter ->
            val filteredList = clientViewModel.data.value.filter { client ->
                client.telefono!!.lowercase().contains(clientFilter.toString().trim().lowercase())
            }
            clientAdapter.updateList(filteredList)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClientsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}