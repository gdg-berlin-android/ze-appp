package de.berlindroid.zeaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class WhereAreChetAndRomainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_where_are_chet_and_romain)

        findViewById<TextView>(R.id.chet_and_romain).setOnClickListener {
            Toast.makeText(this, "Here we are...", Toast.LENGTH_LONG).show()
        }
    }
}
