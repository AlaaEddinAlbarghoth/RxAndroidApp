package com.alaaeddinalbarghoth.rxandroidapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alaaeddinalbarghoth.rxandroidapp.R
import com.alaaeddinalbarghoth.rxandroidapp.rx.RxBasics
import com.alaaeddinalbarghoth.rxandroidapp.rx.RxOperators

class MainActivity : AppCompatActivity() {

    lateinit var rxBasics: RxBasics
    lateinit var rxOperators: RxOperators

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
//        basicsTimer()
        startActivity(Intent(this, ApiActivity::class.java))
    }

    /* region Worked */
    private fun basicsTest() {
        rxBasics = RxBasics()
        rxBasics.testObservables()
    }
    /* endregion */

    private fun basicsTimer() {
        rxOperators = RxOperators()
        rxOperators.subscribe()
    }
}