package de.berlindroid.zeaapp.emails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import de.berlindroid.zeaapp.R
import kotlinx.android.synthetic.main.email_list.view.*

class EmailFragments: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.email_list, container, false).apply {
            list.apply {
                layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
                adapter = EmailAdapter()
            }
        }
    }
}