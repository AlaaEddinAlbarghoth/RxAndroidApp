package com.alaaeddinalbarghoth.rxandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alaaeddinalbarghoth.rxandroidapp.rx.RxBasics

class MainActivity : AppCompatActivity() {

    lateinit var rxBasics: RxBasics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        basicsTest()
    }

    private fun basicsTest() {
        rxBasics = RxBasics()
        rxBasics.testObservables()
    }
}