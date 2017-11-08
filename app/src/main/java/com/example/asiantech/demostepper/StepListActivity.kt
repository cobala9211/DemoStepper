package com.example.asiantech.demostepper

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_step_list.*
import moe.feng.common.stepperview.VerticalStepperItemView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 08/11/2017.
 */
class StepListActivity : AppCompatActivity() {

    private val mVerticals: MutableList<VerticalStepperItemView> = mutableListOf()
    private var mActivatedColorRes = R.color.material_blue_500
    private var mDoneIconRes = R.drawable.ic_done_white_16dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_list)
        initViews()
    }

    private fun initViews() {
        // Add verticals item step
        mVerticals.add(stepperFirst)
        mVerticals.add(stepperSecond)
        mVerticals.add(stepperThird)

        VerticalStepperItemView.bindSteppers(mVerticals[0], mVerticals[1], mVerticals[2])
        btnNextStepFirst.setOnClickListener { mVerticals[0].nextStep() }

        btnNextStepSecond.setOnClickListener { mVerticals[1].nextStep() }
        btnPrevStepSecond.setOnClickListener { mVerticals[1].prevStep() }
        btnErrorStepSecond.setOnClickListener {
            if (mVerticals[0].errorText != null) {
                mVerticals[0].errorText = null
            } else {
                mVerticals[0].errorText = "Test Error!"
            }
        }

        btnPrevStepThird.setOnClickListener { mVerticals[2].prevStep() }
        btnNextStepThird.setOnClickListener {
            Snackbar.make(findViewById(android.R.id.content), "Finish!", Snackbar.LENGTH_LONG)
                    .setAction("CLOSE", { Log.d("xxx", "close") })
                    .setActionTextColor(Color.RED)
                    .show()
        }

        // Implement change point color
        btnChangePointColor.setOnClickListener {
            mActivatedColorRes = if (mActivatedColorRes == R.color.material_blue_500) {
                R.color.material_deep_purple_500
            } else {
                R.color.material_blue_500
            }
            for (stepper in mVerticals) {
                stepper.setActivatedColorResource(mActivatedColorRes)
            }
        }

        // Implement change icon
        btnChangeDoneIcon.setOnClickListener {
            mDoneIconRes = if (mDoneIconRes == R.drawable.ic_done_white_16dp) {
                R.drawable.ic_check_item
            } else {
                R.drawable.ic_done_white_16dp
            }
            for (stepper in mVerticals) {
                stepper.setDoneIconResource(mDoneIconRes)
            }
        }
    }

}