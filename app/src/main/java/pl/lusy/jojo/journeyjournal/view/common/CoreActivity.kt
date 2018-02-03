package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity

import pl.lusy.jojo.journeyjournal.R

@SuppressLint("Registered")
open class CoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTaskDescriptionIfSupported()
    }

    private fun initTaskDescriptionIfSupported() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initTaskDescription()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initTaskDescription() {
        val taskColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val taskDescription = ActivityManager.TaskDescription(null, null, taskColor)
        setTaskDescription(taskDescription)
    }
}