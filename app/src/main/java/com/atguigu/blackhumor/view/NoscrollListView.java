package com.atguigu.blackhumor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class NoscrollListView extends ListView {
    public NoscrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
