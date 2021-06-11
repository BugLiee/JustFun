package com.bugli.bookshelfview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bugli.bookshelfview.R;

import java.util.ArrayList;
import java.util.List;

public class BookShelfView extends LinearLayout {
    RecyclerView recyclerView;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;


    public BookShelfView(Context context) {
        super(context);
        initView(context);
    }

    public BookShelfView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTypeArray(context, attrs);
        initView(context);
    }

    public BookShelfView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeArray(context, attrs);
        initView(context);
    }

    /**
     * 从xml解析布局
     */
    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_bookshelf, this, true);
        recyclerView = findViewById(R.id.main_rv);
        List<String> testlist = new ArrayList<>();
        testlist.add("22222");
        testlist.add("22222");
        testlist.add("22222");
        testlist.add("22222");
        testlist.add("22222");

        List<String> testlist1 = new ArrayList<>();
        // 0:行限制9个
        // 1:行限制4个
        // 2:行限制1个
        testlist1.add("如果嗯");
        testlist1.add("如果嗯");
        testlist1.add("如果嗯");
        testlist1.add("如果嗯");
        testlist1.add("如果嗯");
        testlist1.add("如果");
        testlist1.add("如果");
        testlist1.add("如果");
        testlist1.add("如果");


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(context, testlist,testlist1);
        recyclerView.setAdapter(mainRecyclerViewAdapter);


//        recyclerView.setBackgroundColor(Color.YELLOW);
    }

    /**
     * 从attrs初始化自定义View的自定义属性
     */
    private void initTypeArray(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.bookShelfViewStyle);
//        mBgColor = a.getColor(R.styleable.CusTitleBar_bg_color, Color.YELLOW);
//        mTitleText = a.getString(R.styleable.CusTitleBar_title_text);
//        mTextColor = a.getColor(R.styleable.CusTitleBar_text_color,Color.RED);
        a.recycle();
    }


    /**
     * 自定义View使用onDraw，自定义ViewGroup使用drawChild
     */
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        super.drawChild(canvas, child, drawingTime);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);

        float[] lines = {100, 100, 200, 200, 200, 200, 300, 200, 300, 200, 400, 300};
        canvas.drawLines(lines, paint);

        String text = "我是八维人";
        paint.setTextSize(60);
        Path path = new Path();
        path.addCircle(300, 300, 200, Path.Direction.CW);
        canvas.drawTextOnPath(text, path, 0, 0, paint);


        return super.drawChild(canvas, child, drawingTime);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
