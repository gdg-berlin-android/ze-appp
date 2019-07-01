package de.berlindroid.zeaapp.emails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        }
    }

    inner class EmailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val email = itemView.email!!
    }

}