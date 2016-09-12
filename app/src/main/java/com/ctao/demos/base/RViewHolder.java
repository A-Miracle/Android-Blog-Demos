package com.ctao.demos.base;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctao.demos.WApplication;

/**
 * Created by A Miracle on 2016/9/12.
 */
public class RViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;

    public RViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public RViewHolder(int layoutId) {
        super(LayoutInflater.from(WApplication.getApplication()).inflate(layoutId, null, false));
        mViews = new SparseArray<>();
    }

    /** 通过ViewId获取控件 */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /** 通过ViewId获取控件 */
    @SuppressWarnings("unchecked")
    public static <T extends View> T getView(View rootView, int viewId) {
        SparseArray<View> views = null;

        Object tag = rootView.getTag();
        if (tag != null && tag instanceof SparseArray) {
            views = (SparseArray<View>)tag;
        }

        if(views == null){
            views = new SparseArray<>();
            rootView.setTag(views);
        }

        View view = views.get(viewId);
        if (view == null) {
            view = rootView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /** ImageView及子类专用 */
    public <T extends ImageView> RViewHolder setImageBitmap(int viewId, Bitmap bm) {
        T imageView = getView(viewId);
        imageView.setImageBitmap(bm);
        return this;
    }

    /** ImageView及子类专用 */
    public <T extends ImageView> RViewHolder setImageDrawable(int viewId, Drawable drawable) {
        T imageView = getView(viewId);
        imageView.setImageDrawable(drawable);
        return this;
    }

    /** ImageView及子类专用 */
    public <T extends ImageView> RViewHolder setImageResource(int viewId, int resId) {
        T imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    /** TextView及子类专用 */
    public <T extends TextView> RViewHolder setText(int viewId, CharSequence text) {
        T textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    /** TextView及子类专用 */
    public <T extends TextView> RViewHolder setText(int viewId, int resId) {
        T textView = getView(viewId);
        textView.setText(resId);
        return this;
    }

    /** CheckBox及子类专用 */
    public <T extends CheckBox> RViewHolder setChecked(int viewId, boolean checked) {
        T checkBox = getView(viewId);
        checkBox.setChecked(checked);
        return this;
    }

    /** View及子类专用 */
    public RViewHolder setTag(int viewId, Object tag) {
        getView(viewId).setTag(tag);
        return this;
    }
}
