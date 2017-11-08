package com.example.asiantech.demostepper

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.item_vertical_step.view.*
import moe.feng.common.stepperview.IStepperAdapter
import moe.feng.common.stepperview.VerticalStepperItemView
import moe.feng.common.stepperview.VerticalStepperView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 08/11/2017.
 */
class StepAdapters : IStepperAdapter {

    private var mItemVerticals: MutableList<String>? = null
    private var mVertical: VerticalStepperView? = null

    constructor(itemVerticals: MutableList<String>, vertical: VerticalStepperView) {
        mItemVerticals = itemVerticals
        mVertical = vertical
    }

    override fun onCreateCustomView(index: Int, context: Context?, parent: VerticalStepperItemView?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_vertical_custom, parent, false)
        view.tvTitle.text = if (index == 0) context!!.getString(R.string.title_vertical_step_1) else context!!.getString(R.string.title_vertical_step_2)

        // Set button next
        view.btnNext.text = if (index == size() - 1) "Set error text" else context.getString(R.string.title_item_ok)
        view.btnNext.setOnClickListener {
            if (mVertical!!.nextStep()) {
                mVertical!!.setErrorText(0, "Text error!")
            }
        }

        // Set button prev
        view.btnPrev.text = if (index == 0) context.getString(R.string.title_item_toggle) else context.getString(R.string.title_item_cancel)
        view.btnPrev.setOnClickListener {
            if (index == 0) mVertical!!.nextStep()
            else mVertical!!.isAnimationEnabled = !mVertical!!.isAnimationEnabled
        }
        return view
    }

    override fun getSummary(index: Int): CharSequence? {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Html.fromHtml("Summarized if needed" + if (index == mItemVerticals!!.size) "; <b>isDone!</b>" else "", Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml("Summarized if needed" + if (index == mItemVerticals!!.size) "; <b>isDone!</b>" else "")
        }
    }

    override fun getTitle(index: Int): CharSequence = "Index " + index

    override fun size(): Int = mItemVerticals!!.size

    override fun onShow(index: Int) {
        // No-op.
    }

    override fun onHide(index: Int) {
        // No-op.
    }
}