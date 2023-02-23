package ca.qc.cstj.consortium.domain.presentation.delivery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.ActivityMainBinding
import ca.qc.cstj.consortium.domain.models.Delivery
import ca.qc.cstj.consortium.domain.models.Trader
import ca.qc.cstj.consortium.domain.presentation.main.HomeActivity

class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: DeliveryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    // Static Class
    companion object {
        fun newIntent(context: Context, traderName: String): Intent {
            val intent = Intent(context, DeliveriesActivity::class.java)
            intent.putExtra("TRADER_NAME", traderName)
            return intent
        }
    }

}