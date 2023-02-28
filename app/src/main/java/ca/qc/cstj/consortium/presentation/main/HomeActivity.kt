package ca.qc.cstj.consortium.presentation.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.ActivityMainBinding
import ca.qc.cstj.consortium.presentation.delivery.DeliveriesActivity
import ca.qc.cstj.consortium.presentation.main.adapter.DeliveryRecyclerViewAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModels()

    private val deliveryRecyclerViewAdapter = DeliveryRecyclerViewAdapter((listOf()))

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Réception des StateFlow ---
        viewModel.homeUiState.onEach {
            when (it) {
                HomeUiState.Empty -> Unit
                is HomeUiState.Error -> Snackbar.make(
                    binding.root,
                    "Error",
                    Snackbar.LENGTH_INDEFINITE
                ).show() // Set Action on click ?? (refill?)
                is HomeUiState.Success -> {
                    val trader = it.trader
                    with(binding) {
                        txvElementB.text = String.format("%.2f",trader.blierium)
                        txvElementI.text = String.format("%.2f",trader.laspyx)
                        txvElementK.text = String.format("%.2f",trader.kreotrium)
                        txvElementSm.text=  String.format("%.2f",trader.smiathil)
                        txvElementVe.text = String.format("%.2f",trader.vethyx)
                    }
                }
            }
        }.launchIn(lifecycleScope)

        // Button Click Events ---

        binding.btnOpen.setOnClickListener {
            if (binding.edtTraderName.text.isNotEmpty()) {
                startActivity(
                    DeliveriesActivity.newIntent(
                        this,
                        binding.edtTraderName.text.toString()
                    )
                )
            } else {
                Snackbar.make(
                    binding.root,
                    "Le nom de commerçant ne peut être vide",
                    Snackbar.LENGTH_INDEFINITE
                ).show()
            }
        }

        binding.btnReloadCargo.setOnClickListener {
            viewModel.reloadCargo()
        }

        binding.btnUploadCargo.setOnClickListener {
            viewModel.emptyCargo()
        }

    }
}