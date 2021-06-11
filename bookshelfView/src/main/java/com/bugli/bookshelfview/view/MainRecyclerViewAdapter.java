package com.bugli.bookshelfview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bugli.bookshelfview.R;
import com.bugli.bookshelfview.utils.XYUtil;
import com.bugli.bookshelfview.comon.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<String> booksListCount = new ArrayList<>();
    List<String> booksInfo = new ArrayList<>();
    int windowX, windowY;

    MainRecyclerViewAdapter(Context context, List<String> list, List<String> list1) {
        this.context = context;
        //获得需要展示的数据
        booksListCount.addAll(list);
        booksInfo.addAll(list1);
        //获取屏幕尺寸
        windowX = XYUtil.getWinWH(context).x;
        windowY = XYUtil.getWinWH(context).y;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child_rv, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChildRecyclerViewAdapter childRecyclerViewAdapter;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.childRecyclerView.setLayoutManager(linearLayoutManager);

        childRecyclerViewAdapter = new ChildRecyclerViewAdapter(context, booksInfo, 0);
        holder.childRecyclerView.addItemDecoration(new SpaceItemDecoration(Constants.splitPx));

        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
    }

    @Override
    public int getItemCount() {
        return booksListCount.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView childRecyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            childRecyclerView = itemView.findViewById(R.id.child_rv);
        }
    }


}
