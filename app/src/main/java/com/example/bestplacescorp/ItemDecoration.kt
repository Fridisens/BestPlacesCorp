package com.example.bestplacescorp

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
class ItemDecoration (private  val spaceHeight: Int) : RecyclerView.ItemDecoration(){

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        //Add space between items in RecycleView
        outRect.top = spaceHeight
        outRect.bottom = spaceHeight
    }
}
