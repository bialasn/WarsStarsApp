package com.nbialas.warsstarapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.inverce.mod.v2.events.Event
import com.nbialas.warsstarapp.listeners.ProgressBarInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProgressBarInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showProgressBar(show: Boolean) {
        progressBar.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }


    override fun onPause() {
        super.onPause()
        Event.Bus.unregister(ProgressBarInterface::class.java, this)
    }

    override fun onResume() {
        super.onResume()
        Event.Bus.register(ProgressBarInterface::class.java, this)
    }
}