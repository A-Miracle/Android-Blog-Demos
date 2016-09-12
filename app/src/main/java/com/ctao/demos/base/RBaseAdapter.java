package com.ctao.demos.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by A Miracle on 2016/9/12.
 */
public abstract class RBaseAdapter<T> extends RecyclerView.Adapter<RViewHolder>{
	
	protected List<T> mData;
	
	public RBaseAdapter(List<T> data) {
		mData = data;
	}

	@Override
	public int getItemCount() {
		return mData.size();
	}

	@Override
	public final void onBindViewHolder(RViewHolder holder, int position){
		onBindRViewHolder(holder, position);
		onBindViewListener(holder, position);
	}

	/**绑定item数据显示*/
	protected abstract void onBindRViewHolder(RViewHolder holder, int position);

	/**创建新的ViewHolder给定类型的代表一个项目*/
	@Override
	public abstract RViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

	/**绑定Item的事件*/
	public void onBindViewListener(RViewHolder holder, int viewType){
	}
}
