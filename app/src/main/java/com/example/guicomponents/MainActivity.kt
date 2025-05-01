package com.example.guicomponents

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import android.widget.TextView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private var currentTextSize = 18f
    private lateinit var sampleText: TextView
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleText = findViewById(R.id.sampleText)
        rootLayout = findViewById(R.id.rootLayout)

        val btnIncreaseSize: Button = findViewById(R.id.btnIncreaseSize)
        val btnChangeTextColor: Button = findViewById(R.id.btnChangeTextColor)
        val btnChangeBgColor: Button = findViewById(R.id.btnChangeBgColor)

        btnIncreaseSize.setOnClickListener {
            currentTextSize += 2f
            if (currentTextSize > 40f) currentTextSize = 18f // Reset if too big
            sampleText.textSize = currentTextSize
        }

        btnChangeTextColor.setOnClickListener {
            sampleText.setTextColor(getRandomColor())
        }

        btnChangeBgColor.setOnClickListener {
            rootLayout.setBackgroundColor(getRandomColor())
        }
    }

    private fun getRandomColor(): Int {
        val rnd = Random
        return Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}