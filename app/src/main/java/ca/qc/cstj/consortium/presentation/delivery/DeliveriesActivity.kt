package ca.qc.cstj.consortium.presentation.delivery

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.ActivityMainBinding
import ca.qc.cstj.consortium.domain.models.Delivery
import ca.qc.cstj.consortium.presentation.main.HomeActivity

class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : DeliveryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deliveries)
    }

    // Static Class
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DeliveriesActivity::class.java)
        }
    }

}