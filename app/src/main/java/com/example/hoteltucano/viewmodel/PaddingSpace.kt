package com.example.hoteltucano.viewmodel

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PaddingSpace(private val paddingTop:Int,private val paddingBotton:Int,private val paddingLeft: Int,private val paddingRight:Int):RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

            outRect.top = paddingTop
            outRect.left = paddingLeft
            outRect.right = paddingRight
            outRect.bottom = paddingBotton

    }
}
