package com.example.asiantech.demostepper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_step_custom.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 08/11/2017.
 */
class StepCustomActivity : AppCompatActivity() {
    private var mItemTitles: MutableList<String> = mutableListOf("test step 1", "test step 2", "test step 3", "test step 4", "test step 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_custom)
        verticalStepperCustom.stepperAdapter = StepAdapters(mItemTitles, verticalStepperCustom)
    }
}