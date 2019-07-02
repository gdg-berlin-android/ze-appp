package de.berlindroid.zeaapp.emails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import de.berlindroid.zeaapp.R
import kotlinx.android.synthetic.main.email_item.view.*

class EmailAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EmailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false))
    }

    override fun getItemCount() = 20

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is EmailViewHolder) {
            val text = "Email $position"
            holder.email.text = text
            holder.itemView.transitionName = text

            holder.itemView.setOnClickListener {

                val args = FragmentNavigatorExtras(
                    holder.itemView to text
                )

                val bundle = bundleOf(
                    "email" to text
                )

                it.findNavController().navigate(R.id.action_emailFragments_to_details, bundle, null, args)
            }
        }
    }

    inner class EmailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val email = itemView.email!!
    }

}