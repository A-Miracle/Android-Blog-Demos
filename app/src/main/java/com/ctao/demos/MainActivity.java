package com.ctao.demos;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ctao.demos.base.RBaseAdapter;
import com.ctao.demos.base.RViewHolder;
import com.ctao.demos.blogcodes.mvc.MvcLoginAvtivity;
import com.ctao.demos.blogcodes.mvp.MvpLoginActivity;
import com.ctao.demos.blogcodes.mvvm.MvvmLoginAvtivity;
import com.ctao.demos.widget.WRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WRecyclerView recyclerView;
    private ArrayList<Class> clazzes = new ArrayList<>();
    {
       clazzes.add(MvcLoginAvtivity.class);
       clazzes.add(MvpLoginActivity.class);
       clazzes.add(MvvmLoginAvtivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (WRecyclerView) findViewById(R.id.wrv_content);
        DameAdapter adapter = new DameAdapter(clazzes);
        recyclerView.setAdapter(adapter);
    }

    private class DameAdapter extends RBaseAdapter<Class>{

        public DameAdapter(List<Class> data) {
            super(data);
        }

        @Override
        public void onBindRViewHolder(RViewHolder holder, int position) {
            holder.setText(R.id.tv_content, mData.get(position).getSimpleName());
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(MainActivity.this);
            textView.setTextSize(20);
            textView.setPadding(5,10,0,10);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setId(R.id.tv_content);
            RViewHolder holder = new RViewHolder(textView);
            return holder;
        }

        @Override
        public void onBindViewListener(RViewHolder holder, final int position) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, mData.get(position));
                    startActivity(intent);
                }
            });
        }
    }
}
