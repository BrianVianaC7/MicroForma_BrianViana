package com.example.micropago_brianviana.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.micropago_brianviana.R
import com.example.micropago_brianviana.data.network.request.LoginUserRequest
import com.example.micropago_brianviana.databinding.ActivityMainBinding
import com.example.micropago_brianviana.ui.dialog.OnFailureDialog
import com.example.micropago_brianviana.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initLoader()
    }

    private fun initUI() {
        initSignIn()
        /*binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }*/
    }

//"username": "android",
//"password": "LuneS2024*",
//"version": "1.0.0",
//"origin": "mobile"

    private fun initSignIn() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    try {
                        val result = loginViewModel.loginUser(
                            LoginUserRequest(
                                username = email,
                                password = password,
                                version = "1.0.0",
                                origin = "mobile"
                            )
                        )
                        if (result.accessToken != null) {
                            val intent = Intent(this@MainActivity, HomeActivity::class.java)
                            startActivity(intent)
                        } else {
                            val errorMessages = result.messages.joinToString("\n")
                            val dialog = OnFailureDialog.newInstance(errorMessages)
                            dialog.show(supportFragmentManager, "OnFailureDialog")
                        }
                    } catch (e: Exception) {
                        val dialog = OnFailureDialog.newInstance(e.message.toString())
                        dialog.show(supportFragmentManager, "OnFailureDialog")
                    }
                }
            } else {
                val dialog = OnFailureDialog.newInstance("Please enter both username and password.")
                dialog.show(supportFragmentManager, "OnFailureDialog")
            }
        }
    }

    private fun initLoader() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.isLoading.collect { loading ->
                    binding.pbar.isVisible = loading
                }
            }
        }
    }

}