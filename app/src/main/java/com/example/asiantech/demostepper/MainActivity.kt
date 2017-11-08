package com.example.asiantech.demostepper

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStepList.setOnClickListener { startActivity(Intent(this, StepListActivity::class.java)) }
        btnStepAdapter.setOnClickListener { startActivity(Intent(this, StepAdapterActivity::class.java)) }
        btnStepCustom.setOnClickListener { startActivity(Intent(this, StepCustomActivity::class.java)) }
    }
}
