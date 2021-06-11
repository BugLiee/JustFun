package com.bugli.bookshelfview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bugli.bookshelfview.R;
import com.bugli.bookshelfview.utils.XYUtil;
import com.bugli.bookshelfview.comon.Constants;

import java.util.ArrayList;
import java.util.List;

class ChildRecyclerViewAdapter extends RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder> {
    //显示类型 0 simple 1 normal 2 advance
    int showType = 0;
    Context context;
    List<String> booksInfo = new ArrayList<>();
    int windowX, windowY;

    public ChildRecyclerViewAdapter(Context context, List<String> testlist, int showType) {
        this.context = context;
        this.showType = showType;
        booksInfo.addAll(testlist);
        //获取屏幕尺寸
        windowX = XYUtil.getWinWH(context).x;
        windowY = XYUtil.getWinWH(context).y;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (showType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_book_simple, parent, false);
        } else if (showType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_book_normal, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_book_advance, parent, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(booksInfo.get(position));
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.frameLayout.getLayoutParams();
        int normalWidth = (windowX - Constants.splitPx * 2 * 5) / 4;
        int height = (int) (normalWidth * 1.5);
        int simpleWidth = (windowX - Constants.splitPx * 2 * 10) / 9;
        int simpleHeight = simpleWidth * 4;
        if (showType == 0) {
            layoutParams.width = simpleWidth;
        } else if (showType == 1) {
            layoutParams.width = normalWidth;
        } else {
            layoutParams.width = windowX - Constants.splitPx * 4;
        }
        layoutParams.height = showType == 0 ? simpleHeight : height;
        holder.frameLayout.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return booksInfo.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        FrameLayout frameLayout;
        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.bookName);
            frameLayout = itemView.findViewById(R.id.root_l);
        }
    }
}
