package com.example.redscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var counter: TextView? = null;
    private var count: Int = 0;
    private var mainScreen: ConstraintLayout? = null;
    private var isStart: Boolean = false;
    private val name: String = "ТЫ ЛОХ";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter = findViewById(R.id.counter);
        mainScreen = findViewById(R.id.main_screen);
        counter?.text = count.toString();
        Thread {
            isStart = true;
            while(isStart) {
                Thread.sleep(1000);

                runOnUiThread {
                    if(count == 5) {
                        mainScreen?.setBackgroundColor(Color.RED);
                        counter?.text = name;
                    }
                    else {
                        counter?.text = count.toString();
                        count++;
                    }

                }
            }
        }.start();
    }

    override fun onDestroy() {
        super.onDestroy()
        isStart = false;
    }
}