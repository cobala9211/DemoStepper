package com.example.asiantech.demostepper

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_step_adapter.*
import kotlinx.android.synthetic.main.item_vertical_step.view.*
import moe.feng.common.stepperview.IStepperAdapter
import moe.feng.common.stepperview.VerticalStepperItemView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 08/11/2017.
 */
class StepAdapterActivity : AppCompatActivity(), IStepperAdapter {

    override fun onCreateCustomView(index: Int, context: Context?, parent: VerticalStepperItemView?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_vertical_step, parent, false)
        view.tvTitle.text = if (index == 0) getString(R.string.title_vertical_step_1) else getString(R.string.title_vertical_step_2)

        // Set button next
        view.btnNext.text = if (index == size() - 1) "Set error text" else getString(R.string.title_item_ok)
        view.btnNext.setOnClickListener {
            if (verticalStepperView.nextStep()) {
                verticalStepperView.setErrorText(0, "Text error!")
            }
        }

        // Set button prev
        view.btnPrev.text = if (index == 0) getString(R.string.title_item_toggle) else getString(R.string.title_item_cancel)
        view.btnPrev.setOnClickListener {
            if (index == 0) verticalStepperView.nextStep()
            else verticalStepperView.isAnimationEnabled = !verticalStepperView.isAnimationEnabled
        }
        return view
    }

    override fun getSummary(index: Int): CharSequence? {
        return when (index) {
            0 -> {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    Html.fromHtml("Summarized if needed" + if (verticalStepperView.currentStep > index) "; <b>isDone!</b>" else "", Html.FROM_HTML_MODE_LEGACY)
                } else {
                    Html.fromHtml("Summarized if needed" + if (verticalStepperView.currentStep > index) "; <b>isDone!</b>" else "")
                }
            }
            1 -> {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    Html.fromHtml("Last step" + if (verticalStepperView.currentStep > index) "; <b>isDone!</b>" else "", Html.FROM_HTML_MODE_LEGACY)
                } else {
                    Html.fromHtml("Last step" + if (verticalStepperView.currentStep > index) "; <b>isDone!</b>" else "")
                }
            }
            else -> {
                null
            }
        }
    }

    override fun getTitle(index: Int): CharSequence = "Step " + index

    override fun size(): Int = 3

    override fun onShow(index: Int) {
        // No-op.
    }

    override fun onHide(index: Int) {
        // No-op.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_adapter)
        verticalStepperView.stepperAdapter = this
    }
}