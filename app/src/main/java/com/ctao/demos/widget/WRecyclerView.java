package com.ctao.demos.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by A Miracle on 2016/9/12.
 */
public class WRecyclerView extends RecyclerView {

    public WRecyclerView(Context context) {
        this(context,null);
    }

    public WRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        // 设置RecyclerView的布局管理(ListView)
        LinearLayoutManager layout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        setLayoutManager(layout);

        // 设置Item间分割线(还可以通过margin)
        ItemDecoration decor = new RecyclerItemDecoration(context, RecyclerItemDecoration.VERTICAL_LIST);
        addItemDecoration(decor);

        // 设置Item增加删除动画(这是默认动画， 还可以去github上找更合适的)
        setItemAnimator(new DefaultItemAnimator());

        /*<!-- 定制RecyclerView分隔线 -->
        <item name="android:listDivider">@drawable/divider</item>*/
    }
}
