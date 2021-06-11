package com.bugli.bookshelfview.view;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = mSpace;
        outRect.bottom = mSpace * 2;
        outRect.top = mSpace * 2;


        //如果是第一个子元素
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = mSpace * 2;
        } else {
            outRect.left = mSpace;
        }

    }

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }
}
