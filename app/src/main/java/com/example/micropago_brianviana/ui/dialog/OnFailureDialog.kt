package com.example.micropago_brianviana.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.micropago_brianviana.R
import com.example.micropago_brianviana.databinding.FragmentOnFailureBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnFailureDialog : DialogFragment() {

    private var _binding: FragmentOnFailureBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        val message = arguments?.getString("message") ?: "Default message"
        binding.tvSubTitle.text = message
        initNavigation()
    }

    private fun initNavigation() {
        binding.tvDismiss.setOnClickListener {
            dismiss()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnFailureBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance(message: String): OnFailureDialog {
            val args = Bundle().apply {
                putString("message", message)
            }
            return OnFailureDialog().apply {
                arguments = args
            }
        }
    }

}