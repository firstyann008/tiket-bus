package com.example.praktikum3
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parentLayout = findViewById<LinearLayout>(R.id.main)
        val abjad = ('A'..'Z').toList()
        for (i in abjad.indices step 3) {
            val rowLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            for (j in 0 until 3) {
                if (i + j < abjad.size) {
                    val huruf = abjad[i + j]
                    val button = MaterialButton(this).apply {
                        text = huruf.toString()
                        textSize = 18f
                        layoutParams =
                            LinearLayout.LayoutParams(0,
                                LinearLayout.LayoutParams.WRAP_CONTENT, 1f)

                        setBackgroundColor(resources.getColor(R.color.primary, null))

                        setTextColor(resources.getColor(R.color.white, null))
                        cornerRadius = 50 // Rounded button
                        elevation = 6f // Efek shadow
                        setOnClickListener {
                            val intent =
                                Intent(this@MainActivity, SecondActivity::class.java)
                            intent.putExtra("HURUF",
                                huruf.toString())
                            startActivity(intent)
                        }
                    }
                    rowLayout.addView(button)
                }
            }
            parentLayout.addView(rowLayout)
        }
    }