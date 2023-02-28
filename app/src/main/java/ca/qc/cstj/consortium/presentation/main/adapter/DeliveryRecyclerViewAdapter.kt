package ca.qc.cstj.consortium.presentation.main.adapter

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.domain.models.Delivery

class DeliveryRecyclerViewAdapter(
    var deliveries: List<Delivery> = listOf()
)
//    : RecyclerView.Adapter<DeliveryRecyclerViewAdapter.ViewHolder>()
{

//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): DeliveryRecyclerViewAdapter.ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cargo, parent, false)
//        return RecyclerView.ViewHolder(view)
//    }


}