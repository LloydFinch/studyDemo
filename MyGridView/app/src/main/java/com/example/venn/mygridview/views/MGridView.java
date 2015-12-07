package com.example.venn.mygridview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.venn.mygridview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87028 on 2015/12/7.
 */
public class MGridView extends LinearLayout {

    private Context context;
    private List<View> viewList;//GridView中的所有子View
    private int col;//列数
    private int row;//行数

    public MGridView(Context context) {
        super(context, null);
    }

    public MGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        viewList = new ArrayList<>();
        this.setOrientation(VERTICAL);
        this.setGravity(Gravity.CENTER_VERTICAL);

        //从xml中取出定义的列数赋值给col，默认为1列
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.mGridView);
        col = typedArray.getInteger(R.styleable.mGridView_col, 1);
    }


    //向GridView中添加View
    public void addChild(View view) {

        viewList.add(view);
        int size = viewList.size();
        row = (int) Math.ceil(((double) size) / ((double) col));

        //应该画到哪一列
        int nCol = (size - 1) % col;

        //是否需要添加新行
        boolean needAdd = false;
        for (int i = 1; i <= row; i++) {

            //只画最新的一行
            if (i == row) {
                LinearLayout layout = (LinearLayout) this.getChildAt(i - 1);
                if (layout == null) {
                    needAdd = true;
                    layout = new LinearLayout(context);
                    layout.setOrientation(HORIZONTAL);
                    LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.weight = 1;
                    layout.setLayoutParams(params);
                }

                for (int j = 0; j < col; j++) {

                    //只画最新的一行中添加到的那一列
                    if (j == nCol) {

                        //添加列
                        layout.addView(view);
                    }
                }

                //添加行
                if (needAdd) {
                    addView(layout);
                }
            }
        }
    }
}
